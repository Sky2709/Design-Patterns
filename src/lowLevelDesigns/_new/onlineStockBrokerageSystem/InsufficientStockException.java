package lowLevelDesigns._new.onlineStockBrokerageSystem;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String message) {
        super(message);
    }
}
