package lowLevelDesigns.cricBuzz;

public class Player {
    Person person;
    PlayerType playerType;
    BattingScoreCard battingScoreCard;
    BowlingScoreCard bowlingScoreCard;

    public Player(Person person, PlayerType playerType) {
        this.person = person;
        this.playerType = playerType;
        battingScoreCard=new BattingScoreCard();
        bowlingScoreCard=new BowlingScoreCard();
    }

//    public void printBattingScoreCard(){
//        System.out.println("PlayerName: "+ person.playerName
//                           + " totalRunsScored: "+ battingScoreCard.totalRuns
//                           + " totalBallsPlayed: "+ battingScoreCard.totalBallsPlayed
//                           + " Fours: "+ battingScoreCard.totalFours
//                           + " Sixes: "+ battingScoreCard.totalSixes
//                           + " Out By: "+ ((battingScoreCard.wicketDetails!=null) ? battingScoreCard.wicketDetails.takenBy.person.playerName : "Not Out"));
//    }
//
//    public void printBowlingScoreCard(){
//        System.out.println("PlayerName: " + person.playerName
//                           + " totalOversThrown: " + bowlingScoreCard.totalOversCount
//                           + " totalRunsGiven: " + bowlingScoreCard.totalRunsGiven
//                           + " totalWicketsTaken: " + bowlingScoreCard.totalWicketsTaken);
//    }
}
