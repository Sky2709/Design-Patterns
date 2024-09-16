package lowLevelDesigns.splitWise.expense;

import lowLevelDesigns.splitWise.Balance;
import lowLevelDesigns.splitWise.BalanceSheetController;
import lowLevelDesigns.splitWise.expense.split.ExpenseSplit;
import lowLevelDesigns.splitWise.expense.split.Split;
import lowLevelDesigns.splitWise.user.User;

import java.util.List;
import java.util.Objects;

public class ExpenseController {

    //BalanceSheetController is a class that maintains the balance sheet of all the users
    //here we are creating an instance of BalanceSheetController for updating the balance sheet of the users
    BalanceSheetController balanceSheetController;

    public ExpenseController(){
        balanceSheetController = new BalanceSheetController();
    }

    //createExpense method is used to create an expense
    public Expense createExpense(String expenseId,
                                 String description,
                                 double expenseAmount,
                                 List<Split> splitDetails,
                                 ExpenseSplitType splitType,
                                 User paidByUser){
        //get the split object based on the split type
        ExpenseSplit expenseSplit=SplitFactory.getSplitObject(splitType);

        //validate the split request based on the split type if the split request is valid then create the expense else throw an exception
        Objects.requireNonNull(expenseSplit).validateSplitRequest(splitDetails, expenseAmount);

        Expense expense = new Expense(expenseId, expenseAmount, description, paidByUser, splitType, splitDetails);
        //update the balance sheet of the users
        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);

        //return the expense object
        return expense;
    }
}
