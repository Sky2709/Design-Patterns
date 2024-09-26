package lowLevelDesigns._new.musicStreamingService;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String userName;
    private String password;
    private List<PlayList> playLists;

    public User(String userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.playLists= new ArrayList<>();
    }

    public void addPlayList(PlayList playList) {
        playLists.add(playList);
    }

    public void removePlayList(PlayList playList) {
        playLists.remove(playList);
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<PlayList> getPlayLists() {
        return playLists;
    }
}
