package lowLevelDesigns._new.airLineManagementSystem.seat;

public class Seat {
    private String seatNumber;
    private SeatType seatType;
    private SeatStatus seatStatus;

    public Seat(SeatType seatType, String seatNumber) {
        this.seatType = seatType;
        this.seatNumber = seatNumber;
        this.seatStatus = SeatStatus.AVAILABLE;
    }
}
