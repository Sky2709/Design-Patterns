package lowLevelDesigns.splitWise.models;

import lowLevelDesigns.splitWise.controllers.BalanceSheetController;
import lowLevelDesigns.splitWise.controllers.GroupController;
import lowLevelDesigns.splitWise.controllers.UserController;
import lowLevelDesigns.splitWise.models.expenseSplit.ExpenseSplitType;

import java.util.ArrayList;
import java.util.List;

public class SplitWise {

    //flow of this class is as follows:
    //1. setupUserAndGroup() - onboard user to splitwise app and create a group by user1
    //2. demo() - add members to the group, create an expense inside a group, show balance sheet of each user


    UserController userController;
    GroupController groupController;
    BalanceSheetController balanceSheetController;

    public SplitWise(){
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
    }

    public void demo(){

        setupUserAndGroup();

        //Step1: add members to the group
        Group group = groupController.getGroup("G1001");
        group.addMember(userController.getUser("U2001"));
        group.addMember(userController.getUser("U3001"));

        //Step2. create an expense inside a group
        List<ExpenseShareUser> expenseShareUsers = new ArrayList<>();
        ExpenseShareUser expenseShareUser1 = new ExpenseShareUser(userController.getUser("U1001"), 300);
        ExpenseShareUser expenseShareUser2 = new ExpenseShareUser(userController.getUser("U2001"), 300);
        ExpenseShareUser expenseShareUser3 = new ExpenseShareUser(userController.getUser("U3001"), 300);
        expenseShareUsers.add(expenseShareUser1);
        expenseShareUsers.add(expenseShareUser2);
        expenseShareUsers.add(expenseShareUser3);
        group.createExpense("Exp1001", "Breakfast", 900, expenseShareUsers, ExpenseSplitType.EQUAL, userController.getUser("U1001"));

        //create another expense inside a group with unequal splits between users U1001 and U2001
        List<ExpenseShareUser> splits2 = new ArrayList<>();
        ExpenseShareUser splits2_1 = new ExpenseShareUser(userController.getUser("U1001"), 400);
        ExpenseShareUser splits2_2 = new ExpenseShareUser(userController.getUser("U2001"), 100);
        splits2.add(splits2_1);
        splits2.add(splits2_2);
        group.createExpense("Exp1002", "Lunch", 500, splits2, ExpenseSplitType.UNEQUAL, userController.getUser("U2001"));

        for(User user : userController.getAllUsers()) {
            balanceSheetController.showBalanceSheetOfUser(user);
        }
    }

    public void setupUserAndGroup(){

        //onboard user to splitwise app
        addUsersToSplitwiseApp();

        //create a group by user1 means user1 is creating a group
        User user1 = userController.getUser("U1001");
        groupController.createNewGroup("G1001", "Outing with Friends", user1);
    }

    private void addUsersToSplitwiseApp(){

        //adding User1
        User user1 = new User("U1001", "User1");

        //adding User2
        User user2 = new User ("U2001", "User2");

        //adding User3
        User user3 = new User ("U3001", "User3");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
    }
}

