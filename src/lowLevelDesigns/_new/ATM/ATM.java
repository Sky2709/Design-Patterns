package lowLevelDesigns._new.ATM;

import lowLevelDesigns._new.ATM.transactions.DepositTransaction;
import lowLevelDesigns._new.ATM.transactions.Transaction;
import lowLevelDesigns._new.ATM.transactions.WithdrawalTransaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

public class ATM {
    private BankingService bankingService;
    private CashDispenser cashDispenser;
    private static AtomicLong transactionCounter = new AtomicLong(0);

    public ATM(BankingService bankingService, CashDispenser cashDispenser) {
        this.bankingService = bankingService;
        this.cashDispenser = cashDispenser;
    }

    public void authenticateUser(Card card){
        // authenticate user
    }

    public double checkBalance(String accountNumber){
        Account account=bankingService.getAccount(accountNumber);
        return account.getBalance();
    }

    public void withdraw(String accountNumber, double amount){
        Account account=bankingService.getAccount(accountNumber);
        Transaction transaction=new WithdrawalTransaction(generateTransactionId(), account, amount);
        bankingService.processTransaction(transaction);
        cashDispenser.dispenseCash((int)amount);
    }

    public void deposit(String accountNumber, double amount){
        Account account= bankingService.getAccount(accountNumber);
        Transaction transaction= new DepositTransaction(generateTransactionId(), account, amount);
        bankingService.processTransaction(transaction);
    }

    private String generateTransactionId() {
        long transactionId = transactionCounter.incrementAndGet();
        String timeStamp= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "TXN" + timeStamp+ String.format("%010d", transactionId);
    }
}
