package lowLevelDesigns._new.airLineManagementSystem.booking;

import lowLevelDesigns._new.airLineManagementSystem.Passenger;
import lowLevelDesigns._new.airLineManagementSystem.flight.Flight;
import lowLevelDesigns._new.airLineManagementSystem.seat.Seat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingManager {
    private static BookingManager bookingManagerInstance;
    private Map<String, Booking> bookings;
    private Object lock= new Object();
    private AtomicInteger bookingIdCounter= new AtomicInteger(0);

    private BookingManager() {
        this.bookings = new HashMap<>();
    }

    public static BookingManager getInstance(){
        if (bookingManagerInstance==null){
            bookingManagerInstance=new BookingManager();
        }
        return bookingManagerInstance;
    }

    public Booking createBooking(Flight flight, Passenger passenger, Seat seat, double price){
        String bookingId= generateBookingId();
        Booking booking= new Booking(bookingId, flight, passenger, seat, price);
        // Add booking to the bookings map in a thread safe way because multiple threads can try to book at the same time
        synchronized (lock){
            bookings.put(bookingId,booking);
        }
        return booking;
    }

    public void cancelBooking(String bookingId){
        // Cancel booking in a thread safe way because multiple threads can try to cancel at the same time
        synchronized (lock){
            Booking booking=bookings.get(bookingId);
            if (booking!=null){
                booking.cancel();
                bookings.remove(bookingId);
            }
        }
    }

    private String generateBookingId() {
        int bookingId=bookingIdCounter.incrementAndGet();
        String timestamp= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "BK" + timestamp + String.format("%06d", bookingId);
    }
}
