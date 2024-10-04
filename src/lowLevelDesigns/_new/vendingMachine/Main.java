package lowLevelDesigns._new.vendingMachine;

import lowLevelDesigns._new.vendingMachine.coinAndNote.Coin;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        VendingMachine vendingMachine= VendingMachine.getInstance();

        Product Coke = new Product("Coke", 25);
        Product Pepsi = new Product("Pepsi", 35);
        Product Soda = new Product("Soda", 45);
        Product Water = new Product("Water", 20);
        Product Juice = new Product("Juice", 30);

        vendingMachine.inventory.addOrUpdateProduct(Coke, 10);
        vendingMachine.inventory.addOrUpdateProduct(Pepsi, 10);
        vendingMachine.inventory.addOrUpdateProduct(Soda, 10);
        vendingMachine.inventory.addOrUpdateProduct(Water, 10);
        vendingMachine.inventory.addOrUpdateProduct(Juice, 10);

        vendingMachine.selectProduct(Coke);

        vendingMachine.insertCoin(Coin.DIME);
        vendingMachine.insertCoin(Coin.DIME);
//        vendingMachine.insertCoin(Coin.DIME);
        vendingMachine.displayTotalPayment();
        vendingMachine.checkPaymentStatus();

        vendingMachine.dispenseProduct();
        vendingMachine.returnChange();

        vendingMachine.displayTotalPayment();
        vendingMachine.inventory.hasProduct(Coke);

//        vendingMachine.insertCoin(Coin.DIME);
//        vendingMachine.getTotalPayment();

//        vendingMachine.dispenseProduct();
//        vendingMachine.selectProduct(Coke);
//        vendingMachine.dispenseProduct();

    }
}
