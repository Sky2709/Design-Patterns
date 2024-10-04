package lowLevelDesigns.coffeeVendingMachine;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        CoffeeMachine coffeeMachine=CoffeeMachine.getCoffeeMachineInstance();

        coffeeMachine.displayMenu();

        Coffee espresso=coffeeMachine.selectCoffee("Espresso");
        coffeeMachine.dispenseCoffee(espresso, new Payment(3));

        Coffee cappuccino=coffeeMachine.selectCoffee("Cappuccino");
        coffeeMachine.dispenseCoffee(cappuccino, new Payment(3));

        Coffee latte=coffeeMachine.selectCoffee("Latte");
        coffeeMachine.dispenseCoffee(latte, new Payment(4.5));
    }
}
