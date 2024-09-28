package lowLevelDesigns._new.chessGame.pieces;

import lowLevelDesigns._new.chessGame.Board;
import lowLevelDesigns._new.chessGame.Color;

public class Bishop extends Piece{
    public Bishop(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int destCol) {
        int rowDiff = Math.abs(destRow - this.row);
        int colDiff = Math.abs(destCol - this.col);
        return rowDiff == colDiff;
        //logic is to check if the difference between the destination row and current row is equal to the difference between the destination column and current column
        //if it is equal, then the bishop can move to the destination
    }
}
