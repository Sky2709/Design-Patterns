package lowLevelDesigns._new.carRentalSystem;


import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        CarRentalSystem carRentalSystem = CarRentalSystem.getInstance();

        carRentalSystem.addCar(new Car("Toyota", "Camry", 2015, "ABC123", 50));
        carRentalSystem.addCar(new Car("Toyota", "Corolla", 2016, "XYZ123", 200));
        carRentalSystem.addCar(new Car("Honda", "Accord", 2017, "DEF123", 100));

        Customer customer1 = new Customer("C001", "Alice", "9874569850", "DL01245");

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(5);
        List<Car> availableCars = carRentalSystem.searchCars("Toyota", "Camry", startDate, endDate);

        if (!availableCars.isEmpty()) {
            Car selectedCar = availableCars.get(0);

            Reservation reservation = carRentalSystem.makeReservation(customer1, selectedCar, startDate, endDate);
            if (reservation != null) {
                boolean paymentSuccess = carRentalSystem.processPayment(reservation);
                if (paymentSuccess) {
                    System.out.println("Reservation successful. Reservation ID: " + reservation.getReservationId());
                } else {
                    System.out.println("Payment failed. Reservation canceled.");
                    carRentalSystem.cancelReservation(reservation.getReservationId());
                }
            } else {
                System.out.println("Selected car is not available for the given dates.");
            }
        } else {
            System.out.println("No cars available for the given dates.");
        }
    }
}
