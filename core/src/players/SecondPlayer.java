package players;
import com.badlogic.gdx.Gdx;
public class SecondPlayer {
    private int posX,posY;

    public SecondPlayer(){
        posX = 0; posY = Gdx.graphics.getHeight()/2; //Base position
    }

    //Sets coordinates for Second player
    public void setX(int value){ posX += value; }
    public void setY(int value){ posY += value; }

    //Returns coordinates from Second player
    public int getX(){
        return posX;
    }
    public int getY(){
        return posY;
    }
}
