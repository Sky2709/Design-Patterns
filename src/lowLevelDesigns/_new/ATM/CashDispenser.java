package lowLevelDesigns._new.ATM;

public class CashDispenser {
    private int cashAvailable;

    public CashDispenser(int initialCash) {
        this.cashAvailable = initialCash;
    }

    public synchronized void dispenseCash(int amount){
        if (amount>cashAvailable){
            throw new RuntimeException("Insufficient cash in ATM");
        }
        cashAvailable -= amount;
        System.out.println("Cash dispensed: "+amount);
    }
}
