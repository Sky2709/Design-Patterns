package lowLevelDesigns.chess.services;

import lowLevelDesigns.chess.models.ChessBoard;
import lowLevelDesigns.chess.models.Player;
import lowLevelDesigns.chess.models.Position;

import java.util.Scanner;

public class GameService {
    ChessBoard chessBoard;
    Player currentPlayer;

    public GameService() {
        chessBoard = new ChessBoard();
        currentPlayer = chessBoard.getCurrentPlayer();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        try{
            while(true){
                chessBoard.displayBoard();
                System.out.println(currentPlayer.getName() + "'s turn. Enter your move (e.g., e2 e4) or type 'exit' to quit:");

                String move= scanner.nextLine();

                if (move.equals("exit")) {
                    System.out.println("Game Over");
                    break;
                }

                processMove(move);

                currentPlayer= currentPlayer == chessBoard.getWhitePlayer() ? chessBoard.getBlackPlayer() : chessBoard.getWhitePlayer();
            }
        }
        finally {
            scanner.close();
        }
    }

    private void processMove(String move) {
        String[] parts = move.split(" ");

        if (parts.length != 2) {
            System.out.println("Invalid move. Try again.");
            return;
        }

        Position start=Position.fromString(parts[0]);
        Position end=Position.fromString(parts[1]);

        if (!chessBoard.movePiece(start, end)) {
            System.out.println("Invalid move. Try again.");
        }
    }
}
