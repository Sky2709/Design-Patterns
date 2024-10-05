package lowLevelDesigns._new.carRentalSystem;

public class CreditCardPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double totalPrice) {
        System.out.println("Payment Done");
        return true;
    }
}
