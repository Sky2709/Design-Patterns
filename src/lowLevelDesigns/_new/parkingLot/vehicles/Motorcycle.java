package lowLevelDesigns._new.parkingLot.vehicles;

public class Motorcycle extends Vehicle{
    public Motorcycle(String licensePlate) {
        super(licensePlate, VehicleType.MOTORCYCLE); // VehicleType.MOTORCYCLE is an enum
    }
}
