package lowLevelDesigns._new.parkingLot.vehicles;

public class Car extends Vehicle{
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR); // VehicleType.CAR is an enum
    }
}
