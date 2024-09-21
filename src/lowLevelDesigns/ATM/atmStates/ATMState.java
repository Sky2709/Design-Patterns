package lowLevelDesigns.ATM.atmStates;

import lowLevelDesigns.ATM.ATM;
import lowLevelDesigns.ATM.Card;
import lowLevelDesigns.ATM.TransactionType;

//abstract class is used to provide a common interface for all the states
public abstract class ATMState {

    public void insertCard(ATM atm, Card card){
        System.out.println("OOPS! You can't insert the card now");
    }

    public void authenticatePin(ATM atm, Card card, int pin){
        System.out.println("OOPS! You can't authenticate the pin now");
    }

    public void selectOperation(ATM atm, Card card, TransactionType transactionType){
        System.out.println("OOPS! You can't select the operation now");
    }

    public void cashWithdrawal(ATM atm, Card card, int withdrawalAmount){
        System.out.println("OOPS! You can't withdraw cash now");
    }

    public void displayBalance(ATM atm, Card card){
        System.out.println("OOPS! You can't display balance now");
    }

    public void ejectCard(){
        System.out.println("OOPS! You can't eject the card now");
    }

    public void exit(ATM atm){
        System.out.println("OOPS! You can't exit now");
    }
}
