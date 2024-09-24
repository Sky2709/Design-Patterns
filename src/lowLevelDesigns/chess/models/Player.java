package lowLevelDesigns.chess.models;

import lowLevelDesigns.chess.models.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    boolean isWhite;
    List<Piece> pieces;

    public Player(String name, boolean isWhite) {
        this.name = name;
        this.isWhite = isWhite;
        this.pieces=initializePieces();
    }

    private List<Piece> initializePieces() {
        List<Piece> pieces= new ArrayList<>();

        for (int i=0; i<8; i++){
            pieces.add(new Pawn(isWhite, new Position(i, isWhite?1:6)));
        }

        pieces.add(new Rook(isWhite, new Position(0, isWhite?0:7)));
        pieces.add(new Rook(isWhite, new Position(7, isWhite?0:7)));

        pieces.add(new Knight(isWhite, new Position(1, isWhite?0:7)));
        pieces.add(new Knight(isWhite, new Position(6, isWhite?0:7)));

        pieces.add(new Bishop(isWhite, new Position(2, isWhite?0:7)));
        pieces.add(new Bishop(isWhite, new Position(5, isWhite?0:7)));

        pieces.add(new Queen(isWhite, new Position(3, isWhite?0:7)));
        pieces.add(new King(isWhite, new Position(4, isWhite?0:7)));

        return pieces;
    }

    public String getName() {
        return name;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void removePiece(Piece piece) {
        pieces.remove(piece);
    }
}
