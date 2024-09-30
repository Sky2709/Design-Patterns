package lowLevelDesigns._new.snakeAndLadderGame;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int boardSize=100;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board() {
        snakes= new ArrayList<>();
        ladders= new ArrayList<>();
        initializeSnakeAndLadder();
    }

    private void initializeSnakeAndLadder() {
        snakes.add(new Snake(98,6));
        snakes.add(new Snake(99,17));
        snakes.add(new Snake(92,77));
        snakes.add(new Snake(87,24));
        snakes.add(new Snake(65,4));
        snakes.add(new Snake(39,8));
        snakes.add(new Snake(21,11));


        ladders.add(new Ladder(5,35));
        ladders.add(new Ladder(10,65));
        ladders.add(new Ladder(21,39));
        ladders.add(new Ladder(44,56));
        ladders.add(new Ladder(16,90));
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getNewPositionAfterSnakeOrLadder(int position){
        for (Snake snake : snakes) {
            if(snake.getStart()==position){
                return snake.getEnd();
            }
        }

        for (Ladder ladder : ladders) {
            if(ladder.getStart()==position){
                return ladder.getEnd();
            }
        }

        return position;
    }
}
