package lowLevelDesigns.vehicleRentalSystem;

import behaviouralDP.strategyDP.withoutStrategyDP.Vehicle;
import lowLevelDesigns.vehicleRentalSystem.product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int storeId;
    VehicleInventoryManager vehicleInventoryManager;
    Location location;
    List<Reservation> reservations= new ArrayList<Reservation>();

    public List<Vehicle> getVehicles(VehicleType vehicleType){
        return vehicleInventoryManager.getVehicles();
    }

    //addVehicles, update vehicles, use inventory management to update those.

    public void setVehicles(List<Vehicle> vehicles){
        vehicleInventoryManager= new VehicleInventoryManager(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle, User user){
        Reservation reservation= new Reservation();
//        reservation.createReserve(vehicle, user);
//        reservations.add(reservation);
//        return reservation;
        int reservationId=reservation.createReserve(vehicle, user);
        reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationId){
        //take out the reservation from the list and call complete the reservation method.
        return true;
    }

    //update the reservation
}
