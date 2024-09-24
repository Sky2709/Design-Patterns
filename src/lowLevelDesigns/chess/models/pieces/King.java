package lowLevelDesigns.chess.models.pieces;

import lowLevelDesigns.chess.models.ChessBoard;
import lowLevelDesigns.chess.models.Position;

public class King extends Piece{

    public King(boolean isWhite, Position position) {
        super(isWhite, position); // super() is used to call the constructor of the parent class
    }

    @Override
    public boolean canMove(Position end, ChessBoard board) {
        int startX=this.getPosition().getX(); // this.getPosition() returns the current position of the piece
        int startY=this.getPosition().getY(); // this.getPosition() returns the current position of the piece

        // King can move only one step in any direction
        int deltaX=Math.abs(end.getX()-startX);
        int deltaY=Math.abs(end.getY()-startY);

        if ((deltaX<=1 && deltaY<=1) && !(deltaX==0 && deltaY==0)) {
            Piece targetPiece=board.getPiece(end); // board.getPiece() returns the piece at the given position
            if (targetPiece==null || targetPiece.isWhite() != this.isWhite()) { // this.isWhite() returns the color of the piece so that we can check if the piece is of the same color or not
                return true;
            }
        }
        return false;
    }

    public void capture(){
        this.setKilled(true); // this.setKilled() sets the king as killed
    }
}
