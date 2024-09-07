package strategyDP.withStrategyDP;

import strategyDP.withStrategyDP.Strategy.SpecialDrive;

public class SportsVehicle extends Vehicle{
    public SportsVehicle() {
        super(new SpecialDrive()); //
    }
}
