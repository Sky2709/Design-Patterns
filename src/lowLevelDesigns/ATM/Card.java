package lowLevelDesigns.ATM;

public class Card {
    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private int holderName;

    static int PIN_NUMBER=112211;

    private UserBankAccount userBankAccount;

    public boolean isCorrectPINEntered(int pin){
        return pin==PIN_NUMBER;
    }

    public int getBankBalance(){
        return userBankAccount.balance;
    }

    public void deductBankBalance(int amount){
        userBankAccount.deductBalance(amount);
    }

    public void setBankAccount(UserBankAccount userBankAccount){
        this.userBankAccount=userBankAccount;
    }
}
