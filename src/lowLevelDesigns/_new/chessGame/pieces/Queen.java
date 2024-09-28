package lowLevelDesigns._new.chessGame.pieces;

import lowLevelDesigns._new.chessGame.Board;
import lowLevelDesigns._new.chessGame.Color;

public class Queen extends Piece {
    public Queen(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int destCol) {
        int rowDiff = Math.abs(destRow - this.row);
        int colDiff = Math.abs(destCol - this.col);
        return (rowDiff == colDiff) || (row == destRow || col == destCol);
    }
}
