package creationalDP.abstractFactoryDP.furnitureFactory;

import creationalDP.abstractFactoryDP.chair.Chair;
import creationalDP.abstractFactoryDP.chair.VictorianChair;
import creationalDP.abstractFactoryDP.sofa.Sofa;
import creationalDP.abstractFactoryDP.sofa.VictorianSofa;

public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}
