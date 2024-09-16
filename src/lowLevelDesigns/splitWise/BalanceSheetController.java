package lowLevelDesigns.splitWise;

import lowLevelDesigns.splitWise.expense.split.Split;
import lowLevelDesigns.splitWise.user.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User expensePaidBy,
                                              List<Split> splits,
                                              double totalExpenseAmount) {
        UserExpenseBalanceSheet paidByUserExpenseSheet=expensePaidBy.getUserExpenseBalanceSheet();
        paidByUserExpenseSheet.setTotalPayment(paidByUserExpenseSheet.getTotalPayment()+totalExpenseAmount);

        for(Split split : splits) {
            User userOwe = split.getUser();
            UserExpenseBalanceSheet oweUserExpenseSheet = userOwe.getUserExpenseBalanceSheet();
            double oweAmount = split.getAmountOwe();

            if(expensePaidBy.getUserId().equals(userOwe.getUserId())){
                paidByUserExpenseSheet.setTotalYourExpense(paidByUserExpenseSheet.getTotalYourExpense()+oweAmount);
            }
            else {

                //update the balance of paid user
                paidByUserExpenseSheet.setTotalYouGetBack(paidByUserExpenseSheet.getTotalYouGetBack() + oweAmount);

                Balance userOweBalance;
                if(paidByUserExpenseSheet.getUserVsBalance().containsKey(userOwe.getUserId())) {

                    userOweBalance = paidByUserExpenseSheet.getUserVsBalance().get(userOwe.getUserId());
                }
                else {
                    userOweBalance = new Balance();
                    paidByUserExpenseSheet.getUserVsBalance().put(userOwe.getUserId(), userOweBalance);
                }

                userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack() + oweAmount);


                //update the balance sheet of owe user
                oweUserExpenseSheet.setTotalYouOwe(oweUserExpenseSheet.getTotalYouOwe() + oweAmount);
                oweUserExpenseSheet.setTotalYourExpense(oweUserExpenseSheet.getTotalYourExpense() + oweAmount);

                Balance userPaidBalance;
                if(oweUserExpenseSheet.getUserVsBalance().containsKey(expensePaidBy.getUserId())){
                    userPaidBalance = oweUserExpenseSheet.getUserVsBalance().get(expensePaidBy.getUserId());
                }
                else{
                    userPaidBalance = new Balance();
                    oweUserExpenseSheet.getUserVsBalance().put(expensePaidBy.getUserId(), userPaidBalance);
                }
                userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe() + oweAmount);
            }
        }
    }

    public void showBalanceSheetOfUser(User user) {
        System.out.println("---------------------------------------");
        System.out.println("Balance sheet of user : " + user.getUserId());

        UserExpenseBalanceSheet userExpenseBalanceSheet = user.getUserExpenseBalanceSheet();

        System.out.println("Total payment : " + userExpenseBalanceSheet.getTotalPayment());
        System.out.println("Total your expense : " + userExpenseBalanceSheet.getTotalYourExpense());
        System.out.println("Total you owe : " + userExpenseBalanceSheet.getTotalYouOwe());
        System.out.println("Total you get back : " + userExpenseBalanceSheet.getTotalYouGetBack());

        for(Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()) {
            System.out.println("User : " + entry.getKey());
            System.out.println("Amount owe : " + entry.getValue().getAmountOwe());
            System.out.println("Amount get back : " + entry.getValue().getAmountGetBack());
        }

        System.out.println("---------------------------------------");
    }
}
