package StrategyDP.withStrategyDP;

import StrategyDP.withStrategyDP.Strategy.SpecialDrive;

public class OffRoadVehicle extends Vehicle{
    public OffRoadVehicle() {
        super(new SpecialDrive());
    }
}
