package lowLevelDesigns.ticTacToe;

public class Board {
    private char[][] board;
    private int movesCount;

    public Board() {
        this.board = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for(int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                board[i][j] = '-';
            }
        }
    }

    public synchronized void makeMove(int row, int col, char symbol){
        if (row<0 || row>=3 || col<0 || col>=3 || board[row][col]!='-' || (symbol!='X' && symbol!='O')){
            throw new IllegalArgumentException("Invalid move, please try again");
        }
        board[row][col] = symbol;
        movesCount++;
    }

    public boolean isFull(){
        return movesCount==9;
    }

    public boolean hasWinner(){
        //check rows
        for (int row=0; row<3; row++){
            if (board[row][0]!='-' && board[row][0]==board[row][1] && board[row][1]==board[row][2]){
                return true;
            }
        }

        //check columns
        for (int col=0; col<3; col++){
            if (board[0][col]!='-' && board[0][col]==board[1][col] && board[1][col]==board[2][col]){
                return true;
            }
        }

        //check diagonal1
        if (board[0][0]!='-' && board[0][0]==board[1][1] && board[1][1]==board[2][2]){
            return true;
        }
        //check diagonal2
        return board[0][2]!='-' && board[0][2]==board[1][1] && board[1][1]==board[2][0];
    }

    public void printBoard(){
        for(int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(); //empty line
    }
}
