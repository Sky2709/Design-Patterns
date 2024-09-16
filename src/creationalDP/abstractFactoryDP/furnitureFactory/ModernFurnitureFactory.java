package creationalDP.abstractFactoryDP.furnitureFactory;

import creationalDP.abstractFactoryDP.chair.Chair;
import creationalDP.abstractFactoryDP.chair.ModernChair;
import creationalDP.abstractFactoryDP.sofa.ModernSofa;
import creationalDP.abstractFactoryDP.sofa.Sofa;

public class ModernFurnitureFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}
