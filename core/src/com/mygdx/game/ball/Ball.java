package com.mygdx.game.ball;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.helpers.Const;


public class Ball extends Sprite {

    public Ball(Texture body) {
        super(body);
        setSize(60,60);
        setX(600);
        setY(400);
    }

    public void update(){
        if(Const.speedBall > 0 && Const.verticalDirection > 0
                || Const.speedBall < 0 && Const.verticalDirection < 1) {
            setX(getX() + Const.speedBall);
            setY(getY() + Const.speedBall);
        }
        if(Const.speedBall < 0 && Const.verticalDirection > 0
                || Const.speedBall > 0 && Const.verticalDirection < 1){
            setX(getX() + Const.speedBall);
            setY(getY() - Const.speedBall);
        }
    }

    public void setBallPostion(){
        setX(Const.screenWidth/2);
        setY(Const.screenHeight/2);
    }
}
