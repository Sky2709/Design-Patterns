package lowLevelDesigns._new.musicStreamingService;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private String playListId;
    private String playListName;
    private User playListOwner;
    private List<Song> playListSongs;

    public PlayList(String playListId, String playListName, User playListOwner) {
        this.playListId = playListId;
        this.playListName = playListName;
        this.playListOwner = playListOwner;
        this.playListSongs=new ArrayList<>();
    }

    public void addSong(Song song){
        playListSongs.add(song);
    }

    public void removeSong(Song song){
        playListSongs.remove(song);
    }

    public String getPlayListName() {
        return playListName;
    }

    public List<Song> getPlayListSongs() {
        return playListSongs;
    }
}
