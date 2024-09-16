package behaviouralDP.strategyDP;

import behaviouralDP.strategyDP.withStrategyDP.OffRoadVehicle;
import behaviouralDP.strategyDP.withStrategyDP.PassengerVehicle;
import behaviouralDP.strategyDP.withStrategyDP.SportsVehicle;
import behaviouralDP.strategyDP.withStrategyDP.Vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new SportsVehicle();
        vehicle.drive();

        Vehicle vehicle1 = new OffRoadVehicle();
        vehicle1.drive();

        Vehicle vehicle2 = new PassengerVehicle();
        vehicle2.drive();
    }
}
