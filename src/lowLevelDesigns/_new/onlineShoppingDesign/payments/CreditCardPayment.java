package lowLevelDesigns._new.onlineShoppingDesign.payments;

public class CreditCardPayment implements Payment{
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
