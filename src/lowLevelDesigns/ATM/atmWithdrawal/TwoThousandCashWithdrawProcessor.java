package lowLevelDesigns.ATM.atmWithdrawal;

import lowLevelDesigns.ATM.ATM;

public class TwoThousandCashWithdrawProcessor extends CashWithdrawProcessor {

    public TwoThousandCashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        super(cashWithdrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount) {
        int requiredNumberOfNotes = remainingAmount / 2000;
        int balance = remainingAmount % 2000;

        if (requiredNumberOfNotes <= atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(requiredNumberOfNotes);
        } else if (requiredNumberOfNotes > atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
            balance = balance + (requiredNumberOfNotes - atm.getNoOfTwoThousandNotes()) * 2000;
        }

        if (balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
