package lowLevelDesigns.ticTacToe;

import java.util.Scanner;

public class TicTacToeGame {
    private Player player1;
    private Player player2;
    private Board board;
    private Player currentplayer;

    public TicTacToeGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        this.currentplayer = player1;
    }

    public void play() {
        board.printBoard();

        while (!board.isFull() && !board.hasWinner()) {
            System.out.println(currentplayer.getName() + "'s turn");
            int row = getValidInput("Enter row number (0-2): ");
            int col = getValidInput("Enter column number (0-2): ");

            try {
                board.makeMove(row, col, currentplayer.getSymbol());
                board.printBoard();
                switchPlayer();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (board.hasWinner()) {
            switchPlayer();
            System.out.println(currentplayer.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private void switchPlayer() {
        currentplayer = (currentplayer == player1) ? player2 : player1;
    }

    private int getValidInput(String message) {
        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            System.out.println(message);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 0 && input <= 2) {
                    return input;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Please enter a number between 0 and 2");
        }
    }
}
