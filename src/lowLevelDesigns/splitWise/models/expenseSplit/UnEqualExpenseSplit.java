package lowLevelDesigns.splitWise.models.expenseSplit;

import lowLevelDesigns.splitWise.models.ExpenseShareUser;

import java.util.List;

public class UnEqualExpenseSplit implements ExpenseSplit{

    @Override
    public void validateSplitRequest(List<ExpenseShareUser> expenseShareUserList, double totalAmount) {
        //logic here is to check if the amount is correct or
        double totalSplitAmount = 0;
        for(ExpenseShareUser expenseShareUser : expenseShareUserList){
            totalSplitAmount += expenseShareUser.getAmountOwe();
        }

        if (totalSplitAmount != totalAmount){
            throw new RuntimeException("Total amount should be equal to the split amount");
        }
    }
}
