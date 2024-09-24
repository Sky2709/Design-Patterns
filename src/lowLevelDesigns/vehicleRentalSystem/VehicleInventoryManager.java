package lowLevelDesigns.vehicleRentalSystem;

import behaviouralDP.strategyDP.withoutStrategyDP.Vehicle;
import lowLevelDesigns.vehicleRentalSystem.product.VehicleType;

import java.util.List;

public class VehicleInventoryManager {
    List<Vehicle> vehicles;
    public VehicleInventoryManager(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        return  vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
