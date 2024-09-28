package lowLevelDesigns._new.chessGame.pieces;

import lowLevelDesigns._new.chessGame.Board;
import lowLevelDesigns._new.chessGame.Color;

//protected= accessible within the same package and subclasses
public abstract class Piece {
    protected Color color;
    protected int row;
    protected int col;

    public Piece(Color color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;
    }

    public abstract boolean canMove(Board board, int destRow, int destCol);

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
