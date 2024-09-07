package factoryDP;

public class ShapeFactory {
    Shape getShape(String input){
        return switch (input) {
            case "Rectangle" -> new Rectangle();
            case "Circle" -> new Circle();
            default -> null;
        };
    }
}
