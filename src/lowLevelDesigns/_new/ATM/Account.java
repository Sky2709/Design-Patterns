package lowLevelDesigns._new.ATM;

public class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void debit(double amount) {
        balance -= amount;
        if (balance < 0) {
            throw new RuntimeException("Insufficient balance");
        }
    }

    public void credit(double amount) {
        balance += amount;
    }
}
