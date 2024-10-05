package lowLevelDesigns._new.ATM.transactions;

import lowLevelDesigns._new.ATM.Account;

public class DepositTransaction extends Transaction{
    public DepositTransaction(String transactionId, Account account, double amount) {
        super(transactionId, account, amount);
    }

    @Override
    public void execute() {
        account.credit(this.amount);
    }
}
