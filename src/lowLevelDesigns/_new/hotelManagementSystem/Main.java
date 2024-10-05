package lowLevelDesigns._new.hotelManagementSystem;

import lowLevelDesigns._new.hotelManagementSystem.payment.CashPayment;
import lowLevelDesigns._new.hotelManagementSystem.payment.Payment;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        HotelManagementSystem hotelManagementSystem= HotelManagementSystem.getInstance();

        Guest guest1= new Guest("G001", "John", "joh@gmail", "1234567890");
        Guest guest2= new Guest("G002", "Doe", "doe@gmail", "1234567890");
        hotelManagementSystem.addGuest(guest1);
        hotelManagementSystem.addGuest(guest2);

        Room room1= new Room("R001", RoomType.DELUXE, 1000);
        Room room2= new Room("R002", RoomType.SUITE, 2000);
        hotelManagementSystem.addRoom(room1);
        hotelManagementSystem.addRoom(room2);

        LocalDate checkInDate= LocalDate.now();
        LocalDate checkOutDate= LocalDate.now().plusDays(2);

        Reservation reservation1= hotelManagementSystem.bookRoom(guest1, room1, checkInDate, checkOutDate);
        if (reservation1!=null) {
            System.out.println("Room booked successfully");
        }
        else {
            System.out.println("Room not available");
        }

        assert reservation1 != null;
        hotelManagementSystem.checkin(reservation1.getReservationId());
        System.out.println("Room checked in");

        Payment payment= new CashPayment();
        hotelManagementSystem.checkOut(reservation1.getReservationId(), payment);
        System.out.println("Room checked out");
    }
}
