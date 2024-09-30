package lowLevelDesigns._new.snakeAndLadderGame;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static GameManager gameManagerInstance;
    private List<SnakeAndLadderGame> games;

    private GameManager() {
        this.games= new ArrayList<>();
    }

    public static synchronized GameManager getInstance() {
        if(gameManagerInstance == null) {
            gameManagerInstance = new GameManager();
        }
        return gameManagerInstance;
    }

    public void startNewGame(List<String> playerNames){
        SnakeAndLadderGame game = new SnakeAndLadderGame(playerNames);
        games.add(game);
        new Thread(()-> game.play()).start();
    }
}
