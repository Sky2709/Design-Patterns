package lowLevelDesigns._new.chessGame.pieces;

import lowLevelDesigns._new.chessGame.Board;
import lowLevelDesigns._new.chessGame.Color;

public class Rook extends Piece{
    public Rook(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int destCol) {
        return (row == destRow || col == destCol) && board.isStraightPathClear(row, col, destRow, destCol);
    }
}
