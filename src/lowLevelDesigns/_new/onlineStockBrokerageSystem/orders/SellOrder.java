package lowLevelDesigns._new.onlineStockBrokerageSystem.orders;

import lowLevelDesigns._new.onlineStockBrokerageSystem.Account;
import lowLevelDesigns._new.onlineStockBrokerageSystem.InsufficientStockException;
import lowLevelDesigns._new.onlineStockBrokerageSystem.Stock;

public class SellOrder extends Order{
    public SellOrder(String orderId, Account account, Stock stock, int quantity, double price) {
        super(orderId, account, stock, quantity, price);
    }

    @Override
    public void executeOrder() {
        // Check if the user has sufficient quantity of the stock to sell
        // Update portfolio and perform necessary actions
        if (account.getPortFolio().getHoldings().containsKey(stock.getStockSymbol()) && account.getPortFolio().getHoldings().get(stock.getStockSymbol())>=quantity){
            account.getPortFolio().removeStock(stock,quantity);
            double totalCost=price*quantity;
            account.deposit(totalCost);
            orderStatus=OrderStatus.EXECUTED;
        }
        else {
            orderStatus=OrderStatus.REJECTED;
            throw new InsufficientStockException("Insufficient quantity of stock to sell: "+orderId);
        }
    }
}
