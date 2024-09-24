package lowLevelDesigns.splitWise.services;

import lowLevelDesigns.splitWise.models.expenseSplit.ExpenseSplitFactory;
import lowLevelDesigns.splitWise.models.Expense;
import lowLevelDesigns.splitWise.models.ExpenseShareUser;
import lowLevelDesigns.splitWise.models.User;
import lowLevelDesigns.splitWise.models.expenseSplit.ExpenseSplit;
import lowLevelDesigns.splitWise.models.expenseSplit.ExpenseSplitType;

import java.util.List;
import java.util.Objects;

public class ExpenseService {
    //BalanceSheetController is a class that maintains the balance sheet of all the users
    //here we are creating an instance of BalanceSheetController for updating the balance sheet of the users
    BalanceSheetService balanceSheetService;

    public ExpenseService(){
        balanceSheetService = new BalanceSheetService();
    }

    //createExpense method is used to create an expense
    public Expense createExpense(String expenseId,
                                 String description,
                                 double expenseAmount,
                                 List<ExpenseShareUser> expenseShareUserDetails,
                                 ExpenseSplitType splitType,
                                 User paidByUser){
        //get the split object based on the split type
        ExpenseSplit expenseSplit= ExpenseSplitFactory.getSplitObject(splitType);

        //validate the split request based on the split type if the split request is valid then create the expense else throw an exception
        Objects.requireNonNull(expenseSplit).validateSplitRequest(expenseShareUserDetails, expenseAmount);

//        Expense expense = new Expense(expenseId, expenseAmount, description, paidByUser, splitType, splitDetails);
        //create an expense object using the builder pattern
        Expense expense = new Expense.ExpenseBuilder(expenseId, expenseAmount, paidByUser, splitType)
                .setDescription(description)
                .setExpenseShareUsers(expenseShareUserDetails)
                .build();
        //update the balance sheet of the users
        balanceSheetService.updateUserExpenseBalanceSheet(paidByUser, expenseShareUserDetails, expenseAmount);

        //return the expense object
        return expense;
    }
}
