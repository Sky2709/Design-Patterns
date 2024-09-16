package lowLevelDesigns.snakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playersList = new LinkedList<>();
    Player winner;

    public Game() {
        System.out.println("Game started");
        initializeGame();
    }

    public void initializeGame() {
        board = new Board(4, 2, 2);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    public void addPlayers() {
        Player player1 = new Player("Player1", 0);
        Player player2 = new Player("Player2", 0);
        playersList.add(player1);
        playersList.add(player2);
    }

    public void startGame() {
        while (winner == null) {
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is: " + playerTurn.getId() + " and current position is: " + playerTurn.getCurrentPosition());

            int diceNumbers = dice.diceRoll();

            int playerNewPosition = playerTurn.getCurrentPosition() + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.currentPosition = playerNewPosition;

            System.out.println("Player turn is: " + playerTurn.id +
                    "new Position is: " + playerNewPosition);
            if (playerNewPosition == board.cells.length * board.cells.length) {
                winner = playerTurn;
                System.out.println("Winner is: " + winner.id);
            }
        }
        System.out.println("Winner is: " + winner.id);
    }

    public int jumpCheck(int playerNewPosition) {
        if (playerNewPosition > board.cells.length * board.cells.length) {
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if (cell.jump != null && cell.jump.from == playerNewPosition) {
            String jumpBy = (cell.jump.from < cell.jump.to) ? "Ladder" : "Snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.to;
        }
        return playerNewPosition;
    }

    public Player findPlayerTurn() {
        Player playerTurns = playersList.removeFirst(); //removing the player from the front of the queue
        playersList.addLast(playerTurns);
        return playerTurns;
    }
}
