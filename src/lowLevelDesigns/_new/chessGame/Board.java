package lowLevelDesigns._new.chessGame;

import lowLevelDesigns._new.chessGame.pieces.*;

public class Board {
    private Piece[][] board; // Piece because each cell can have a piece or not have a piece (null)

    public Board() {
        board = new Piece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        board[0][0] = new Rook(Color.WHITE, 0, 0);
        board[0][1] = new Knight(Color.WHITE, 0, 1);
        board[0][2] = new Bishop(Color.WHITE, 0, 2);
        board[0][3] = new Queen(Color.WHITE, 0, 3);
        board[0][4] = new King(Color.WHITE, 0, 4);
        board[0][5] = new Bishop(Color.WHITE, 0, 5);
        board[0][6] = new Knight(Color.WHITE, 0, 6);
        board[0][7] = new Rook(Color.WHITE, 0, 7);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Color.WHITE, 1, i);
        }

        board[7][0] = new Rook(Color.BLACK, 7, 0);
        board[7][1] = new Knight(Color.BLACK, 7, 1);
        board[7][2] = new Bishop(Color.BLACK, 7, 2);
        board[7][3] = new Queen(Color.BLACK, 7, 3);
        board[7][4] = new King(Color.BLACK, 7, 4);
        board[7][5] = new Bishop(Color.BLACK, 7, 5);
        board[7][6] = new Knight(Color.BLACK, 7, 6);
        board[7][7] = new Rook(Color.BLACK, 7, 7);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(Color.BLACK, 6, i);
        }
    }


    public boolean isStraightPathClear(int row, int col, int destRow, int destCol) {
        if (row == destRow) {
            int start = Math.min(col, destCol);
            int end = Math.max(col, destCol);
            for (int i = start+1; i < end; i++) {
                if (board[row][i] != null) {
                    return false;
                }
            }
        } else if (col == destCol) {
            int start = Math.min(row, destRow);
            int end = Math.max(row, destRow);
            for (int i = start+1; i < end; i++) {
                if (board[i][col] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    public boolean isValidMove(Piece piece, int destRow, int destCol){
        if (piece==null || destRow<0 || destRow>7 || destCol<0 || destCol>7) {
            return false;
        }

        Piece destPiece = getPiece(destRow, destCol);
        return (destPiece==null || destPiece.getColor() != piece.getColor() &&
                piece.canMove(this, destRow, destCol));
    }

    public boolean isCheckmate(Color color) {
        // Check if the king of the given color is under check and there is no valid move to save the king
        return false;
    }

    public boolean isStalemate(Color color) {
        // Check if the king of the given color is not under check and there is no valid move to make
        return false;
    }
}
