package lowLevelDesigns._new.hotelManagementSystem;

import java.time.LocalDate;

public class Reservation {
    private String reservationId;
    private Guest guest;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private ReservationStatus reservationStatus;


    public Reservation(String reservationId, Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.reservationId = reservationId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.reservationStatus=ReservationStatus.CONFIRMED;
    }

    public synchronized void cancel(){
        if (reservationStatus==ReservationStatus.CONFIRMED){
            reservationStatus=ReservationStatus.CANCELLED;
            room.checkOut();
        }
        else {
            throw new IllegalStateException("Reservation is not confirmed yet");
        }
    }

    public String getReservationId() {
        return reservationId;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }
}
