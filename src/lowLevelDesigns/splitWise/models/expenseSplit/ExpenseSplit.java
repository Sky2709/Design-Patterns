package lowLevelDesigns.splitWise.models.expenseSplit;

import lowLevelDesigns.splitWise.models.ExpenseShareUser;

import java.util.List;

public interface ExpenseSplit {
    public void validateSplitRequest(List<ExpenseShareUser> expenseShareUserList, double totalAmount);
}
