package com.mygdx.game.players;

import static com.mygdx.game.UI.screens.PlayScreen.ball;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.helpers.Const;

public class SecondPlayer extends Sprite {
    public SecondPlayer(Texture body){
        //Base position
        super(body);
        setPlayerPosition();
    }

    public void update() {
        if(Const.levelOfDifficulty == 1){
            easyDifficulty();
        }
        else{
            hardDifficulty();
        }
    }

    public void hardDifficulty(){
        if (ball.getY() < getY() || ball.getY() == Const.screenHeight - 120f) {
            setY(getY() - Const.speedSecondPlayer);
        }
        if (ball.getY() - 40f > getY()) {
            setY(getY() + Const.speedSecondPlayer);
        }
    }

    public void easyDifficulty(){
        setY(getY() + Const.speedSecondPlayer);
    }

    public void setPlayerPosition() {
        setX(Const.screenWidth - 54f);
        setY(Const.screenHeight/2);
    }

    /* Need to upgrade logic
    public void calculateBallNextPosition() {
        if(Const.verticalDirection > 0)
            Const.ballNextPosition = Math.abs((Const.screenHeight - (Const.screenWidth - ball.getX()) - Const.speedBall) - (134 / 2));
        else
            Const.ballNextPosition = Math.abs((Const.screenWidth - ball.getX()) - Const.speedBall - (134 / 2));
        System.out.println(Const.ballNextPosition);
    } */
}
