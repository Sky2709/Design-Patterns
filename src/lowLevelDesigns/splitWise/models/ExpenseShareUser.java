package lowLevelDesigns.splitWise.models;

// Split class is used to store the user and the amount he owes in the expense
public class ExpenseShareUser {
    User user;
    double amountOwe;

    public ExpenseShareUser(User user, double amountOwe) {
        this.user = user;
        this.amountOwe = amountOwe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmountOwe() {
        return amountOwe;
    }

    public void setAmountOwe(double amountOwe) {
        this.amountOwe = amountOwe;
    }
}
