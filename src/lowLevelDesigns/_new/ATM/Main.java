package lowLevelDesigns._new.ATM;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        BankingService bankingService = new BankingService();
        CashDispenser cashDispenser = new CashDispenser(10000);
        ATM atm= new ATM(bankingService, cashDispenser);

        bankingService.createAccount("123456789", 1200);
        bankingService.createAccount("987654321", 500);

        Card card = new Card("12341234", "1234");
        atm.authenticateUser(card);

        double balance = atm.checkBalance("123456789");
        System.out.println( "Balance: " + balance);

        atm.withdraw("123456789", 100);
        System.out.println( "Balance After Withdrawal: " + balance);
    }
}
