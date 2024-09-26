package lowLevelDesigns._new.musicStreamingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MusicLibrary {
    private static MusicLibrary musicLibraryInstance;
    private Map<String, Song> libraryOfSongs;
    private Map<String, Album> libraryOfAlbums;
    private Map<String, Artist> libraryOfArtists;

    private MusicLibrary() {
        this.libraryOfSongs = new ConcurrentHashMap<>();
        this.libraryOfAlbums = new ConcurrentHashMap<>();
        this.libraryOfArtists = new ConcurrentHashMap<>();
    }

    public static MusicLibrary getInstance() {
        if (musicLibraryInstance == null) {
            musicLibraryInstance = new MusicLibrary();
        }
        return musicLibraryInstance;
    }

    public void addSong(Song song) {
        libraryOfSongs.put(song.getSongId(), song);
    }

    public void addAlbum(Album album) {
        libraryOfAlbums.put(album.getAlbumId(), album);
        for (Song song : album.getSongsInAlbum()) {
            addSong(song);
        }
    }

    public void addArtist(Artist artist) {
        libraryOfArtists.put(artist.getArtistId(), artist);
        for (Album album : artist.getAlbumsByArtist()) {
            addAlbum(album);
        }
    }

    public Song getSong(String songId) {
        return libraryOfSongs.get(songId);
    }

    public Album getAlbum(String albumId) {
        return libraryOfAlbums.get(albumId);
    }

    public Artist getArtist(String artistId) {
        return libraryOfArtists.get(artistId);
    }

    public List<Song> searchSongs(String query) {
        List<Song> matchingSongs = new ArrayList<>();
        for (Song song : libraryOfSongs.values()) {
            if (song.getSongName().contains(query) ||
                    song.getSongArtist().contains(query) ||
                    song.getSongAlbum().contains(query)) {
                matchingSongs.add(song);
            }
        }
        return matchingSongs;
    }
}
