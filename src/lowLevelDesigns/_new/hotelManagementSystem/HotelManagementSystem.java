package lowLevelDesigns._new.hotelManagementSystem;

import lowLevelDesigns._new.hotelManagementSystem.payment.Payment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HotelManagementSystem {
    private static HotelManagementSystem hotelManagementSystemInstance;
    private Map<String, Guest> guestsMap;
    private Map<String, Room> roomsMap;
    private Map<String, Reservation> reservationsMap;

    private HotelManagementSystem() {
        this.guestsMap= new ConcurrentHashMap<>();
        this.roomsMap = new ConcurrentHashMap<>();
        this.reservationsMap = new ConcurrentHashMap<>();
    }

    public static synchronized HotelManagementSystem getInstance() {
        if (hotelManagementSystemInstance == null) {
            hotelManagementSystemInstance = new HotelManagementSystem();
        }
        return hotelManagementSystemInstance;
    }

    public void addGuest(Guest guest) {
        guestsMap.put(guest.getGuestId(), guest);
    }

    public Guest getGuest(String guestId) {
        return guestsMap.get(guestId);
    }

    public void addRoom(Room room) {
        roomsMap.put(room.getRoomId(), room);
    }

    public Room getRoom(String roomId) {
        return roomsMap.get(roomId);
    }

    public synchronized Reservation bookRoom(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate ){
        if (room.getRoomStatus()==RoomStatus.AVAILABLE){
            room.bookRoom();
            String reservationId= generateReservationId();
            Reservation reservation= new Reservation(reservationId,guest,room,checkInDate,checkOutDate);
            reservationsMap.put(reservationId,reservation);
            return reservation;
        }
        return null;
    }

    public synchronized void cancelReservation(String reservationId){
        Reservation reservation=reservationsMap.get(reservationId);
        if (reservation!=null){
            reservation.cancel();
            reservationsMap.remove(reservationId);
        }
    }

    public synchronized void checkin(String reservationId){
        Reservation reservation=reservationsMap.get(reservationId);
        if (reservation!=null && reservation.getReservationStatus()==ReservationStatus.CONFIRMED){
            reservation.getRoom().checkIn();
        }
        else {
            throw new RuntimeException("Reservation not found or not confirmed");
        }
    }

    public synchronized void checkOut(String reservationId, Payment payment){
        Reservation reservation= reservationsMap.get(reservationId);
        if (reservation!= null && reservation.getReservationStatus()==ReservationStatus.CONFIRMED){
            Room room= reservation.getRoom();
            double amount =room.getPrice() * ChronoUnit.DAYS.between(reservation.getCheckInDate(),reservation.getCheckOutDate());
            if (payment.processPayment(amount)){
                room.checkOut();
                reservationsMap.remove(reservationId);
            }
            else {
                throw new IllegalStateException("Payment failed");
            }
        }
        else{
            throw new IllegalStateException("Reservation not found or not confirmed");
        }
    }

    private String generateReservationId() {
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
