package lowLevelDesigns.chess.models.pieces;

import lowLevelDesigns.chess.models.ChessBoard;
import lowLevelDesigns.chess.models.Position;

public class Pawn extends Piece{
    public Pawn(boolean isWhite, Position position) {
        super(isWhite, position); // super() is used to call the constructor of the parent class
    }

    @Override
    public boolean canMove(Position end, ChessBoard board) {
        int startX = this.getPosition().getX();
        int startY = this.getPosition().getY();

        int endX = end.getX();
        int endY = end.getY();

        int direction = isWhite() ? 1 : -1;

        if (startX == endX && endY == startY + direction) {
            return board.getPiece(end) == null;
        }

        if (Math.abs(endX - startX) == 1 && endY == startY + direction) {
            Piece targetPiece = board.getPiece(end);
            return targetPiece != null && targetPiece.isWhite() != this.isWhite();
        }

        if (startX == endX && endY == startY + 2 * direction && (startY == 1 || startY == 6)) {
            return board.getPiece(end) == null && board.getPiece(new Position(startX, startY + direction)) == null;
        }
        return false;
    }
}
