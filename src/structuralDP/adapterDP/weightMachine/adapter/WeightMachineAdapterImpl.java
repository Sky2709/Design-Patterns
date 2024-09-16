package structuralDP.adapterDP.weightMachine.adapter;

import structuralDP.adapterDP.weightMachine.adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter{

    WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKilograms() {
        double weightInPounds= weightMachine.getWeightInPounds();

        return weightInPounds * 0.45;
    }
}
