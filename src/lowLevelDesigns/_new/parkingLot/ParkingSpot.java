package lowLevelDesigns._new.parkingLot;

import lowLevelDesigns._new.parkingLot.vehicles.Vehicle;
import lowLevelDesigns._new.parkingLot.vehicles.VehicleType;

public class ParkingSpot {
    private int spotNumber;
    private VehicleType vehicleType;
    private Vehicle parkedvehicle;

    public ParkingSpot(int spotNumber,VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        this.spotNumber = spotNumber;
    }

    public synchronized boolean isAvailable() {
        return parkedvehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if (isAvailable() && vehicle.getVehicleType()==vehicleType) {
            parkedvehicle = vehicle;
        }
        else {
            throw new IllegalArgumentException("Illegal vehicle type or spot is already occupied");
        }
    }

    public synchronized void unparkVehicle(){
        parkedvehicle = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedvehicle() {
        return parkedvehicle;
    }
}
