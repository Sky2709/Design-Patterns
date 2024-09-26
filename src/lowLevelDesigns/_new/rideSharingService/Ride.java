package lowLevelDesigns._new.rideSharingService;

public class Ride {
    private String rideId;
    private Passenger passenger;
    private Driver driver;
    private Location sourceLocation;
    private Location destinationLocation;
    private RideStatus rideStatus;
    private double fare;

    public Ride(String rideId, Passenger passenger, Driver driver, Location sourceLocation, Location destinationLocation, RideStatus rideStatus, double fare) {
        this.rideId = rideId;
        this.passenger = passenger;
        this.driver = driver;
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
        this.rideStatus = rideStatus;
        this.fare = fare;
    }

    public String getRideId() {
        return rideId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Location getSourceLocation() {
        return sourceLocation;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
