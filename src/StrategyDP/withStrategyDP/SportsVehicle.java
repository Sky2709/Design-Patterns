package StrategyDP.withStrategyDP;

import StrategyDP.withStrategyDP.Strategy.SpecialDrive;

public class SportsVehicle extends Vehicle{
    public SportsVehicle() {
        super(new SpecialDrive()); //
    }
}
