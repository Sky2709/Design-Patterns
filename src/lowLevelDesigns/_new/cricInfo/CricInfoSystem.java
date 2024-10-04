package lowLevelDesigns._new.cricInfo;

import java.util.List;

public class CricInfoSystem {
    private MatchService matchService;
    private ScoreCardService scoreCardService;

    public CricInfoSystem() {
        this.matchService=MatchService.getInstance();
        this.scoreCardService=ScoreCardService.getInstance();
    }

    public void addMatch(Match match){
        matchService.addMatch(match);
        scoreCardService.createScoreCard(match);
    }

    public Match getMatch(String matchId){
        return matchService.getMatch(matchId);
    }

    public List<Match> getMatches(){
        return matchService.getAllMatches();
    }

    public void updateMatchStatus(String matchId, MatchStatus status){
        matchService.updateMatchStatus(matchId, status);
    }

    public void createScoreCard(Match match){
        scoreCardService.createScoreCard(match);
    }

    public Scorecard getScoreCard(String matchId){
        return scoreCardService.getScoreCard(matchId);
    }

    public void updateScore(String scorecardId, String teamId, int score){
        scoreCardService.updateScore(scorecardId, teamId, score);
    }

    public void addInnings(String scorecardId, Innings inning){
        scoreCardService.addInnings(scorecardId, inning);
    }
}
