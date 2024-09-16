package behaviouralDP.strategyDP.withStrategyDP;

import behaviouralDP.strategyDP.withStrategyDP.Strategy.NormalDriving;

public class PassengerVehicle extends Vehicle{
    public PassengerVehicle() {
        super(new NormalDriving());
    }
}
