package lowLevelDesigns._new.snakeAndLadderGame;

public class Dice {
    private int minValue=1;
    private int maxValue=6;

    public int roll(){
        return (int) (Math.random() * (maxValue - minValue + 1) + minValue);
    }
}
