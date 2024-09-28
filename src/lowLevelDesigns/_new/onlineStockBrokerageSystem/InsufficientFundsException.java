package lowLevelDesigns._new.onlineStockBrokerageSystem;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
