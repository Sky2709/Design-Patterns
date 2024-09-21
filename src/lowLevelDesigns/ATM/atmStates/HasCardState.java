package lowLevelDesigns.ATM.atmStates;

import lowLevelDesigns.ATM.ATM;
import lowLevelDesigns.ATM.Card;

public class HasCardState extends ATMState{

    public HasCardState() {
        System.out.println("Card Inserted");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {
        boolean isCorrectPin= card.isCorrectPINEntered(pin);
        if (isCorrectPin){
            atm.setCurrentState(new SelectOperationState());
        }
        else {
            System.out.println("Invalid Pin");
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm) {
        ejectCard();
        atm.setCurrentState(new IdleState());
        System.out.println("Exited");
    }

    @Override
    public void ejectCard() {
        System.out.println("Please take your card");
    }
}
