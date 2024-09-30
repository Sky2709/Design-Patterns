package lowLevelDesigns._new.airLineManagementSystem;

import lowLevelDesigns._new.airLineManagementSystem.booking.Booking;
import lowLevelDesigns._new.airLineManagementSystem.flight.Flight;
import lowLevelDesigns._new.airLineManagementSystem.seat.Seat;
import lowLevelDesigns._new.airLineManagementSystem.seat.SeatType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        run();

    }

    private static void run() {
        AirlineManagementSystem airlineManagementSystem = AirlineManagementSystem.getInstance();

        Passenger passenger1= new Passenger("P001", "Swayam", "swayam@gmail", "1234567890");
        Passenger passenger2= new Passenger("P002", "Swayam", "swayam@gmail", "1234567890");

        LocalDateTime departureTime1= LocalDateTime.now().plusDays(1);
        LocalDateTime arrivalTime1= departureTime1.plusHours(2);
        //for ex if current date is 2021-08-01 10:00:00 then departure time will be 2021-08-02 12:00:00 and arrival time will be 2021-08-02 14:00:00
        Flight flight1= new Flight("F001", "Patna", "Delhi", departureTime1, arrivalTime1);

        LocalDateTime departureTime2= LocalDateTime.now().plusDays(3);
        LocalDateTime arrivalTime2= departureTime2.plusHours(2);
        //for ex if current date is 2021-08-01 10:00:00 then departure time will be 2021-08-04 12:00:00 and arrival time will be 2021-08-04 14:00:00
        Flight flight2= new Flight("F002", "Patna", "Mumbai", departureTime2, arrivalTime2);

        airlineManagementSystem.addFlight(flight1);
        airlineManagementSystem.addFlight(flight2);

        Aircraft aircraft1= new Aircraft("A001", "Boeing 747", 100);
        Aircraft aircraft2= new Aircraft("A002", "Boeing 777", 200);
        airlineManagementSystem.addAircraft(aircraft1);
        airlineManagementSystem.addAircraft(aircraft2);

        System.out.println("Search Flight from Patna to Delhi on "+LocalDate.now().plusDays(1));
        List<Flight> searchResult=airlineManagementSystem.searchFlight("Patna", "Delhi", LocalDate.now().plusDays(1));
        System.out.println("Search Results: ");
        for (Flight flight: searchResult){
            System.out.println("Flight Id: "+flight.getFlightNumber() + " Departure Time: "+flight.getDepartureTime() + " Arrival Time: "+flight.getArrivalTime() + " From : "+flight.getSource() + " To: "+flight.getDestination());
        }

        Seat seat1= new Seat(SeatType.BUSINESS, "25A");
        Booking booking1= airlineManagementSystem.bookFlight(flight1, passenger1, seat1, 1000);

        if (booking1!=null) {
            System.out.println("Booking Successful: " + booking1.getBookingNumber());
        }
        else {
            System.out.println("Booking Failed");
        }

        airlineManagementSystem.cancelBooking(booking1.getBookingNumber());
        System.out.println("Booking Cancelled: "+booking1.getBookingNumber());
    }
}
