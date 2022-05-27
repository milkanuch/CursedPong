package com.mygdx.game.ball;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.helpers.Const;

import java.util.Random;

public class Ball extends Sprite {

    public Ball(Texture body) {
        super(body);
        setSize(60,60);
        setX(Const.screenWidth/2);
        setY(Const.screenHeight/2);
    }

    public void update(){
        Random rand = new Random();
        setX((getX() + 1 * Const.speedBall));
        setY((getY() + 1 * Const.speedBall));
    }
}
