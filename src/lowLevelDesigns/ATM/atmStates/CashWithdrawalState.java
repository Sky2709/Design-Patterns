package lowLevelDesigns.ATM.atmStates;

import lowLevelDesigns.ATM.ATM;
import lowLevelDesigns.ATM.Card;
import lowLevelDesigns.ATM.atmWithdrawal.CashWithdrawProcessor;
import lowLevelDesigns.ATM.atmWithdrawal.FiveHundredCashWithdrawProcessor;
import lowLevelDesigns.ATM.atmWithdrawal.OneHundredCashWithdrawProcessor;
import lowLevelDesigns.ATM.atmWithdrawal.TwoThousandCashWithdrawProcessor;

public class CashWithdrawalState extends ATMState{

    public CashWithdrawalState() {
        System.out.println("Please enter the amount to withdraw");
    }

    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawalAmount) {
        if (atm.getAtmBalance() < withdrawalAmount) {
            System.out.println("Insufficient Balance");
            exit(atm);
        } else if (card.getBankBalance() < withdrawalAmount) {
            System.out.println("Insufficient Balance in your account");
            exit(atm);
        }
        else {
            card.deductBankBalance(withdrawalAmount);
            atm.deductATMBalance(withdrawalAmount);

            CashWithdrawProcessor cashWithdrawProcessor= new TwoThousandCashWithdrawProcessor(new FiveHundredCashWithdrawProcessor(new OneHundredCashWithdrawProcessor(null)));

            cashWithdrawProcessor.withdraw(atm, withdrawalAmount);
            exit(atm);
        }
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
