package lowLevelDesigns._new.cricInfo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ScoreCardService {
    private static ScoreCardService scoreCardServiceInstance;
    private Map<String, Scorecard> scorecardsMap;
    private AtomicInteger scorecardIdCounter;

    public ScoreCardService() {
        this.scorecardsMap= new ConcurrentHashMap<>();
        this.scorecardIdCounter = new AtomicInteger(0);
    }

    public static synchronized ScoreCardService getInstance(){
        if(scoreCardServiceInstance == null){
            scoreCardServiceInstance = new ScoreCardService();
        }
        return scoreCardServiceInstance;
    }

    public synchronized void createScoreCard(Match match){
        String scoreCardId= generateScoreCardId(match.getMatchId());
        Scorecard scoreCard= new Scorecard(scoreCardId, match);
        scorecardsMap.put(scoreCardId, scoreCard);
    }

    public void updateScore(String scorecardId, String teamId, int score){
        Scorecard scoreCard= scorecardsMap.get(scorecardId);
        if (scoreCard!=null){
            scoreCard.updateScore(teamId, score);
        }
    }

    public void addInnings(String scorecardId, Innings inning){
        Scorecard scoreCard= scorecardsMap.get(scorecardId);
        if (scoreCard!=null){
            scoreCard.addInnings(inning);
        }
    }

    public Scorecard getScoreCard(String scorecardId){
        return scorecardsMap.get(scorecardId);
    }

    private String generateScoreCardId(String matchId) {
        int scorecardId = scorecardIdCounter.incrementAndGet();
        return "SC-" + matchId + "-" + String.format("%04d", scorecardId);
    }
}
