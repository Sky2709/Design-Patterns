package lowLevelDesigns._new.chessGame;

import lowLevelDesigns._new.chessGame.pieces.Piece;

import java.util.Scanner;

public class ChessGame {
    private Player[] players;
    private Board board;
    private int currentPlayer;

    public ChessGame() {
        players=new Player[]{new Player(Color.WHITE),new Player(Color.BLACK)};
        board=new Board();
        currentPlayer=0;
    }

    public void start(){
        while (!isGameOver()){
            Player player = players[currentPlayer];
            System.out.println(player.getColor()+"'s turn");
            Move move = getPlayerMove(player);

            try{
                player.makeMove(board,move);
            }
            catch (InvalidMoveException e){
                System.out.println(e.getMessage());
                System.out.println("Try again");
                continue;
            }
            currentPlayer=(currentPlayer+1)%2;
        }
        displayResult();
    }

    private void displayResult() {
        if (board.isCheckmate(Color.WHITE)) {
            System.out.println("Black wins by checkmate!");
        } else if (board.isCheckmate(Color.BLACK)) {
            System.out.println("White wins by checkmate!");
        } else if (board.isStalemate(Color.WHITE) || board.isStalemate(Color.BLACK)) {
            System.out.println("The game ends in a stalemate!");
        }
    }

    private Move getPlayerMove(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Source Row: " );
        int sourceRow = scanner.nextInt();
        System.out.print("Enter Source Column: " );
        int sourceColumn = scanner.nextInt();
        System.out.print("Enter Destination Row: " );
        int destinationRow = scanner.nextInt();
        System.out.print("Enter Destination Column: " );
        int destinationColumn = scanner.nextInt();

        Piece piece= board.getPiece(sourceRow, sourceColumn);
        if (piece==null || piece.getColor() != player.getColor()){
            throw new InvalidMoveException("Invalid Piece Selection !!");
        }
        return new Move(piece, destinationRow, destinationColumn);
    }

    private boolean isGameOver() {
        return board.isCheckmate(players[0].getColor()) ||
                board.isCheckmate(players[1].getColor()) ||
                board.isStalemate(players[0].getColor()) ||
                board.isStalemate(players[1].getColor());
    }


}
