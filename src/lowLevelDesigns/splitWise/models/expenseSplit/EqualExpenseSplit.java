package lowLevelDesigns.splitWise.models.expenseSplit;

import lowLevelDesigns.splitWise.models.ExpenseShareUser;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit{

    @Override
    public void validateSplitRequest(List<ExpenseShareUser> expenseShareUserList, double totalAmount) {
        //check if the amount is equal
        double amountShouldBePresent= totalAmount/ expenseShareUserList.size();
        for(ExpenseShareUser expenseShareUser : expenseShareUserList){
            if (expenseShareUser.getAmountOwe() != amountShouldBePresent){
                throw new RuntimeException("Amount should be equally divided");
            }
        }
    }
}
