package lowLevelDesigns.chess.models;

import lowLevelDesigns.chess.models.pieces.*;

public class ChessBoard {
    Piece[][] board;
    Player whitePlayer;
    Player blackPlayer;
    Player currentPlayer;

    public ChessBoard() {
        board = new Piece[8][8];
        initializePlayers();
        initializeBoard();
        currentPlayer = whitePlayer;
    }

    private void initializeBoard() {
        placePieces(whitePlayer, 0);
        placePieces(blackPlayer, 7);
    }

    private void placePieces(Player player, int row) {
        for (int i = 0; i < 8; i++) {
            board[i][row + (player.isWhite() ? 1 : -1)] = new Pawn(player.isWhite, new Position(i, row + (player.isWhite() ? 1 : -1)));
        }

        board[0][row] = new Rook(player.isWhite, new Position(0, row));
        board[7][row] = new Rook(player.isWhite, new Position(7, row));

        board[1][row] = new Knight(player.isWhite, new Position(1, row));
        board[6][row] = new Knight(player.isWhite, new Position(6, row));

        board[2][row] = new Bishop(player.isWhite, new Position(2, row));
        board[5][row] = new Bishop(player.isWhite, new Position(5, row));

        board[3][row] = new Queen(player.isWhite, new Position(3, row));
        board[4][row] = new King(player.isWhite, new Position(4, row));
    }

    private void initializePlayers() {
        whitePlayer = new Player("White Player", true);
        blackPlayer = new Player("Black Player", false);
    }

    public boolean movePiece(Position start, Position end){
        Piece pieceToMove=getPiece(start);

        if (pieceToMove != null && pieceToMove.isWhite()==currentPlayer.isWhite() &&pieceToMove.canMove(end,this)){
            Piece targetPiece=getPiece(end);

            if (targetPiece!=null){
                targetPiece.setKilled(true);
            }

            board[end.getX()][end.getY()]=pieceToMove;
            board[start.getX()][start.getY()]=null;
            pieceToMove.setPosition(end);

            currentPlayer=(currentPlayer==whitePlayer)?blackPlayer:whitePlayer;
            return true;
        }
        return false;
    }

    public Piece getPiece(Position position) {
        return board[position.getX()][position.getY()];
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public void displayBoard(){
        for(int y=7; y>=0; y--){
            for(int x=0; x<8; x++){
                Piece piece=board[x][y];
                if (piece!=null){
                    System.out.print(piece.getClass().getSimpleName().charAt(0)+" "); //first letter of piece
                }
                else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

//    public boolean isInCheck(Player player){
//        Position kingPosition=findKing(player);
//    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }
}
