package lowLevelDesigns._new.airLineManagementSystem;

public class Aircraft {
    private String tailNumber;
    private String model;
    private int totalSeats;

    public Aircraft(String tailNumber, String model, int totalSeats) {
        this.tailNumber = tailNumber;
        this.model = model;
        this.totalSeats = totalSeats;
    }
}
