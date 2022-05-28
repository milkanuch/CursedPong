package com.mygdx.game.UI.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Control;
import com.mygdx.game.CursedPong;
import com.mygdx.game.ball.Ball;
import com.mygdx.game.game.GamePlay;
import com.mygdx.game.helpers.Const;
import com.mygdx.game.models.Assets;
import com.mygdx.game.players.FirstPlayer;
import com.mygdx.game.players.SecondPlayer;

public class PlayScreen implements Screen {
        private final CursedPong cursedPong;

        private SpriteBatch batch;
        private Texture img;
        public OrthographicCamera orthographicCamera;

        public static Ball ball;
        public static FirstPlayer firstPlayer;
        public static SecondPlayer secondPlayer;
        private GamePlay gamePlay;

        BitmapFont bitmapFont;

        public Control control;

        public  PlayScreen(CursedPong game){
            cursedPong = game;

            batch = new SpriteBatch();
            ball = new Ball(Assets.ball); //Ball
            //Players
            firstPlayer = new FirstPlayer(Assets.firstPlayer);
            secondPlayer = new SecondPlayer(Assets.secondPlayer);
            //Camera
            orthographicCamera = new OrthographicCamera();
            orthographicCamera.setToOrtho(false, Const.screenWidth,Const.screenHeight);
            orthographicCamera.position.set(Const.screenWidth,Const.screenHeight,0);
            //Lines
            control = new Control();

            gamePlay = new GamePlay();

            bitmapFont = new BitmapFont();
            bitmapFont.setColor(1f,1f,1f,1);
            bitmapFont.getData().setScale(4,4);
        }

        @Override
        public void show() {
            Gdx.input.setInputProcessor(control);
        }

        @Override
        public void render(float delta) {
            ScreenUtils.clear(0, 0, 0, 1);
            batch.begin();
            batch.draw(Assets.background,0, 0); //Background render
            ball.draw(batch); //Ball render

            batch.draw(Assets.score,70f, Const.screenHeight-50f,120,34); //First Player Score
            batch.draw(Assets.score,Const.screenWidth-200f,Const.screenHeight-50f,120,34); //Second player score
            batch.draw(Assets.pause,(Const.screenWidth/2)-50f,Const.screenHeight-40f,120,34); //Pause

            firstPlayer.draw(batch); //First player render
            secondPlayer.draw(batch); //Second player render

            firstPlayer.update(control); //Moving our player
            secondPlayer.update(); //Moving ai player
            ball.update(); //Moving ball

            gamePlay.firstPlayerLimits(); //Checking if first player over upper/lower limits
            gamePlay.secondPlayerLimits(); //Checking if second player over upper/lower limits
            gamePlay.ballLogic();  //Ball logic

            bitmapFont.draw(batch,String.valueOf(Const.firstPlayerScore),230f,Const.screenHeight - 10f);
            bitmapFont.draw(batch,String.valueOf(Const.secondPlayerScore),Const.screenWidth-250f,Const.screenHeight - 10f);
            batch.end();
        }

        @Override
        public void resize(int width, int height) {

        }

        @Override
        public void pause() {

        }

        @Override
        public void resume() {

        }

        @Override
        public void hide() {

        }

        @Override
        public void dispose() {

        }
}
