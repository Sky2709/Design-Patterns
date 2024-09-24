package lowLevelDesigns.splitWise.controllers;

import lowLevelDesigns.splitWise.models.User;
import lowLevelDesigns.splitWise.services.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    UserService userService = new UserService();

    //add user to the list
    public void addUser(User user) {
        userService.addUser(user);
    }

    //get user by ID
    public User getUser(String userID) {
        return userService.getUser(userID);
    }

    //get all users
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


}
