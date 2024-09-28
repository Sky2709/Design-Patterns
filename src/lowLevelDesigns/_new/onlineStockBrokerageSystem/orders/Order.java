package lowLevelDesigns._new.onlineStockBrokerageSystem.orders;

import lowLevelDesigns._new.onlineStockBrokerageSystem.Account;
import lowLevelDesigns._new.onlineStockBrokerageSystem.Stock;

public abstract class Order {
    protected String orderId;
    protected Account account;
    protected Stock stock;
    protected int quantity;
    protected double price;
    protected OrderStatus orderStatus;


    public Order(String orderId, Account account, Stock stock, int quantity, double price) {
        this.orderId = orderId;
        this.account = account;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
        this.orderStatus = OrderStatus.PENDING;
    }

    public abstract void executeOrder();

    public String getOrderId() {
        return orderId;
    }

    public Account getAccount() {
        return account;
    }

    public Stock getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}
