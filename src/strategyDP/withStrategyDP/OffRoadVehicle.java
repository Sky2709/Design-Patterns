package strategyDP.withStrategyDP;

import strategyDP.withStrategyDP.Strategy.SpecialDrive;

public class OffRoadVehicle extends Vehicle{
    public OffRoadVehicle() {
        super(new SpecialDrive());
    }
}
