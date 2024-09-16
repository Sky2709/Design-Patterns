package creationalDP.abstractFactoryDP.furnitureFactory;

import creationalDP.abstractFactoryDP.chair.Chair;
import creationalDP.abstractFactoryDP.sofa.Sofa;

//public class FurnitureFactory {
//    public Chair getChair(String type){
//        return switch (type) {
//            case "victoria" -> new VictorianChair();
//            case "modern" -> new ModernChair();
//            default -> null;
//        };
//    }
//    public Sofa getSofa(String type){
//        return switch (type) {
//            case "victoria" -> new VictorianSofa();
//            case "modern" -> new ModernSofa();
//            default -> null;
//        };
//    }
//}

public interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}
