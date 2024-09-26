package lowLevelDesigns._new.musicStreamingService;

public class MusicPlayer {
    private Song currentSong;
    private boolean isPlaying;
    private int currentDuration;

    public void playSong(Song song){
        currentSong=song;
        isPlaying=true;
        currentDuration=0;
    }

    public void pauseSong(){
        isPlaying=false;
    }

    public void resumeSong(){
        isPlaying=true;
    }

    public void seekTo(int duration){
        currentDuration=duration;
    }

}
