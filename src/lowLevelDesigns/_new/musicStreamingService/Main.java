package lowLevelDesigns._new.musicStreamingService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        MusicStreamingService musicStreamingService = new MusicStreamingService();
        //create users
        User user1 = new User("U001", "Naman", "naman123");
        User user2 = new User("U002", "Rajesh", "rajesh123");

        //create songs
        Song song1 = new Song("S001", "Tera Ban Jaunga", "Atif Aslam", "Kabir Singh", 5);
        Song song2 = new Song("S002", "Tum Hi Ho", "Arijit Singh", "Aashiqui 2", 4);
        Song song3 = new Song("S003", "Bekhayali", "Sachet Tandon", "Kabir Singh", 6);
        Song song4 = new Song("S004", "Tum Se Hi", "Mohit Chauhan", "Jab We Met", 4);

        //create albums
        Album album1 = new Album("A001", "Kabir Singh", "Mohit Chauhan", List.of(song1, song3));
        Album album2 = new Album("A002", "Aashiqui 2", "Arijit Singh", List.of(song2, song4));
        Album album3 = new Album("A003", "Jab We Met", "Mohit Chauhan", List.of(song4));

        //create artists
        Artist artist1 = new Artist("Ar001", "Mohit Chauhan", List.of(album1, album3));
        Artist artist2 = new Artist("Ar002", "Arijit Singh", List.of(album2));

        //add artists to music library
        musicStreamingService.getMusicLibrary().addArtist(artist1);
        musicStreamingService.getMusicLibrary().addArtist(artist2);

        //add users to user manager
        musicStreamingService.getUserManager().registerUser(user1);
        musicStreamingService.getUserManager().registerUser(user2);

        //user login
        User loggedInUser = musicStreamingService.getUserManager().loginUser("Naman", "naman123");
        if (loggedInUser != null) {
            System.out.println("User logged in successfully, User Name: " + loggedInUser.getUserName());
        } else {
            System.out.println("Invalid credentials");
        }

        //search for Songs
        System.out.println("Search Results: ");
        List<Song> searchResult= musicStreamingService.getMusicLibrary().searchSongs("Tum");
        for(Song song:searchResult){
            System.out.println("Song Name: "+song.getSongName()+" Album Name: "+song.getSongAlbum()+" Artist Name: "+song.getSongArtist());
        }

        //create a playlist
        PlayList playList= new PlayList("P001", "MyFavourites", loggedInUser);
        playList.addSong(song1);
        playList.addSong(song2);
        assert loggedInUser != null;
        loggedInUser.addPlayList(playList);
        System.out.println("Playlist created successfully: "+playList.getPlayListName());
        for (Song song:playList.getPlayListSongs()){
            System.out.println("Song Name: "+song.getSongName());
        }

        //get Song recommendations
        List<Song> recommendedSongs=musicStreamingService.getMusicRecommender().recommendSongs(loggedInUser);
        System.out.println("Recommended Songs: ");
        for(Song song:recommendedSongs){
            System.out.println("Song Name: "+song.getSongName()+" Album Name: "+song.getSongAlbum()+" Artist Name: "+song.getSongArtist());
        }

        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.playSong(song1);

        musicPlayer.pauseSong();

        List<PlayList> userPlayLists = loggedInUser.getPlayLists();
        for (PlayList playList1 : userPlayLists) {
            System.out.println("Playlist Name: " + playList1.getPlayListName());
            for (Song song : playList1.getPlayListSongs()) {
                System.out.println("Song Name: " + song.getSongName());
            }
        }
    }
}
