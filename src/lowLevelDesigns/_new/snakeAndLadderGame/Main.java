package lowLevelDesigns._new.snakeAndLadderGame;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        GameManager gameManager= GameManager.getInstance();

        List<String> players1= Arrays.asList("Ram", "Shyam", "Gita");
        gameManager.startNewGame(players1);

//        List<String> players2= Arrays.asList("Gita", "Sita");
//        gameManager.startNewGame(players2);
    }


}
