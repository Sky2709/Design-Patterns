package lowLevelDesigns.coffeeVendingMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeMachine {
    private static CoffeeMachine coffeeMachineInstance;
    private List<Coffee> coffeeMenu;
    private Map<String, Ingredient> ingredientsMap;

    private CoffeeMachine() {
        coffeeMenu=new ArrayList<>();
        ingredientsMap= new HashMap<>();
        initializeIngredients();
        initializeCoffeeMenu();
    }

    public static CoffeeMachine getCoffeeMachineInstance() {
        if(coffeeMachineInstance==null) {
            coffeeMachineInstance=new CoffeeMachine();
        }
        return coffeeMachineInstance;
    }

    private void initializeCoffeeMenu() {
        Map<Ingredient, Integer> espressoRecipe=new HashMap<>();
        espressoRecipe.put(ingredientsMap.get("Coffee"), 1);
        espressoRecipe.put(ingredientsMap.get("Water"), 1);
        coffeeMenu.add(new Coffee("Espresso", 2.5, espressoRecipe));

        Map<Ingredient, Integer> cappuccinoRecipe=new HashMap<>();
        cappuccinoRecipe.put(ingredientsMap.get("Coffee"), 1);
        cappuccinoRecipe.put(ingredientsMap.get("Water"), 1);
        cappuccinoRecipe.put(ingredientsMap.get("Milk"), 1);
        coffeeMenu.add(new Coffee("Cappuccino", 3.5, cappuccinoRecipe));

        Map<Ingredient, Integer> latteRecipe=new HashMap<>();
        latteRecipe.put(ingredientsMap.get("Coffee"), 1);
        latteRecipe.put(ingredientsMap.get("Water"), 1);
        latteRecipe.put(ingredientsMap.get("Milk"), 2);
        coffeeMenu.add(new Coffee("Latte", 4.5, latteRecipe));
    }

    private void initializeIngredients() {
        ingredientsMap.put("Coffee", new Ingredient("Coffee", 10));
        ingredientsMap.put("Milk", new Ingredient("Milk", 10));
        ingredientsMap.put("Sugar", new Ingredient("Sugar", 10));
        ingredientsMap.put("Water", new Ingredient("Water", 10));
    }

    public void displayMenu(){
        System.out.println("Menu:");
        for(Coffee coffee:coffeeMenu){
            System.out.println(coffee.getName()+" : $"+coffee.getPrice());
        }
    }

    public synchronized Coffee selectCoffee(String coffeeName){
        for(Coffee coffee:coffeeMenu){
            if (coffee.getName().equalsIgnoreCase(coffeeName)) {
                return coffee;
            }
        }
        return null;
    }

    public synchronized void dispenseCoffee(Coffee coffee, Payment payment){
        if (payment.getAmount() >=coffee.getPrice()){
            if (hasEnoughIngredients(coffee)){
                updateIngredients(coffee);
                System.out.println("Dispensing "+coffee.getName());
                double change=payment.getAmount()-coffee.getPrice();
                if (change>0){
                    System.out.println("Please collect your change $"+change);
                }
            }
            else {
                System.out.println("Insufficient ingredients to make "+coffee.getName());
            }
        }
        else {
            System.out.println("Insufficient payment for "+coffee.getName());
        }
    }

    private void updateIngredients(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> entry: coffee.getRecipe().entrySet()){
            Ingredient ingredient=entry.getKey();
            int requiredQuantity=entry.getValue();
            ingredient.updateQuantity(-requiredQuantity);
            if (ingredient.getQuantity()<3){
                System.out.println("Low on "+ingredient.getName());
            }
        }
    }

    private boolean hasEnoughIngredients(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> entry:coffee.getRecipe().entrySet()){
            Ingredient ingredient=entry.getKey();
            int requiredQuantity=entry.getValue();
            if (ingredient.getQuantity()<requiredQuantity){
                return false;
            }
        }
        return true;
    }


}
