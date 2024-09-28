package lowLevelDesigns._new.chessGame;


import lowLevelDesigns._new.chessGame.pieces.Piece;

public class Player {
    private Color color;

    public Player(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void makeMove(Board board, Move move) {
        // validate move
        // if valid move, then make move

        Piece piece=move.getPiece();
        int destRow=move.getDestRow();
        int destCol=move.getDestCol();

        if (board.isValidMove(piece, destRow, destCol)) {
            int srcRow=piece.getRow();
            int srcCol=piece.getCol();
            board.setPiece(srcRow, srcCol, null);
            board.setPiece(destRow, destCol, piece);
            piece.setRow(destRow);
            piece.setCol(destCol);
        }
        else {
            throw new InvalidMoveException("Invalid Move");
        }
    }
}
