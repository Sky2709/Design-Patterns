package lowLevelDesigns._new.chessGame.pieces;

import lowLevelDesigns._new.chessGame.Board;
import lowLevelDesigns._new.chessGame.Color;

public class Knight extends Piece{
    public Knight(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int destCol) {
        int rowDiff = Math.abs(destRow - this.row);
        int colDiff = Math.abs(destCol - this.col);
        return (rowDiff==2 && colDiff==1) || (rowDiff==1 && colDiff==2);
    }
}
