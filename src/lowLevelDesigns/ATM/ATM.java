package lowLevelDesigns.ATM;

import lowLevelDesigns.ATM.atmStates.ATMState;
import lowLevelDesigns.ATM.atmStates.IdleState;

public class ATM {
    private static ATM atmObject = new ATM();

    ATMState currentState;

    private int atmBalance;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;

    private ATM() {
    }

    public void setCurrentState(ATMState currentState) {
        this.currentState = currentState;
    }

    public ATMState getCurrentState() {
        return currentState;
    }

    public static ATM getATMObject() {
        atmObject.setCurrentState(new IdleState());
        return atmObject;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.atmBalance = atmBalance;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void deductATMBalance(int amount) {
        atmBalance -= amount;
    }

    public void deductTwoThousandNotes(int noOfTwoThousandNotes) {
        this.noOfTwoThousandNotes -= noOfTwoThousandNotes;
    }

    public void deductFiveHundredNotes(int noOfFiveHundredNotes) {
        this.noOfFiveHundredNotes -= noOfFiveHundredNotes;
    }

    public void deductOneHundredNotes(int noOfOneHundredNotes) {
        this.noOfOneHundredNotes -= noOfOneHundredNotes;
    }

    public void printCurrentATMStatus() {
        System.out.println("ATM Balance: " + atmBalance);
        System.out.println("No of 2000 notes: " + noOfTwoThousandNotes);
        System.out.println("No of 500 notes: " + noOfFiveHundredNotes);
        System.out.println("No of 100 notes: " + noOfOneHundredNotes);
    }


}
