package lowLevelDesigns.ATM;

public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String[] args) {
        ATMRoom atmRoom= new ATMRoom();
        atmRoom.initialize();

        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentState().insertCard(atmRoom.atm,atmRoom.user.card);
        atmRoom.atm.getCurrentState().authenticatePin(atmRoom.atm,atmRoom.user.card,112211);
        atmRoom.atm.getCurrentState().selectOperation(atmRoom.atm,atmRoom.user.card, TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentState().cashWithdrawal(atmRoom.atm,atmRoom.user.card,3100);
//        atmRoom.atm.getCurrentState().selectOperation(atmRoom.atm,atmRoom.user.card, TransactionType.BALANCE_ENQUIRY);
//        atmRoom.atm.getCurrentState().displayBalance(atmRoom.atm,atmRoom.user.card);
        atmRoom.atm.printCurrentATMStatus();
    }

    private void initialize() {
        atm=ATM.getATMObject();
        atm.setAtmBalance(3500,1,2,5);

        this.user=createUser();
    }

    private User createUser() {
        User user= new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard() {
        Card card= new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    private UserBankAccount createBankAccount() {
        UserBankAccount bankAccount= new UserBankAccount();
        bankAccount.balance=3000;
        return bankAccount;
    }


}
