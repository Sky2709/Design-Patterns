package lowLevelDesigns._new.onlineStockBrokerageSystem.orders;

import lowLevelDesigns._new.onlineStockBrokerageSystem.Account;
import lowLevelDesigns._new.onlineStockBrokerageSystem.InsufficientFundsException;
import lowLevelDesigns._new.onlineStockBrokerageSystem.Stock;

public class BuyOrder extends Order{
    public BuyOrder(String orderId, Account account, Stock stock, int quantity, double price) {
        super(orderId, account, stock, quantity, price);
    }

    @Override
    public void executeOrder() {
        double totalCost=price*quantity;
        if (account.getBalance()>=totalCost){
            account.withdraw(totalCost);
            // Update portfolio and perform necessary actions
            account.getPortFolio().addStock(stock,quantity);
            orderStatus=OrderStatus.EXECUTED;
        }
        else {
            orderStatus=OrderStatus.REJECTED;
            throw new InsufficientFundsException("Insufficient funds to Execute the order: "+orderId);
        }
    }
}
