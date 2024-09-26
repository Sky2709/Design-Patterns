package lowLevelDesigns._new.musicStreamingService;

public class MusicStreamingService {
    private MusicLibrary musicLibrary;
    private UserManager userManager;
    private MusicRecommender musicRecommender;

    public MusicStreamingService() {
        musicLibrary=MusicLibrary.getInstance();
        userManager=UserManager.getInstance();
        musicRecommender=MusicRecommender.getInstance();
    }

    public void start(){
        System.out.println("Starting Music Streaming Service");
    }

    public MusicLibrary getMusicLibrary() {
        return musicLibrary;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public MusicRecommender getMusicRecommender() {
        return musicRecommender;
    }
}
