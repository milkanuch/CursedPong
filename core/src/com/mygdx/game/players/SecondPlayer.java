package com.mygdx.game.players;
import com.mygdx.game.helpers.Const;

public class SecondPlayer {
    private int posX,posY;

    public SecondPlayer(){
        //Base position
        posX = 0; posY = Const.screenHeight/2;
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
