package com.mygdx.game.game;

import static com.mygdx.game.UI.screens.PlayScreen.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.helpers.Const;
import com.mygdx.game.models.Assets;

public class Gameplay {
    public static Sprite lowerLimit,upperLimit;

    public Gameplay(){
        lowerLimit = new Sprite();
        lowerLimit.setPosition(0,0);
        lowerLimit.setSize(Const.screenWidth,5);

        upperLimit = new Sprite();
        upperLimit.setPosition(0,Const.screenHeight);
        upperLimit.setSize(Const.screenWidth,5);
    }
    //First player hit-box
    public static void secondPlayerLimits(){
        if(secondPlayer.getBoundingRectangle().overlaps(upperLimit.getBoundingRectangle())
                || secondPlayer.getBoundingRectangle().overlaps(lowerLimit.getBoundingRectangle())) {
            Const.speedSecondPlayer *= -1;
        }
    }
    //First player hit-box
    public static void firstPlayerLimits(){
        if(firstPlayer.getBoundingRectangle().overlaps(upperLimit.getBoundingRectangle())
                || firstPlayer.getBoundingRectangle().overlaps(lowerLimit.getBoundingRectangle())) {
            Const.speedFirstPlayer *= -1;
        }
    }

    public  void ballLogic(){
        // Check the bounce of the ball from the upper limit, if so, we change the direction of the ball
        if(ball.getBoundingRectangle().overlaps(upperLimit.getBoundingRectangle())) {
            ball.setY(Const.speedBall > 0 ? ball.getY() - Const.speedBall : ball.getY() + Const.speedBall);
            Const.verticalDirection = 0;

            Assets.playWallBounceSound();
        }
        // Check the bounce of the ball from the lower limit, if so, we change the direction of the ball
        if(ball.getBoundingRectangle().overlaps(lowerLimit.getBoundingRectangle())) {
            ball.setY(Const.speedBall < 0 ? ball.getY() - Const.speedBall : ball.getY() + Const.speedBall);
            Const.verticalDirection = 1;

            Assets.playWallBounceSound();
        }
        // Check the bounce of the ball from the second player, if so, we change the direction of the ball
        if(ball.getBoundingRectangle().overlaps(secondPlayer.getBoundingRectangle())) {
            ball.setX(ball.getX() - Const.speedBall * 2);
            Const.speedBall *= -1;
            if(ball.getY() > secondPlayer.getY() - 20f || ball.getY() - 70f < secondPlayer.getY()) {
                Const.verticalDirection = ball.getY() - 20f  > secondPlayer.getY() ? 1 : 0;
            }
            else {
                Const.verticalDirection = Const.verticalDirection == 0 ? 0 : 1;
            }

            Assets.playPlayersBounceSound();
        }
        // Check the bounce of the ball from the first player, if so, we change the direction of the ball
        if(ball.getBoundingRectangle().overlaps(firstPlayer.getBoundingRectangle())) {
            ball.setX(ball.getX() - Const.speedBall * 2);
            Const.speedBall *= -1;
            if(ball.getY() - 20f > firstPlayer.getY() || ball.getY() - 70f < firstPlayer.getY()) {
                Const.verticalDirection = ball.getY() - 20f > firstPlayer.getY() ? 1 : 0;
            }
            else {
                Const.verticalDirection = Const.verticalDirection == 0 ? 0 : 1;
            }
            Assets.playPlayersBounceSound();
        }

        if (ball.getX() > Const.screenWidth - 40f || ball.getX() < 0) {
            gameReset(ball.getX() < 0 ? -1 : 1);
        }
    }

    public  void gameReset(int score){
        if(score > 0) { //First player sound and upp score
            Const.firstPlayerScore += 1;
            Assets.playWinnerSound();
        }
        else { //Second player sound and upp score
            Const.secondPlayerScore += 1;
            Assets.playLooserSound();
        }
        //Increase speed of players and change direction
        Const.speedBall = Const.speedBall > 0 ? (Const.speedBall * -score) + 0.06f : (Const.speedBall * score) + 0.06f;
        Const.speedSecondPlayer = Const.speedFirstPlayer += 0.11f;
        //Reset objects position
        firstPlayer.setPlayerPosition();
        secondPlayer.setPlayerPosition();

        ball.setBallPosition();
    }
}
