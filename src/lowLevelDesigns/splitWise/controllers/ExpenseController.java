package lowLevelDesigns.splitWise.controllers;

import lowLevelDesigns.splitWise.models.expenseSplit.ExpenseSplitType;
import lowLevelDesigns.splitWise.models.ExpenseShareUser;
import lowLevelDesigns.splitWise.models.Expense;
import lowLevelDesigns.splitWise.models.User;
import lowLevelDesigns.splitWise.services.ExpenseService;

import java.util.List;

public class ExpenseController {
    ExpenseService expenseService;

    public ExpenseController() {
        this.expenseService = new ExpenseService();
    }

    public Expense createExpense(String expenseId,
                                 String description,
                                 double expenseAmount,
                                 List<ExpenseShareUser> expenseShareUserDetails,
                                 ExpenseSplitType splitType,
                                 User paidByUser) {
        return expenseService.createExpense(expenseId, description, expenseAmount, expenseShareUserDetails, splitType, paidByUser);
    }
}
