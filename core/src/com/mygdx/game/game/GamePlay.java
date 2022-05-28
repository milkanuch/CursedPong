package com.mygdx.game.game;

import static com.mygdx.game.UI.screens.PlayScreen.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.UI.Score;
import com.mygdx.game.helpers.Const;
import com.mygdx.game.models.Assets;

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

    public static void ballLogic(){
        if(ball.getBoundingRectangle().overlaps(upperLimit.getBoundingRectangle())) {
            ball.setY(Const.speedBall > 0 ? ball.getY() - Const.speedBall : ball.getY() + Const.speedBall);
            Const.verticalDirection = 0;

            Assets.playWallBounceSound();
        }

        if(ball.getBoundingRectangle().overlaps(lowerLimit.getBoundingRectangle())){
            ball.setY(Const.speedBall < 0 ? ball.getY() - Const.speedBall : ball.getY() + Const.speedBall);
            Const.verticalDirection = 1;

            Assets.playWallBounceSound();
        }

        if(ball.getBoundingRectangle().overlaps(secondPlayer.getBoundingRectangle())){
            ball.setX(ball.getX() - Const.speedBall * 2);
            Const.speedBall *= -1;
            Const.verticalDirection = Const.verticalDirection == 0 ? 0 : 1;

            Assets.playPlayersBounceSound();
        }

        if(ball.getBoundingRectangle().overlaps(firstPlayer.getBoundingRectangle())){
            ball.setX(ball.getX() - Const.speedBall * 2);
            Const.speedBall *= -1;
            Const.verticalDirection = Const.verticalDirection == 0 ? 0 : 1;

            Assets.playPlayersBounceSound();
        }

        if (ball.getX() > Const.screenWidth - 40f || ball.getX() < 0) {
            setWinner(ball.getX() < 0 ? -1 : 1);
        }
    }

    public static void setWinner(int score){
        if(score > 0) { //First player sound and upp score
            Score.firstPlayerScore += 1;
            Assets.playWinnerSound();
        }
        else { //Second player sound and upp score
            Score.secondPlayerScore += 1;
            Assets.playLooserSound();
        }
        //Increase speed of players and change direction
        Const.speedBall = Const.speedBall > 0 ? (Const.speedBall * -score) + 0.11f : (Const.speedBall * score) + 0.11f;
        Const.speedSecondPlayer = Const.speedFirstPlayer += 0.11f;
        gameReset();
    }
    //Reset Game Object position
    public static void gameReset(){
        firstPlayer.setPlayerPosition();
        secondPlayer.setPlayerPosition();

        ball.setBallPosition();
    }

}
