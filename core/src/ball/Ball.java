package ball;

import com.badlogic.gdx.Gdx;

public class Ball {
    public static int posX,posY;

    public Ball() {
        posX = Gdx.graphics.getWidth()/2;
        posY = Gdx.graphics.getHeight()/2;
    }
    public static void setX(int value){ posX += value; }
    public static void setY(int value){ posY += value; }

    public static int getX(){ return posX; }
    public static int getY(){ return posY; }
}
