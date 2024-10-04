package lowLevelDesigns._new.cricInfo;

import java.util.List;

public class Team {
    private String teamId;
    private String teamName;
    private List<Player> players;

    public Team(String teamId, String teamName, List<Player> players) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.players = players;
    }
}
