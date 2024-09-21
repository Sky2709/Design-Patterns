package lowLevelDesigns.ATM.atmWithdrawal;

import lowLevelDesigns.ATM.ATM;

public class FiveHundredCashWithdrawProcessor extends CashWithdrawProcessor {
    public FiveHundredCashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        super(cashWithdrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount) {

        int requiredNumberOfNotes = remainingAmount / 500;
        int balance = remainingAmount % 500;

        if (requiredNumberOfNotes <= atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(requiredNumberOfNotes);
        } else if (requiredNumberOfNotes > atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
            balance = balance + (requiredNumberOfNotes - atm.getNoOfFiveHundredNotes()) * 500;
        }

        if (balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
