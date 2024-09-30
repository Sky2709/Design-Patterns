package lowLevelDesigns._new.airLineManagementSystem.payment;

public class PaymentProcessor {
    private static PaymentProcessor paymentProcessorInstance;

    private PaymentProcessor() {
    }

    public static synchronized PaymentProcessor getInstance() {
        if (paymentProcessorInstance == null) {
            paymentProcessorInstance = new PaymentProcessor();
        }
        return paymentProcessorInstance;
    }

    public void processPayment(Payment payment) {
        payment.processPayment();
    }
}
