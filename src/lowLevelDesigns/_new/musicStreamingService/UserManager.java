package lowLevelDesigns._new.musicStreamingService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {
    private static UserManager userManagerInstance;
    private Map<String, User> usersMap;

    private UserManager() {
        usersMap= new ConcurrentHashMap<>();
    }

    public static synchronized UserManager getInstance() {
        if(userManagerInstance == null) {
            userManagerInstance = new UserManager();
        }
        return userManagerInstance;
    }

    public void registerUser(User user) {
        usersMap.put(user.getUserId(), user);
    }

    public User loginUser(String userName, String password){
        for(User user:usersMap.values()){
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}
