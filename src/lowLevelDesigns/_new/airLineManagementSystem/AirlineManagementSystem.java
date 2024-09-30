package lowLevelDesigns._new.airLineManagementSystem;

import lowLevelDesigns._new.airLineManagementSystem.booking.Booking;
import lowLevelDesigns._new.airLineManagementSystem.booking.BookingManager;
import lowLevelDesigns._new.airLineManagementSystem.flight.Flight;
import lowLevelDesigns._new.airLineManagementSystem.flight.FlightSearch;
import lowLevelDesigns._new.airLineManagementSystem.payment.Payment;
import lowLevelDesigns._new.airLineManagementSystem.payment.PaymentProcessor;
import lowLevelDesigns._new.airLineManagementSystem.seat.Seat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AirlineManagementSystem {
    private static AirlineManagementSystem airlineManagementSystemInstance;
    private List<Flight> flights;
    private List<Aircraft> aircrafts;
    private FlightSearch flightSearch;
    private BookingManager bookingManager;
    private PaymentProcessor paymentProcessor;

    private AirlineManagementSystem() {
        this.flights= new ArrayList<>();
        this.aircrafts= new ArrayList<>();
        flightSearch = new FlightSearch(flights);
        bookingManager = BookingManager.getInstance();
        paymentProcessor = PaymentProcessor.getInstance();
    }

    public static AirlineManagementSystem getInstance() {
        if (airlineManagementSystemInstance == null) {
            airlineManagementSystemInstance = new AirlineManagementSystem();
        }
        return airlineManagementSystemInstance;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    public List<Flight> searchFlight(String source, String destination, LocalDate date) {
        return flightSearch.flightSearch(source, destination, date);
    }

    public Booking bookFlight(Flight flight, Passenger passenger, Seat seat, double price) {
        return bookingManager.createBooking(flight, passenger, seat, price);
    }

    public void cancelBooking(String bookingId) {
        bookingManager.cancelBooking(bookingId);
    }

    public void processPayment(Payment payment) {
        paymentProcessor.processPayment(payment);
    }
}
