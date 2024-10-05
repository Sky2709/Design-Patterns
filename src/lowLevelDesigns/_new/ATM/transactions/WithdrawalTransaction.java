package lowLevelDesigns._new.ATM.transactions;

import lowLevelDesigns._new.ATM.Account;

public class WithdrawalTransaction extends Transaction{
    public WithdrawalTransaction(String transactionId, Account account, double amount) {
        super(transactionId, account, amount);
    }

    @Override
    public void execute() {
        account.debit(this.amount);
    }
}
