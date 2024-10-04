package lowLevelDesigns._new.cricInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scorecard {
    private String scorecardId;
    private Match match;
    private Map<String, Integer> teamScores;
    private List<Innings> innings;

    public Scorecard(String scorecardId, Match match) {
        this.scorecardId = scorecardId;
        this.match = match;
        this.teamScores= new HashMap<>();
        this.innings = new ArrayList<>();
    }

    public void updateScore(String teamId, int score){
        teamScores.put(teamId, teamScores.getOrDefault(teamId, 0) + score);
    }

    public void addInnings(Innings inning){
        innings.add(inning);
    }

    public String getScorecardId() {
        return scorecardId;
    }

    public Match getMatch() {
        return match;
    }

    public Map<String, Integer> getTeamScores() {
        return teamScores;
    }

    public List<Innings> getInnings() {
        return innings;
    }


}
