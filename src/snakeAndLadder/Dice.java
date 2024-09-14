package snakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;
    int min = 1;
    int max = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int diceRoll(){
        int totalSum=0;
        int diceUsed = 0;

        while(diceUsed<diceCount){
            totalSum+= ThreadLocalRandom.current().nextInt(min, max + 1); //here we are using ThreadLocalRandom to generate random number between 1 to 6
            diceUsed++;
        }
        return totalSum;
    }
}
