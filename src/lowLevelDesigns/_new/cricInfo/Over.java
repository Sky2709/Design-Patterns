package lowLevelDesigns._new.cricInfo;

import java.util.ArrayList;
import java.util.List;

public class Over {
    private int overNumber;
    private List<Ball> balls;

    public Over(int overNumber) {
        this.overNumber = overNumber;
        this.balls = new ArrayList<>();
    }

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    public int getOverNumber() {
        return overNumber;
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
