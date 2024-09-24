package lowLevelDesigns.splitWise.controllers;

import lowLevelDesigns.splitWise.models.UserExpenseBalanceSheet;
import lowLevelDesigns.splitWise.models.Balance;
import lowLevelDesigns.splitWise.models.ExpenseShareUser;
import lowLevelDesigns.splitWise.models.User;
import lowLevelDesigns.splitWise.services.BalanceSheetService;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {
    BalanceSheetService balanceSheetService;

    public BalanceSheetController() {
        this.balanceSheetService=new BalanceSheetService();
    }

    public void updateUserExpenseBalanceSheet(User expensePaidBy,
                                              List<ExpenseShareUser> expenseShareUsers,
                                              double totalExpenseAmount){
        balanceSheetService.updateUserExpenseBalanceSheet(expensePaidBy, expenseShareUsers,totalExpenseAmount);
    }

    public void showBalanceSheetOfUser(User user) {
        balanceSheetService.showBalanceSheetOfUser(user);
    }

}
