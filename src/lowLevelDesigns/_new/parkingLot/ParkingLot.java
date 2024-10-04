package lowLevelDesigns._new.parkingLot;

import lowLevelDesigns._new.parkingLot.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot parkingLotInstance;
    private List<Level> levels;

    private ParkingLot(){
        levels= new ArrayList<>();
    }

    public static synchronized ParkingLot getParkingLotInstance(){
        if(parkingLotInstance==null){
            parkingLotInstance = new ParkingLot();
        }
        return parkingLotInstance;
    }

    public void addLevel(Level level){
        levels.add(level);
    }

    public void removeLevel(Level level){
        levels.remove(level);
    }

    public synchronized boolean parkVehicle(Vehicle vehicle){
        for(Level level:levels){
            if (level.parkVehicle(vehicle)){
                System.out.println("Vehicle parked at level "+level.getFloor());
                return true;
            }
        }
        System.out.println("No parking available for vehicle");
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle){
        for(Level level:levels){
            if (level.unparkVehicle(vehicle)){
                System.out.println("Vehicle unparked from level "+level.getFloor());
                return true;
            }
        }
        System.out.println("Vehicle not found in parking lot");
        return false;
    }

    public void displayAvailability(){
        for(Level level:levels){
            level.displayAvailability();
        }
    }
}
