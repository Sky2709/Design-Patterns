package lowLevelDesigns._new.musicStreamingService;

public class Song {
    private String songId;
    private String songName;
    private String songArtist;
    private String songAlbum;
    private int songDuration;

    public Song(String songId, String songName, String songArtist, String songAlbum, int songDuration) {
        this.songId = songId;
        this.songName = songName;
        this.songArtist = songArtist;
        this.songAlbum = songAlbum;
        this.songDuration = songDuration;
    }

    public String getSongAlbum() {
        return songAlbum;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public String getSongName() {
        return songName;
    }

    public String getSongId() {
        return songId;
    }
}
