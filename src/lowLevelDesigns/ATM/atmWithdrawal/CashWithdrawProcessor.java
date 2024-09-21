package lowLevelDesigns.ATM.atmWithdrawal;

import lowLevelDesigns.ATM.ATM;

public abstract class CashWithdrawProcessor {

    CashWithdrawProcessor nextCashWithdrawProcessor;

    public CashWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        this.nextCashWithdrawProcessor = nextCashWithdrawProcessor;
    }

    public void withdraw(ATM atm, int withdrawalAmount) {
        if (nextCashWithdrawProcessor!=null) {
            nextCashWithdrawProcessor.withdraw(atm, withdrawalAmount);
        }
    }
}
