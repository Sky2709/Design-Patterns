package strategyDP.withStrategyDP;

import strategyDP.withStrategyDP.Strategy.NormalDriving;

public class PassengerVehicle extends Vehicle{
    public PassengerVehicle() {
        super(new NormalDriving());
    }
}
