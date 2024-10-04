package lowLevelDesigns._new.cricInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MatchService {
    private static MatchService matchServiceInstance;
    private Map<String, Match> matchesMap;

    private MatchService() {
        this.matchesMap = new ConcurrentHashMap<>();
    }

    public static synchronized MatchService getInstance() {
        if(matchServiceInstance == null) {
            matchServiceInstance = new MatchService();
        }
        return matchServiceInstance;
    }

    public void addMatch(Match match) {
        matchesMap.put(match.getMatchId(), match);
    }

    public Match getMatch(String matchId) {
        return matchesMap.get(matchId);
    }

    public List<Match> getAllMatches(){
        return new ArrayList<>(matchesMap.values());
    }

    public void updateMatchStatus(String matchId, MatchStatus matchStatus) {
        Match match = matchesMap.get(matchId);

        if (match!=null) {
            match.setMatchStatus(matchStatus);
        }
    }
}
