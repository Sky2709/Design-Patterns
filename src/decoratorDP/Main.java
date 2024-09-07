package decoratorDP;

import decoratorDP.basePizza.BasePizza;
import decoratorDP.basePizza.FarmHouse;
import decoratorDP.toppingDecorator.ExtraCheese;
import decoratorDP.toppingDecorator.Mushroom;

public class Main {
    public static void main(String[] args) {
        BasePizza pizza = new ExtraCheese(new FarmHouse());
        System.out.println(pizza.cost());

        pizza=new Mushroom(pizza);
        System.out.println(pizza.cost());
    }
}
