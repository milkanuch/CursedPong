package com.mygdx.game.players;

import com.mygdx.game.Control;
import com.mygdx.game.helpers.Const;

public class FirstPlayer {
    private int posX,posY;
    public int dirY;

    public FirstPlayer(){
        //Basic position
        posX = 0;
        posY = Const.screenHeight/2;
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

    public void update(Control control){
        dirY = 0;
        if(control.up)
            dirY = 3;
        if(control.down)
            dirY -=3;
        setY(dirY * Const.speed);
    }
}
