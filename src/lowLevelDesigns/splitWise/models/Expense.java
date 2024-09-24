package lowLevelDesigns.splitWise.models;

import lowLevelDesigns.splitWise.models.expenseSplit.ExpenseSplitType;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidByUser;
    ExpenseSplitType splitType;
    List<ExpenseShareUser> expenseShareUsers = new ArrayList<>();

//    public Expense(String expenseId, double expenseAmount, String description,
//                   User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails) {
//
//        this.expenseId = expenseId;
//        this.expenseAmount = expenseAmount;
//        this.description = description;
//        this.paidByUser = paidByUser;
//        this.splitType = splitType;
//        this.splitDetails.addAll(splitDetails);
//    }

    //constructor for expense using builder
    private Expense(ExpenseBuilder builder){
        this.expenseId = builder.expenseId;
        this.expenseAmount = builder.expenseAmount;
        this.description = builder.description;
        this.paidByUser = builder.paidByUser;
        this.splitType = builder.splitType;
        this.expenseShareUsers.addAll(builder.expenseShareUsers);
    }

    //create builder for expense
    public static class ExpenseBuilder{
        String expenseId;
        String description;
        double expenseAmount;
        User paidByUser;
        ExpenseSplitType splitType;
        List<ExpenseShareUser> expenseShareUsers = new ArrayList<>();

        public ExpenseBuilder(String expenseId, double expenseAmount, User paidByUser, ExpenseSplitType splitType) {
            this.expenseId = expenseId;
            this.expenseAmount = expenseAmount;
            this.paidByUser = paidByUser;
            this.splitType = splitType;
        }

        public ExpenseBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ExpenseBuilder setExpenseShareUsers(List<ExpenseShareUser> expenseShareUsers) {
            this.expenseShareUsers = expenseShareUsers;
            return this;
        }

        public Expense build(){
            return new Expense(this);
        }
    }
}
