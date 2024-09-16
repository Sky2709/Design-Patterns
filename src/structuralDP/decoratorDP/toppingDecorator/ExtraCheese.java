package structuralDP.decoratorDP.toppingDecorator;

import structuralDP.decoratorDP.basePizza.BasePizza;

public class ExtraCheese extends ToppingDecorator{
    BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost(){
        return this.basePizza.cost() + 50;
    }

}
