package com.mygdx.game.UI.screens;

import static com.mygdx.game.game.GamePlay.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
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

import java.text.DecimalFormat;

public class PlayScreen implements Screen {
        private final CursedPong cursedPong;

        private final SpriteBatch batch;
        public OrthographicCamera orthographicCamera;

        public static Ball ball;
        public static FirstPlayer firstPlayer;
        public static SecondPlayer secondPlayer;

        private final BitmapFont bitmapFont,timerFont;
        private final GamePlay gamePlay;
        public Control control;
        private static float time;
        public PlayScreen(final CursedPong game){
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
            bitmapFont = new BitmapFont();
            timerFont = new BitmapFont();
            bitmapFont.setColor(0.9f,0.9f,0.9f,0.9f);
            bitmapFont.getData().setScale(4,4);
            timerFont.setColor(0.9f,0.9f,0.9f,0.9f);
            timerFont.getData().setScale(2,2);
            time = 0;
            gamePlay = new GamePlay(game);
            this.cursedPong = game;
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

            firstPlayer.draw(batch); //First player render
            secondPlayer.draw(batch); //Second player render
            //Moving our player

            firstPlayer.update(control);
            gamePlay.firstPlayerLimits();

            secondPlayer.update(); //Moving ai player
            ball.update(); //Moving ball

            //Checking if first player over upper/lower limits
            gamePlay.secondPlayerLimits(); //Checking if second player over upper/lower limits
            gamePlay.ballLogic();  //Ball logic

            batch.draw(Assets.timer,Const.screenWidth/2 - 60f,Const.screenHeight - 77f,125,66);
            time += delta;
            bitmapFont.draw(batch,String.valueOf(Const.firstPlayerScore),230f,Const.screenHeight - 10f);
            bitmapFont.draw(batch,String.valueOf(Const.secondPlayerScore),Const.screenWidth-300f,Const.screenHeight - 10f);
            timerFont.draw(batch,String.format("%.0f",time) + " s",Const.screenWidth/2 - 15f,Const.screenHeight - 32f);

            mainMenu();
            setWinner();
            batch.end();
        }

        public void mainMenu(){
            if(Const.mainMenu){
                cursedPong.setScreen(cursedPong.menuScreen);
                Const.mainMenu = false;
            }
        }

        public  void setWinner() {
            if (Const.firstPlayerScore == 1 || Const.secondPlayerScore == 1) {
                Const.gameWinner = Const.firstPlayerScore == 1 ? 1 : 2;
                System.out.println(Const.firstPlayerScore);
                cursedPong.setScreen(cursedPong.winnersScreen);
                Const.firstPlayerScore = 0;
                Const.secondPlayerScore = 0;
            }
        }

        @Override
        public void resize(int width, int height) {

        }

        @Override
        public void pause() {
            Gdx.graphics.setContinuousRendering(false);
        }

        @Override
        public void resume() {
            Gdx.graphics.requestRendering();
        }

        @Override
        public void hide() {

        }

        @Override
        public void dispose() {

        }
}
