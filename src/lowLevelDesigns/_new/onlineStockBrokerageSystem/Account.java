package lowLevelDesigns._new.onlineStockBrokerageSystem;

public class Account {
    private String accountId;
    private User user;
    private double balance;
    private PortFolio portFolio;

    public Account(String accountId, User user, double balance) {
        this.accountId = accountId;
        this.user = user;
        this.balance = balance;
        this.portFolio=new PortFolio(this);
    }

    public synchronized void deposit(double amount){
        this.balance+=amount;
    }

    public synchronized  void withdraw(double amount){
        if (this.balance>=amount){
            this.balance-=amount;
        }
        else {
            throw new InsufficientFundsException("Insufficient balance in account: " + this.accountId);
        }
    }

    public String getAccountId() {
        return accountId;
    }

    public User getUser() {
        return user;
    }

    public double getBalance() {
        return balance;
    }

    public PortFolio getPortFolio() {
        return portFolio;
    }
}
