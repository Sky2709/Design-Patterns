package lowLevelDesigns.splitWise.models.expenseSplit;

import lowLevelDesigns.splitWise.models.ExpenseShareUser;

import java.util.List;

public class PercentageExpenseSplit implements ExpenseSplit{

    @Override
    public void validateSplitRequest(List<ExpenseShareUser> expenseShareUserList, double totalAmount) {
        //logic here is to check if the percentage is correct or not

    }
}
