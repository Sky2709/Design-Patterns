package lowLevelDesigns._new.parkingLot;

import lowLevelDesigns._new.parkingLot.vehicles.Vehicle;
import lowLevelDesigns._new.parkingLot.vehicles.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int floor;
    private List<ParkingSpot> parkingSpots;

    public Level(int floor, int numberOfSpots) {
        this.floor = floor;
        this.parkingSpots = new ArrayList<>();

        // Assign spots in ration of 50:40:10 for bikes, cars and trucks
        int numberOfBikeSpots = (int) (numberOfSpots * 0.5);
        int numberOfCarSpots = (int) (numberOfSpots * 0.4);
        int numberOfTruckSpots = numberOfSpots - numberOfBikeSpots - numberOfCarSpots;

        for (int i = 1; i <= numberOfBikeSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));
        }

        for (int i = numberOfBikeSpots + 1; i <= numberOfBikeSpots + numberOfCarSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }

        for (int i = numberOfBikeSpots + numberOfCarSpots + 1; i <= numberOfBikeSpots + numberOfCarSpots + numberOfTruckSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isAvailable() && parkingSpot.getVehicleType() == vehicle.getVehicleType()) {
                parkingSpot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (!parkingSpot.isAvailable() && parkingSpot.getParkedvehicle().equals(vehicle)) {
                parkingSpot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Floor: " + floor);
        for (ParkingSpot parkingSpot : parkingSpots) {
            System.out.println("Spot: " + parkingSpot.getSpotNumber() + ": " +
                    (parkingSpot.isAvailable() ? "Available " : "Occupied By " + parkingSpot.getParkedvehicle().getLicensePlate() + " " + parkingSpot.getParkedvehicle().getVehicleType())
            );
        }
    }

    public int getFloor() {
        return floor;
    }
}
