package lowLevelDesigns.splitWise.models.expenseSplit;

import lowLevelDesigns.splitWise.models.ExpenseShareUser;

import java.util.List;

public class UnEqualExpenseSplit implements ExpenseSplit{

    @Override
    public void validateSplitRequest(List<ExpenseShareUser> expenseShareUserList, double totalAmount) {
        //logic here is to check if the amount is correct or not
    }
}
