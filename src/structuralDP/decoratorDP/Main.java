package structuralDP.decoratorDP;

import structuralDP.decoratorDP.basePizza.BasePizza;
import structuralDP.decoratorDP.basePizza.FarmHouse;
import structuralDP.decoratorDP.basePizza.VegDelight;
import structuralDP.decoratorDP.toppingDecorator.ExtraCheese;
import structuralDP.decoratorDP.toppingDecorator.Mushroom;

public class Main {
    public static void main(String[] args) {
//        BasePizza pizza = new ExtraCheese(new FarmHouse());
//        System.out.println(pizza.cost());
//
//        pizza=new Mushroom(pizza);
//        System.out.println(pizza.cost());

        BasePizza pizza2= new FarmHouse();
        System.out.println("FarmHouse: "+ pizza2.cost());
        pizza2=new ExtraCheese(pizza2);
        System.out.println("Extra Cheese: "+ pizza2.cost());
        pizza2=new Mushroom(pizza2);
        System.out.println("Mushroom: "+ pizza2.cost());

    }
}
