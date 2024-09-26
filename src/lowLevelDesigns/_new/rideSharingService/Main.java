package lowLevelDesigns._new.rideSharingService;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        RideService rideService= RideService.getInstance();

        Passenger passenger1=new Passenger("P001", "Akash", "1234567890", new Location(37.7749, -122.4194));
        Passenger passenger2=new Passenger("P002", "Amit", "1234567891", new Location(37.7860, -122.4070));
        rideService.addPassenger(passenger1);
        rideService.addPassenger(passenger2);

        Driver driver1= new Driver("D001", "Rahul", "9856741252", "ABC7845", new Location(37.7749, -122.4194), DriverStatus.AVAILABLE);
        Driver driver2= new Driver("D002", "Rohit", "9856741142", "ACD4145", new Location(37.7860, -122.4070), DriverStatus.AVAILABLE);
        rideService.addDriver(driver1);
        rideService.addDriver(driver2);

        rideService.requestRide(passenger1, passenger1.getPassengerLocation(), new Location(37.7749, -122.4194));

        Ride ride= rideService.getRequestedRides().poll();
        rideService.acceptRide(driver1, ride);

        rideService.startRide(ride);

        rideService.completeRide(ride);

        rideService.requestRide(passenger2, passenger2.getPassengerLocation(), new Location(37.7860, -122.4070));

        Ride ride2= rideService.getRequestedRides().poll();
        rideService.acceptRide(driver2, ride2);

        rideService.cancelRide(ride2);
    }
}
