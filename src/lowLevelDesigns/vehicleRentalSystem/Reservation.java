package lowLevelDesigns.vehicleRentalSystem;

import behaviouralDP.strategyDP.withoutStrategyDP.Vehicle;

import java.util.Date;

public class Reservation {
    int reservationId;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Date dateBookedFrom;
    Date dateBookedTo;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickupLocation;
    Location dropLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;
    Location location;


    public int createReserve(Vehicle vehicle, User user) {
        reservationId=1221;
        this.user=user;
        this.vehicle=vehicle;
        reservationType=ReservationType.DAILY;
        reservationStatus=ReservationStatus.SCHEDULED;
        return reservationId;
    }
}
