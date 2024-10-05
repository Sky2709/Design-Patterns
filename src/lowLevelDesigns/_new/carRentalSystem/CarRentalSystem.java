package lowLevelDesigns._new.carRentalSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CarRentalSystem {
    private static CarRentalSystem carRentalSystemInstance;
    private Map<String, Car> cars;
    private Map<String, Reservation> reservations;
    private PaymentProcessor paymentProcessor;

    private CarRentalSystem() {
        this.cars = new ConcurrentHashMap<>();
        this.reservations = new ConcurrentHashMap<>();
        paymentProcessor = new CreditCardPaymentProcessor();
    }

    public static synchronized CarRentalSystem getInstance() {
        if (carRentalSystemInstance == null) {
            carRentalSystemInstance = new CarRentalSystem();
        }
        return carRentalSystemInstance;
    }

    public void addCar(Car car) {
        cars.put(car.getLicensePlate(), car);
    }

    public void removeCar(String licensePlate) {
        cars.remove(licensePlate);
    }

    public List<Car> searchCars(String make, String model, LocalDate startDate, LocalDate endDate) {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars.values()) {
            if (car.getMake().equalsIgnoreCase(make) &&
                    car.getModel().equalsIgnoreCase(model) &&
                    car.isAvailable()) {
                if (isCarAvailable(car, startDate, endDate)) {
                    availableCars.add(car);
                }
            }
        }
        return availableCars;
    }

    private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
        for (Reservation reservation : reservations.values()) {
            if (reservation.getCar().equals(car)) {
                if (startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate())) {
                    return false;
                }
            }
        }
        return true;
    }

    public synchronized Reservation makeReservation(Customer customer, Car car, LocalDate startDate, LocalDate endDate){
        if (isCarAvailable(car,startDate,endDate)){
            String reservationId=generateId();
            Reservation reservation= new Reservation(reservationId, customer,car,startDate,endDate);
            reservations.put(reservationId,reservation);
            car.setAvailable(false);
//            System.out.println("Reservation made: " + reservationId + "for Car " + reservation.getCar().getModel());
            return reservation;
        }
        return null;
    }

    public synchronized void cancelReservation(String reservationId){
        Reservation reservation= reservations.remove(reservationId);
        if (reservation!=null){
            reservation.getCar().setAvailable(true);
        }
    }

    public boolean processPayment(Reservation reservation){
        return paymentProcessor.processPayment(reservation.getTotalPrice());
    }

    private String generateId() {
        return "RES" + UUID.randomUUID().toString().substring(0,6).toUpperCase();
    }
}
