package lowLevelDesigns._new.onlineShoppingDesign;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String userName;
    private String email;
    private String password;
    private List<Order> orders;

    public User(String userId, String userName, String email, String password) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.userName = userName;
        this.orders=new ArrayList<>();
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
