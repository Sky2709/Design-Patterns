package lowLevelDesigns._new.musicStreamingService;

import java.util.List;

public class Artist {
    private String artistId;
    private String artistName;
    private List<Album> albumsByArtist;

    public Artist(String artistId, String artistName, List<Album> albumsByArtist) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.albumsByArtist = albumsByArtist;
    }

    public String getArtistId() {
        return artistId;
    }

    public List<Album> getAlbumsByArtist() {
        return albumsByArtist;
    }
}
