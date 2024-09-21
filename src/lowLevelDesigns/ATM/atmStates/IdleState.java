package lowLevelDesigns.ATM.atmStates;

import lowLevelDesigns.ATM.ATM;
import lowLevelDesigns.ATM.Card;

public class IdleState extends ATMState{

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card Inserted");
        atm.setCurrentState(new HasCardState());
    }
}
