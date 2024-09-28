package lowLevelDesigns._new.onlineStockBrokerageSystem;

import lowLevelDesigns._new.onlineStockBrokerageSystem.orders.Order;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class StockBroker {
    private static StockBroker stockBrokerInstance;
    private Map<String, Account> accountsMap;
    private Map<String, Stock> stocksMap;
    private Queue<Order> orderQueue;
    private AtomicInteger accountIdCounter;

    public StockBroker() {
        this.accountsMap=new ConcurrentHashMap<>();
        this.stocksMap=new ConcurrentHashMap<>();
        this.orderQueue=new ConcurrentLinkedQueue<>();
        this.accountIdCounter=new AtomicInteger(1);
    }

    public synchronized static StockBroker getInstance(){
        if (stockBrokerInstance==null){
            stockBrokerInstance=new StockBroker();
        }
        return stockBrokerInstance;
    }

    public void createAccount(User user, double initialBalance){
        String accountId= generateAccountId();
        Account account= new Account(accountId,user,initialBalance);
        accountsMap.put(accountId,account);
    }

    private String generateAccountId() {
        int accountId=accountIdCounter.getAndIncrement();
        return "ACC" + String.format("%04d", accountId);
    }

    public Account getAccount(String accountId){
        System.out.println("Getting account for accountId: "+accountId);
        return accountsMap.get(accountId);
    }

    public void addStock(Stock stock){
        stocksMap.put(stock.getStockSymbol(),stock);
    }

    public Stock getStock(String stockSymbol){
        return stocksMap.get(stockSymbol);
    }

    public void placeOrder(Order order){
        orderQueue.add(order);
        processOrder();
    }

    // This method will process the order from the orderQueue
    private void processOrder() {
        while (!orderQueue.isEmpty()){
            Order order=orderQueue.poll();
            try {
                order.executeOrder();
                System.out.println("Order executed successfully: "+order.getOrderId());
            }
            catch (InsufficientFundsException | InsufficientStockException e){
                // Handle exception and notify user
                System.out.println("Order execution failed: "+e.getMessage());
            }
        }
    }
}
