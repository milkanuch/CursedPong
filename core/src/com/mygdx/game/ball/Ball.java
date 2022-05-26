package com.mygdx.game.ball;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.helpers.Const;

public class Ball extends Sprite {
    public static int posX,posY;

    public Ball(Texture body) {
        super(body);
        setSize(200,200);
        setX(Const.screenWidth/2);
        setY(Const.screenHeight/2);
    }

}
