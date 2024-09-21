package lowLevelDesigns.ATM;

public class UserBankAccount {
    int balance;

    public void deductBalance(int amount){
        balance-=amount;
    }
}
