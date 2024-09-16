package behaviouralDP.strategyDP.withStrategyDP;

import behaviouralDP.strategyDP.withStrategyDP.Strategy.SpecialDrive;

public class SportsVehicle extends Vehicle{
    public SportsVehicle() {
        super(new SpecialDrive()); //
    }
}
