package lowLevelDesigns.chess.models;

public class Position {
    int x;
    int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static Position fromString(String pos) {
        if (pos.length() !=2){
            throw new IllegalArgumentException("Invalid position format. It should be a letter followed by a number. e.g. e2");
        }

        char file = pos.charAt(0);
        char rank = pos.charAt(1);

        int x= file - 'a';
        int y= rank - '1';

        if (x < 0 || x >= 8 || y < 0 || y >= 8){
            throw new IllegalArgumentException("Position out of bounds. It should be between a1 and h8");
        }

        return new Position(x, y);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public boolean isValid(){
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
