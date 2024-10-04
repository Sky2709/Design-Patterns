package lowLevelDesigns._new.cricInfo;

public class Ball {
    private int ballNumber;
    private String bowler;
    private String batsman;
    private String result;

    public Ball(int ballNumber, String bowler, String batsman, String result) {
        this.ballNumber = ballNumber;
        this.bowler = bowler;
        this.batsman = batsman;
        this.result = result;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public String getBowler() {
        return bowler;
    }

    public String getBatsman() {
        return batsman;
    }

    public String getResult() {
        return result;
    }
}
