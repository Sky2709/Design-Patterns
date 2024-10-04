package lowLevelDesigns._new.cricInfo;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        List<Player> indianTeam = List.of(
                new Player("1", "Virat", "Batsman"),
                new Player("2", "Rohit", "Batsman"),
                new Player("3", "Dhawan", "Batsman"),
                new Player("4", "Pant", "WicketKeeper"),
                new Player("5", "Hardik", "AllRounder"),
                new Player("6", "Jadeja", "AllRounder"),
                new Player("7", "Bumrah", "Bowler"),
                new Player("8", "Shami", "Bowler"),
                new Player("9", "Chahal", "Bowler"),
                new Player("10", "Kuldeep", "Bowler"),
                new Player("11", "Siraj", "Bowler")
        );

        List<Player> australianTeam= List.of(
                new Player("1", "Warner", "Batsman"),
                new Player("2", "Finch", "Batsman"),
                new Player("3", "Smith", "Batsman"),
                new Player("4", "Carey", "WicketKeeper"),
                new Player("5", "Maxwell", "AllRounder"),
                new Player("6", "Stoinis", "AllRounder"),
                new Player("7", "Cummins", "Bowler"),
                new Player("8", "Starc", "Bowler"),
                new Player("9", "Zampa", "Bowler"),
                new Player("10", "Hazlewood", "Bowler"),
                new Player("11", "Lyon", "Bowler")
        );

        Team team1= new Team("T001", "India", indianTeam);
        Team team2= new Team("T002", "Australia", australianTeam);

        List<Team> teams= Arrays.asList(team1, team2);

        Match match= new Match("M001", "India vs Australia", "Narendra Modi Stadium", LocalDateTime.now(), teams);

        CricInfoSystem cricInfoSystem= new CricInfoSystem();
        cricInfoSystem.addMatch(match);

        cricInfoSystem.createScoreCard(match);

        String scorecardId= "SC-M001-0001";
        Scorecard scorecard= cricInfoSystem.getScoreCard(scorecardId);

        cricInfoSystem.updateScore(scorecardId, "T001", 100);
        cricInfoSystem.updateScore(scorecardId, "T002", 90);

        Innings firstInning= new Innings("I001", "T001", "T002");
        Innings secondInning= new Innings("I002", "T002", "T001");

        cricInfoSystem.addInnings(scorecardId, firstInning);
        cricInfoSystem.addInnings(scorecardId, secondInning);

        Scorecard updatedScorecard= cricInfoSystem.getScoreCard(scorecardId);

        System.out.println("ScoreCard Id: " + updatedScorecard.getScorecardId());
        System.out.println("Match Id: " + updatedScorecard.getMatch().getTitle());
        System.out.println("Team Scores: ");
        for (Map.Entry<String, Integer> entry : updatedScorecard.getTeamScores().entrySet() ){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("Innings: ");
        for (Innings innings : updatedScorecard.getInnings()) {
            System.out.println("Innings ID: " + innings.getInningsId());
            System.out.println("Batting Team: " + innings.getBattingTeamId());
            System.out.println("Bowling Team: " + innings.getBowlingTeamId());
            System.out.println("Overs:");
            for (Over over : innings.getOvers()) {
                System.out.println("Over " + over.getOverNumber());
                for (Ball ball : over.getBalls()) {
                    System.out.println("Ball " + ball.getBallNumber() + ": " +
                            ball.getBowler() + " to " + ball.getBatsman() + " - " + ball.getResult());
                }
            }
            System.out.println();
        }
    }
}
