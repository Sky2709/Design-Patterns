import strategyDP.withStrategyDP.OffRoadVehicle;
import strategyDP.withStrategyDP.PassengerVehicle;
import strategyDP.withStrategyDP.SportsVehicle;
import strategyDP.withStrategyDP.Vehicle;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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