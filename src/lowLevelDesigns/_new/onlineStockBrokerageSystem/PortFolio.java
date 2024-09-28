package lowLevelDesigns._new.onlineStockBrokerageSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PortFolio {
    private Account account;
    private Map<String, Integer> holdings; // stock symbol to quantity

    public PortFolio(Account account) {
        this.account = account;
        this.holdings = new ConcurrentHashMap<>();
    }

    public synchronized void addStock(Stock stock, int quantity) {
        holdings.put(stock.getStockSymbol(), holdings.getOrDefault(stock.getStockSymbol(), 0) + quantity);
    }

    public synchronized void removeStock(Stock stock, int quantity){
        String symbol = stock.getStockSymbol();
        if (holdings.containsKey(symbol)){
            int currentQuantity=holdings.get(symbol);
            if (currentQuantity>quantity){
                holdings.put(symbol, currentQuantity-quantity);
            }
            else if (currentQuantity==quantity){
                holdings.remove(symbol);
            }
            else {
                throw new InsufficientStockException("Not enough stock to sell");
            }
        }
        else {
            throw new InsufficientStockException("Stock not present in portfolio");
        }
    }

    public Map<String, Integer> getHoldings() {
        return holdings;
    }
}
