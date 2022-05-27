package com.mygdx.game.game;

import static com.mygdx.game.CursedPong.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.UI.Score;
import com.mygdx.game.helpers.Const;


public class GamePlay {
    public static Sprite lowerLimit,upperLimit;

    public GamePlay(){
        lowerLimit = new Sprite();
        lowerLimit.setPosition(0,0);
        lowerLimit.setSize(Const.screenWidth,5);

        upperLimit = new Sprite();
        upperLimit.setPosition(0,Const.screenHeight);
        upperLimit.setSize(Const.screenWidth,5);
    }

    public static void secondPlayerLimits(){
        if(secondPlayer.getBoundingRectangle().overlaps(upperLimit.getBoundingRectangle())
                || secondPlayer.getBoundingRectangle().overlaps(lowerLimit.getBoundingRectangle())) {
            Const.speedSecondPlayer *= -1;
        }
    }

    public static void firstPlayerLimits(){
        if(firstPlayer.getBoundingRectangle().overlaps(upperLimit.getBoundingRectangle())
                || firstPlayer.getBoundingRectangle().overlaps(lowerLimit.getBoundingRectangle())) {
            Const.speedFirstPlayer *= -1;
        }
    }

    public static void ballLimits(){
        if(ball.getBoundingRectangle().overlaps(upperLimit.getBoundingRectangle())) {
            ball.setY(Const.speedBall > 0 ? ball.getY() - Const.speedBall : ball.getY() + Const.speedBall);
            Const.verticalDirection = 0;
            secondPlayer.calculateBallNextPosition();
        }

        if(ball.getBoundingRectangle().overlaps(lowerLimit.getBoundingRectangle())){
            ball.setY(Const.speedBall < 0 ? ball.getY() - Const.speedBall : ball.getY() + Const.speedBall);
            Const.verticalDirection = 1;
            secondPlayer.calculateBallNextPosition();
        }

        if(ball.getBoundingRectangle().overlaps(secondPlayer.getBoundingRectangle())){
            ball.setX(ball.getX() - Const.speedBall * 2);
            Const.speedBall *= -1;
            Const.verticalDirection = Const.verticalDirection == 0 ? 0 : 1;
        }

        if(ball.getBoundingRectangle().overlaps(firstPlayer.getBoundingRectangle())){
            ball.setX(ball.getX() - Const.speedBall * 2);
            Const.speedBall *= -1;
            Const.verticalDirection = Const.verticalDirection == 0 ? 0 : 1;
        }

        if (ball.getX() > Const.screenWidth - 40f){
            System.out.println("X " + ball.getX() + " Y " + ball.getY() + " LOOSE  ");
            Score.firstPlayerScore +=1;
            gameReset();
        }

        if(ball.getX() < 0){
            Score.secondPlayerScore += 1;
            gameReset();
        }
    }

    public static void gameReset(){
        firstPlayer.setPlayerPosition();
        secondPlayer.setPlayerPosition();

        ball.setBallPostion();
    }



}
