package lowLevelDesigns.ATM;

public enum TransactionType {
    CASH_WITHDRAWAL,
    BALANCE_ENQUIRY, showAllTransactionTypes;

    public static void showAllTransactionTypes(){
        for(TransactionType type: TransactionType.values()){
            System.out.println(type.name());
        }
    }
}
