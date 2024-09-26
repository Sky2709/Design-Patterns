package lowLevelDesigns._new.musicStreamingService;

import java.util.List;

public class Album {
    private String albumId;
    private String albumName;
    private String albumArtist;
    private List<Song> songsInAlbum;

    public Album(String albumId, String albumName, String albumArtist, List<Song> songsInAlbum) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.albumArtist = albumArtist;
        this.songsInAlbum = songsInAlbum;
    }

    public String getAlbumId() {
        return albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public List<Song> getSongsInAlbum() {
        return songsInAlbum;
    }
}
