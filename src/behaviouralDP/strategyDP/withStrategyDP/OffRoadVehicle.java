package behaviouralDP.strategyDP.withStrategyDP;

import behaviouralDP.strategyDP.withStrategyDP.Strategy.SpecialDrive;

public class OffRoadVehicle extends Vehicle{
    public OffRoadVehicle() {
        super(new SpecialDrive());
    }
}
