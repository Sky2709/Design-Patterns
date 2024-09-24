package lowLevelDesigns.chess.controllers;

import lowLevelDesigns.chess.services.GameService;

public class GameController {
    private GameService gameService;

    public GameController(){
        gameService = new GameService();
    }

    public void start(){
        gameService.start();
    }

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.start();
    }
}
