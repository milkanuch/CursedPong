package com.mygdx.game.ball;
import com.mygdx.game.helpers.Const;

public class Ball {
    public static int posX,posY;

    public Ball() {
        posX = Const.screenWidth/2;
        posY = Const.screenHeight/2;
    }
    public static void setX(int value){ posX += value; }
    public static void setY(int value){ posY += value; }

    public static int getX(){ return posX; }
    public static int getY(){ return posY; }
}
