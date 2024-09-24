package lowLevelDesigns.chess.models.pieces;

import lowLevelDesigns.chess.models.ChessBoard;
import lowLevelDesigns.chess.models.Position;

public abstract class Piece {
    boolean isWhite;
    boolean isKilled;
    Position position;

    public Piece(boolean isWhite, Position position) {
        this.isWhite = isWhite;
        this.position = position;
        isKilled = false;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public abstract boolean canMove(Position end, ChessBoard board);
}
