package lowLevelDesigns._new.onlineStockBrokerageSystem;

import lowLevelDesigns._new.onlineStockBrokerageSystem.orders.BuyOrder;
import lowLevelDesigns._new.onlineStockBrokerageSystem.orders.Order;
import lowLevelDesigns._new.onlineStockBrokerageSystem.orders.SellOrder;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        StockBroker stockBroker = new StockBroker();

        User user1 = new User("U001", "Ravi", "ravi@example");
        User user2 = new User("U002", "Rahul", "rahul@example");

        stockBroker.createAccount(user1, 10000);
        stockBroker.createAccount(user2, 20000);

        Account account1 = stockBroker.getAccount("ACC0001");
        Account account2 = stockBroker.getAccount("ACC0002");
        System.out.println("Account1 balance before buying: " + account1.getBalance());
//        System.out.println("Account2 balance: "+account2.getBalance());

        Stock stock1 = new Stock("S001", "Google", 1000);
        Stock stock2 = new Stock("S002", "Facebook", 2000);
        Stock stock3 = new Stock("S003", "Amazon", 3000);
        stockBroker.addStock(stock1);
        stockBroker.addStock(stock2);
        stockBroker.addStock(stock3);

        Order buyOrder1 = new BuyOrder("BO001", account1, stock1, 5, stock1.getPrice());
        stockBroker.placeOrder(buyOrder1);
        System.out.println("Account1 balance after buying: " + stock1.getStockName() + " " + account1.getBalance());

        Order buyOrder2 = new BuyOrder("BO002", account1, stock2, 2, stock2.getPrice());
        stockBroker.placeOrder(buyOrder2);
        System.out.println("Account1 balance after buying: " + stock2.getStockName() + " " + account1.getBalance());

        System.out.println("Account's Holdings: " + account1.getPortFolio().getHoldings());


        Order sellOrder1 = new SellOrder("SO001", account1, stock1, 5, stock1.getPrice());
        stockBroker.placeOrder(sellOrder1);
        System.out.println("Account1 balance after selling: " + account1.getBalance());
        System.out.println("Account's Holdings: " + account1.getPortFolio().getHoldings());
    }
}
