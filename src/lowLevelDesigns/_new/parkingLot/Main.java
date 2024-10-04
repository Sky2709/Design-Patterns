package lowLevelDesigns._new.parkingLot;

import lowLevelDesigns._new.parkingLot.vehicles.Car;
import lowLevelDesigns._new.parkingLot.vehicles.Motorcycle;
import lowLevelDesigns._new.parkingLot.vehicles.Truck;
import lowLevelDesigns._new.parkingLot.vehicles.Vehicle;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        ParkingLot parkingLot= ParkingLot.getParkingLotInstance();

        parkingLot.addLevel(new Level(1,5));
        parkingLot.addLevel(new Level(2,10));

        Vehicle car1= new Car("KA-01-HH-1234");
        Vehicle car2= new Car("KA-01-HH-9999");
        Vehicle motorcycle1= new Motorcycle("KA-01-HH-7777");
        Vehicle motorcycle2= new Motorcycle("KA-01-HH-2701");
        Vehicle truck1= new Truck("KA-01-HH-3141");
        Vehicle truck2= new Truck("KA-01-HH-3142");

//        parkingLot.displayAvailability();
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
//        parkingLot.displayAvailability();
        parkingLot.parkVehicle(motorcycle1);
        parkingLot.parkVehicle(motorcycle2);
//        parkingLot.displayAvailability();
        parkingLot.parkVehicle(truck1);
        parkingLot.parkVehicle(truck2);
        parkingLot.displayAvailability();

        parkingLot.unparkVehicle(car1);
        parkingLot.displayAvailability();
    }
}
