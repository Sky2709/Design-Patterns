package lowLevelDesigns._new.onlineStockBrokerageSystem;

public class Stock {
    private String stockSymbol;
    private String stockName;
    private double price;

    public Stock(String stockSymbol, String stockName, double price) {
        this.stockSymbol = stockSymbol;
        this.stockName = stockName;
        this.price = price;
    }

    public synchronized void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public String getStockName() {
        return stockName;
    }

    public double getPrice() {
        return price;
    }
}
