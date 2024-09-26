package lowLevelDesigns._new.musicStreamingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MusicRecommender {
    private static MusicRecommender musicRecommenderInstance;
    private Map<String, List<Song>> userRecommendations; // userId, List of recommended songs

    private MusicRecommender() {
        userRecommendations= new ConcurrentHashMap<>();
    }

    public static synchronized MusicRecommender getInstance() {
        if(musicRecommenderInstance == null) {
            musicRecommenderInstance = new MusicRecommender();
        }
        return musicRecommenderInstance;
    }

    public List<Song> recommendSongs(User user){
        // logic to recommend songs based on user's listening history, preferences, etc.
        return userRecommendations.getOrDefault(user.getUserId(), new ArrayList<>()); // return empty list if no recommendations
    }

}
