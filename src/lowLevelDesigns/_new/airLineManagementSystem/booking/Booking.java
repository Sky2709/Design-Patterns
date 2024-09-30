package lowLevelDesigns._new.airLineManagementSystem.booking;

import lowLevelDesigns._new.airLineManagementSystem.Passenger;
import lowLevelDesigns._new.airLineManagementSystem.flight.Flight;
import lowLevelDesigns._new.airLineManagementSystem.seat.Seat;

public class Booking {
    private String bookingNumber;
    private Flight flightNumber;
    private Passenger passenger;
    private Seat seat;
    private double price;
    private BookingStatus bookingStatus;

    public Booking(String bookingNumber, Flight flightNumber, Passenger passenger, Seat seat, double price) {
        this.bookingNumber = bookingNumber;
        this.flightNumber = flightNumber;
        this.passenger = passenger;
        this.seat = seat;
        this.price = price;
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public void cancel() {
        this.bookingStatus = BookingStatus.CANCELLED;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }
}
