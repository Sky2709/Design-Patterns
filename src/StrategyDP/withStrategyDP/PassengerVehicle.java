package StrategyDP.withStrategyDP;

import StrategyDP.withStrategyDP.Strategy.DriveStrategy;
import StrategyDP.withStrategyDP.Strategy.NormalDriving;

public class PassengerVehicle extends Vehicle{
    public PassengerVehicle() {
        super(new NormalDriving());
    }
}
