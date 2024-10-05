package lowLevelDesigns.ticTacToe;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Player akash= new Player("Akash", 'X');
        Player rahul= new Player("Rahul", 'O');

        TicTacToeGame game= new TicTacToeGame(akash, rahul);
        game.play();
    }
}
