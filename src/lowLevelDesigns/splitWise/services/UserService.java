package lowLevelDesigns.splitWise.services;

import lowLevelDesigns.splitWise.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> userList;

    public UserService() {
        userList = new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User getUser(String userID) {

        for (User user : userList) {
            if (user.getUserId().equals(userID)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return userList;
    }
}
