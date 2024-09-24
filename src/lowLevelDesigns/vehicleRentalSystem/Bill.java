package lowLevelDesigns.vehicleRentalSystem;

public class Bill {
    Reservation reservation;
    double amount;
    boolean isPaid;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.amount = computeAmount();
        this.isPaid = false;
    }

    private double computeAmount() {
        return 100.0;
    }
}
