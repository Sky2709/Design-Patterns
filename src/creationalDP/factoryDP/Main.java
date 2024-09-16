package creationalDP.factoryDP;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory=new ShapeFactory();
        Shape shape1=shapeFactory.getShape("Rectangle");
        shape1.draw();

        Shape shape2=shapeFactory.getShape("Circle");
        shape2.draw();
    }
}
