package lowLevelDesigns.chess.models.pieces;

import lowLevelDesigns.chess.models.ChessBoard;
import lowLevelDesigns.chess.models.Position;

public class Knight extends Piece {
    public Knight(boolean isWhite, Position position) {
        super(isWhite, position); // super() is used to call the constructor of the parent class
    }

    @Override
    public boolean canMove(Position end, ChessBoard board) {
        int startX=this.getPosition().getX();
        int startY=this.getPosition().getY();
        int endX=end.getX();
        int endY=end.getY();

        int deltaX=Math.abs(endX-startX);
        int deltaY=Math.abs(endY-startY);

        if ((deltaX==2 && deltaY==1) || ( deltaX==1 && deltaY==2)){
            Piece targetPiece=board.getPiece(end);
            if (targetPiece==null || targetPiece.isWhite()!=this.isWhite()){
                return true;
            }
        }
        return false;
    }
}
