package lowLevelDesigns.ATM.atmStates;

import lowLevelDesigns.ATM.ATM;
import lowLevelDesigns.ATM.Card;
import lowLevelDesigns.ATM.TransactionType;

public class SelectOperationState extends ATMState{

    public SelectOperationState(){
        showOperations();
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
        switch (transactionType){
            case CASH_WITHDRAWAL:
                atm.setCurrentState(new CashWithdrawalState());
                break;
            case BALANCE_ENQUIRY:
                atm.setCurrentState(new CheckBalanceState());
                break;
            default:
                System.out.println("Invalid operation");
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

    private void showOperations(){
        System.out.println("Please select the operation you want to perform");
        TransactionType.showAllTransactionTypes();
    }
}
