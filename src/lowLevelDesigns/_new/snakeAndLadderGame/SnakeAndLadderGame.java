package lowLevelDesigns._new.snakeAndLadderGame;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderGame {
    private Board board;
    private Dice dice;
    private List<Player> players;
    private int currentPlayerIndex;

    public SnakeAndLadderGame(List<String> playerNames) {
        this.board = new Board();
        this.dice = new Dice();
        this.currentPlayerIndex = 0;
        this.players = new ArrayList<>();
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
    }

    public void play() {
        while (!isGameOver()) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println(currentPlayer.getName() + " playing...");
            System.out.println("Rolling dice...");
            int diceRoll = dice.roll();
            System.out.println("Dice rolled to: " + diceRoll);

            int oldPosition = currentPlayer.getPosition();
            int newPositionBeforeSnakeOrLadder = currentPlayer.getPosition() + diceRoll;
            if (newPositionBeforeSnakeOrLadder <= board.getBoardSize()) {
                currentPlayer.setPosition(board.getNewPositionAfterSnakeOrLadder(newPositionBeforeSnakeOrLadder));
                int newPositionAfterSnakeOrLadder = currentPlayer.getPosition();
                if (newPositionAfterSnakeOrLadder == oldPosition + diceRoll) {
                    System.out.println("No snake or ladder found");
                    System.out.println("Moving: " + currentPlayer.getName() + " from " + oldPosition + " to " + newPositionAfterSnakeOrLadder);
                } else if (newPositionAfterSnakeOrLadder > oldPosition + diceRoll) {
                    System.out.println("Ladder found");
                    System.out.println("Moving: " + currentPlayer.getName() + " from " + oldPosition + " to " + newPositionAfterSnakeOrLadder);
                } else {
                    System.out.println("Snake found");
                    System.out.println("Moving: " + currentPlayer.getName() + " from " + oldPosition + " to " + newPositionAfterSnakeOrLadder);
                }
            }

            if (currentPlayer.getPosition() == board.getBoardSize()) {
                System.out.println(currentPlayer.getName() + " wins !!!");
                break;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            System.out.println("-------------------------------------------------");
        }
    }

    private boolean isGameOver() {
        for (Player player : players) {
            if (player.getPosition() == board.getBoardSize()) {
                return true;
            }
        }
        return false;
    }
}
