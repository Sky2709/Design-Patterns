package lowLevelDesigns._new.airLineManagementSystem.payment;

public class Payment {
    private String paymentId;
    private String paymentMethod;
    private double amount;
    private PaymentStatus paymentStatus;

    public Payment(String paymentId, String paymentMethod, double amount) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public void processPayment(){
        // process payment logic will be
        this.paymentStatus=PaymentStatus.COMPLETED;
    }
}
