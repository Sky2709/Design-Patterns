package structuralDP.adapterDP.weightMachine.client;

import structuralDP.adapterDP.weightMachine.adaptee.WeightMachine;
import structuralDP.adapterDP.weightMachine.adaptee.WeightMachineForBabies;
import structuralDP.adapterDP.weightMachine.adapter.WeightMachineAdapter;
import structuralDP.adapterDP.weightMachine.adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter= new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println("Weight in Kilograms: "+weightMachineAdapter.getWeightInKilograms());
    }
}
