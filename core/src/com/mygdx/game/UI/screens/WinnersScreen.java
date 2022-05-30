package com.mygdx.game.UI.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.CursedPong;
import com.mygdx.game.helpers.Const;
import com.mygdx.game.models.Assets;

public class WinnersScreen implements Screen {
        private  final CursedPong pong;
        private static Stage stage;
        private ImageButton menu;
        private SpriteBatch batch;

        public WinnersScreen(CursedPong game){
            Drawable menuImage = new TextureRegionDrawable(new TextureRegion(Assets.menu));
            menu = new ImageButton(menuImage);
            batch = new SpriteBatch();
            this.pong = game;
            this.stage = new Stage(new FitViewport(Const.screenWidth, Const.screenHeight, game.orthographicCamera));
        }
        @Override
        public void show() {
                Gdx.input.setInputProcessor(stage);
                stage.clear();

                menu.setPosition(Const.screenWidth/2 - 250f,150f);
                menu.setSize(500,100);
                menu.addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y){
                        pong.setScreen(pong.menuScreen);
                     }
                });
                stage.addActor(menu);
        }

        @Override
        public void render(float delta) {
          Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
          Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
          batch.begin();
          batch.draw(Assets.menuBackground,0,0);
          batch.draw(Const.gameWinner == 1 ? Assets.firstPlayerWin : Assets.secondPlayerWin,Const.screenWidth/2 - 250f,Const.screenHeight/2 - 200f,500,500);
          batch.end();
          stage.draw();
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
