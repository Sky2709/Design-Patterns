package lowLevelDesigns._new.cricInfo;

import java.time.LocalDateTime;
import java.util.List;

public class Match {
    private String matchId;
    private String title;
    private String venue;
    private LocalDateTime startTime;
    private List<Team> teams;
    private MatchStatus matchStatus;
    private Scorecard scorecard;

    public Match(String matchId, String title, String venue, LocalDateTime startTime, List<Team> teams) {
        this.matchId = matchId;
        this.title = title;
        this.venue = venue;
        this.startTime = startTime;
        this.teams = teams;
        this.matchStatus = MatchStatus.SCHEDULED;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public MatchStatus getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }
}
