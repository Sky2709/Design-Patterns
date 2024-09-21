package lowLevelDesigns.ATM.atmWithdrawal;

import lowLevelDesigns.ATM.ATM;

public class OneHundredCashWithdrawProcessor extends CashWithdrawProcessor {

    public OneHundredCashWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }


    public void withdraw(ATM atm, int remainingAmount) {
        int requiredNumberOfNotes = remainingAmount / 100;
        int balance = remainingAmount % 100;

        if (requiredNumberOfNotes<=atm.getNoOfOneHundredNotes()){
            atm.deductOneHundredNotes(requiredNumberOfNotes);
        } else if (requiredNumberOfNotes > atm.getNoOfOneHundredNotes()) {
            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
            balance=balance+(requiredNumberOfNotes-atm.getNoOfOneHundredNotes())*100;
        }

        if (balance!=0){
            System.out.println("Something went wrong");
        }
    }
}
