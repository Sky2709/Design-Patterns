package lowLevelDesigns.chess.models.pieces;

import lowLevelDesigns.chess.models.ChessBoard;
import lowLevelDesigns.chess.models.Position;

public class Queen extends Piece{
    public Queen(boolean isWhite, Position position) {
        super(isWhite, position); // super() is used to call the constructor of the parent class
    }

    @Override
    public boolean canMove(Position end, ChessBoard board) {
        int startX=this.getPosition().getX();
        int startY=this.getPosition().getY();
        int endX=end.getX();
        int endY=end.getY();

        if (startX==endX || startY==endY || Math.abs(endX-startX)==Math.abs(endY-startY)){
            if (isPathClear(startX,startY,endX,endY,board)){
                Piece targetPiece=board.getPiece(end);
                if (targetPiece==null || targetPiece.isWhite()!=this.isWhite()){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPathClear(int startX, int startY, int endX, int endY, ChessBoard board) {
        int stepX=Integer.signum(endX-startX); // Integer.signum() returns the signum function of the argument
        int stepY=Integer.signum(endY-startY);

        int x=startX+stepX;
        int y=startY+stepY;

        while (x!=endX || y!=endY){
            if (board.getPiece(new Position(x,y))!=null){
                return false;
            }
            x+=stepX;
            y+=stepY;
        }
        return true;
    }

}
