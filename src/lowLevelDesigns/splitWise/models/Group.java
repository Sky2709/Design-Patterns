package lowLevelDesigns.splitWise.models;

import lowLevelDesigns.splitWise.controllers.ExpenseController;
import lowLevelDesigns.splitWise.models.expenseSplit.ExpenseSplitType;

import java.util.ArrayList;
import java.util.List;

public class Group {
    public String groupId;
    public String groupName;
    public List<User> groupMembers;

    public List<Expense> expenseList;

    //ExpenseController is a class which will have the logic to create the expense
    ExpenseController expenseController;

    public Group(){
        groupMembers = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    public void addMember(User member){
        groupMembers.add(member);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<ExpenseShareUser> expenseShareUserDetails, ExpenseSplitType splitType, User paidByUser) {

        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, expenseShareUserDetails, splitType, paidByUser);
        expenseList.add(expense);
        return expense;
    }

}
