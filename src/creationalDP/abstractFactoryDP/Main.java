package creationalDP.abstractFactoryDP;

import creationalDP.abstractFactoryDP.chair.Chair;
import creationalDP.abstractFactoryDP.furnitureFactory.FurnitureFactory;
import creationalDP.abstractFactoryDP.furnitureFactory.ModernFurnitureFactory;
import creationalDP.abstractFactoryDP.furnitureFactory.VictorianFurnitureFactory;
import creationalDP.abstractFactoryDP.sofa.Sofa;

public class Main {
    public static void main(String[] args) {
        FurnitureFactory modernFurnitureFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFurnitureFactory.createChair();
        Sofa modernSofa = modernFurnitureFactory.createSofa();

        modernChair.sitOn();
        modernSofa.lieOn();

        FurnitureFactory victorianFurnitureFactory = new VictorianFurnitureFactory();
        Chair victorianChair = victorianFurnitureFactory.createChair();
        Sofa victorianSofa = victorianFurnitureFactory.createSofa();

        victorianChair.sitOn();
        victorianSofa.lieOn();
    }
}
