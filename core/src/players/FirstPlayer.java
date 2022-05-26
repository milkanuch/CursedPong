package players;

import com.badlogic.gdx.Gdx;

public class FirstPlayer {
    private int posX,posY;

    public FirstPlayer(){
        //Basic position
        posX = 0; posY = Gdx.graphics.getHeight()/2;
    }
    //Sets coordinates for First player
    public void setX(int value){ posX += value; }
    public void setY(int value){ posY += value; }

    //Returns coordinates from First player
    public int getX(){
        return posX;
    }
    public int getY(){
        return posY;
    }
}
