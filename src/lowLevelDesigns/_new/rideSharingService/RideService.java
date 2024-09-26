package lowLevelDesigns._new.rideSharingService;

import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RideService {
    private static RideService rideServiceInstance;
    private Map<String, Passenger> passengers;
    private Map<String, Driver> drivers;
    private Map<String, Ride> rides;
    private Queue<Ride> rideRequests; // ride requests which are not yet assigned to any driver

    private RideService() {
        this.passengers = new ConcurrentHashMap<>();
        this.drivers = new ConcurrentHashMap<>();
        this.rides = new ConcurrentHashMap<>();
        this.rideRequests = new ConcurrentLinkedQueue<>();
    }

    public static RideService getInstance() {
        if (rideServiceInstance == null) {
            return new RideService();
        }
        return rideServiceInstance;
    }

    public void addPassenger(Passenger passenger) {
        passengers.put(passenger.getPassengerId(), passenger);
    }

    public void addDriver(Driver driver) {
        drivers.put(driver.getDriverId(), driver);
    }

    public void requestRide(Passenger passenger, Location source, Location destination) {
        Ride ride = new Ride(generateRideId(), passenger, null, source, destination, RideStatus.REQUESTED, 0);
        rideRequests.add(ride);
        notifyDrivers(ride);
    }

    public void acceptRide(Driver driver, Ride ride) {
        if (ride.getRideStatus() == RideStatus.REQUESTED) {
            ride.setDriver(driver);
            ride.setRideStatus(RideStatus.ACCEPTED);
            driver.setDriverStatus(DriverStatus.BUSY);
            notifyPassenger(ride);
        }
    }
    
    public void startRide(Ride ride){
        if (ride.getRideStatus()==RideStatus.ACCEPTED){
            ride.setRideStatus(RideStatus.IN_PROGRESS);
            notifyPassenger(ride);
        }
    }
    
    public void completeRide(Ride ride){
        if (ride.getRideStatus()==RideStatus.IN_PROGRESS){
            ride.setRideStatus(RideStatus.COMPLETED);
            ride.getDriver().setDriverStatus(DriverStatus.AVAILABLE);
            double fare=calculateFare(ride);
            ride.setFare(fare);
            processPayment(ride, fare);
            notifyPassenger(ride);
            notifyDriver(ride);
        }
    }

    public void cancelRide(Ride ride){
        if (ride.getRideStatus()==RideStatus.REQUESTED || ride.getRideStatus()==RideStatus.ACCEPTED){
            ride.setRideStatus(RideStatus.CANCELLED);
            if (ride.getDriver() !=null){
                ride.getDriver().setDriverStatus(DriverStatus.AVAILABLE);
            }
            notifyPassenger(ride);
            notifyDriver(ride);
        }
    }

    public void notifyDriver(Ride ride) {
        Driver driver = ride.getDriver();
        if (driver!=null){
            String message="";
            switch (ride.getRideStatus()){
                case COMPLETED:
                    message="Ride has been completed. Fare: "+ride.getFare();
                    break;
                case CANCELLED:
                    message="Ride has been cancelled.";
                    break;
            }
            System.out.println("Notifying Driver: "+driver.getDriverName()+" - "+message);
        }
    }

    public void processPayment(Ride ride, double fare) {
    }

    public double calculateFare(Ride ride) {
        double baseFare=10.0;
        double perKmFare=5.0;
        double perMinuteFare=2.0;

        double distance=calculateDistance(ride.getSourceLocation(), ride.getDestinationLocation());
        double duration=calculateDuration(ride.getSourceLocation(), ride.getDestinationLocation());

        double fare=baseFare+ (distance*perKmFare) + (duration*perMinuteFare);
        return Math.round(fare*100.0)/100.0;
    }

    public double calculateDuration(Location sourceLocation, Location destinationLocation) {
        double distance=calculateDistance(sourceLocation, destinationLocation);
        return (distance/30)*60; // Assuming average speed of 30 km/hr
    }

    public void notifyPassenger(Ride ride) {
        Passenger passenger = ride.getPassenger();

        String message = "";
        switch (ride.getRideStatus()) {
            case ACCEPTED:
                message = "Your ride has been accepted by driver: " + ride.getDriver().getDriverName();
                break;
            case IN_PROGRESS:
                message = "Your ride is in progress.";
                break;
            case COMPLETED:
                message = "Your ride has been completed. Fare: " + ride.getFare();
                break;
            case CANCELLED:
                message = "Your ride has been cancelled.";
                break;
        }
        System.out.println("Notifying Passenger: " + passenger.getPassengerName() + " - " + message);
    }

    public void notifyDrivers(Ride ride) {
        for (Driver driver : drivers.values()) {
            if (driver.getDriverStatus() == DriverStatus.AVAILABLE) {
                double distance = calculateDistance(driver.getDriverLocation(), ride.getSourceLocation());
                if (distance <= 5.0) {
                    System.out.println("Notifying Driver: " + driver.getDriverName() + " about ride request: " + ride.getRideId());
                }
            }
        }
    }

    public double calculateDistance(Location driverLocation, Location sourceLocation) {
        // Calculate the distance between two locations using a distance formula (e.g., Haversine formula)
        // For simplicity, let's assume a random distance between 1 and 20 km
        return Math.random() * 20 + 1; // random distance between 1 and 20 km
    }

    public String generateRideId() {
        return "RIDE" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public Map<String, Ride> getRides(){
        return rides;
    }

    public Queue<Ride> getRequestedRides(){
        return rideRequests;
    }
}
