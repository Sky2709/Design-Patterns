package structuralDP.decoratorDP.toppingDecorator;

import structuralDP.decoratorDP.basePizza.BasePizza;

public class Mushroom extends ToppingDecorator{
    BasePizza basePizza;

    public Mushroom(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost(){
        return this.basePizza.cost() + 30;
    }

}
