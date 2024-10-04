package lowLevelDesigns._new.cricInfo;

import java.util.ArrayList;
import java.util.List;

public class Innings {
    private String inningsId;
    private String battingTeamId;
    private String bowlingTeamId;
    private List<Over> overs;

    public Innings(String inningsId, String battingTeamId, String bowlingTeamId) {
        this.inningsId = inningsId;
        this.battingTeamId = battingTeamId;
        this.bowlingTeamId = bowlingTeamId;
        this.overs=new ArrayList<>();
    }

    public void addOver(Over over){
        overs.add(over);
    }

    public String getInningsId() {
        return inningsId;
    }

    public String getBattingTeamId() {
        return battingTeamId;
    }

    public String getBowlingTeamId() {
        return bowlingTeamId;
    }

    public List<Over> getOvers() {
        return overs;
    }
}
