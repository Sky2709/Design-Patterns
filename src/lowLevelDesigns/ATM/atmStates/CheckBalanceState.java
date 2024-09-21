package lowLevelDesigns.ATM.atmStates;

import lowLevelDesigns.ATM.ATM;
import lowLevelDesigns.ATM.Card;

public class CheckBalanceState extends ATMState{
    public CheckBalanceState() {
        System.out.println("Checking Balance");
    }

    @Override
    public void displayBalance(ATM atm, Card card) {
        System.out.println("Your balance is: "+card.getBankBalance());
        exit(atm);
    }

    @Override
    public void ejectCard() {
        System.out.println("Please take your card");
    }

    @Override
    public void exit(ATM atm) {
        ejectCard();
        atm.setCurrentState(new IdleState());
        System.out.println("Exited");
    }
}
