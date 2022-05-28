package com.mygdx.game.UI.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.CursedPong;
import com.mygdx.game.helpers.Const;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class LogoScreen implements Screen {
        private final CursedPong cursedPong;

        private Stage stage;
        private Image splashImg;

        public LogoScreen(CursedPong game){
           this.cursedPong = game;
           this.stage = new Stage(new FitViewport(Const.screenWidth, Const.screenHeight, game.orthographicCamera));
        }

        @Override
        public void show() {
           Gdx.input.setInputProcessor(stage);

           Runnable transitionRunnable = new Runnable() {
                @Override
                public void run() {
                    cursedPong.setScreen(cursedPong.menuScreen);
               }
           };
          Texture splashTex = cursedPong.assetsManager.get("backgrounds/back.png", Texture.class);
          splashImg = new Image(splashTex);
          splashImg.setOrigin(splashImg.getWidth() / 2, splashImg.getHeight() / 2);
          splashImg.setPosition(stage.getWidth() / 2 - 32, stage.getHeight() + 32);
          splashImg.addAction(sequence(alpha(0), scaleTo(.1f, .1f),
                parallel(fadeIn(2f, Interpolation.pow2),
                        scaleTo(2f, 2f, 2.5f, Interpolation.pow5),
                        moveTo(stage.getWidth() / 2 - 32, stage.getHeight() / 2 - 32, 2f, Interpolation.swing)),
                delay(1.5f), fadeOut(1.25f), run(transitionRunnable)));

          stage.addActor(splashImg);
        }

        @Override
        public void render(float delta) {
           Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
           Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
           stage.act(delta);

           stage.draw();
        }

        @Override
        public void resize(int width, int height) {
          stage.getViewport().update(width, height, false);
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
        public void dispose() { stage.dispose();
        }
}
