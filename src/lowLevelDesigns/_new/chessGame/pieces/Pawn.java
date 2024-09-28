package lowLevelDesigns._new.chessGame.pieces;

import lowLevelDesigns._new.chessGame.Board;
import lowLevelDesigns._new.chessGame.Color;

public class Pawn extends Piece {
    public Pawn(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int destCol) {
        int rowDiff = destRow - row;
        int colDiff = Math.abs(destCol - col);

        if (color == Color.WHITE) {
            return (rowDiff == 1 && colDiff == 0) ||
                    (row == 1 && rowDiff == 2 && colDiff == 0) ||
                    (rowDiff == 1 && colDiff == 1 && board.getPiece(destRow, destCol) != null);
        } else {
            return (rowDiff == -1 && colDiff == 0) ||
                    (row == 6 && rowDiff == -2 && colDiff == 0) ||
                    (rowDiff == -1 && colDiff == 1 && board.getPiece(destRow, destCol) != null);
        }
    }

    //logic for canMove is such that it checks if the pawn can move to the destination cell or not
    //if the pawn is white, it can move one step forward or two steps forward if it is in the initial position
    //if the pawn is black, it can move one step backward or two steps backward if it is in the initial position
    //if the pawn is moving diagonally, it can only move if there is an opponent piece at the destination cell
    //if the pawn is moving straight, it can only move if there is no piece at the destination cell
}
