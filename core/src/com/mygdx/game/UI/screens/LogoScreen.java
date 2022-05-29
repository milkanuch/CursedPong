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

        private final Stage stage;

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
          Texture splashTex = cursedPong.assetsManager.get("backgrounds/coffee.png", Texture.class);
          Image splashImg = new Image(splashTex);
          splashImg.setOrigin(splashImg.getWidth(), splashImg.getHeight() );
          splashImg.setPosition(0, 0);
          splashImg.addAction(sequence(alpha(0), scaleTo(.1f, .1f),
                parallel(fadeIn(1f, Interpolation.pow2),
                        scaleTo(1f, 1f, 1.5f, Interpolation.pow5),
                        moveTo(-80f  ,100f , 2f, Interpolation.swing)),
                delay(1.5f), fadeOut(1.5f), run(transitionRunnable)));

          stage.addActor(splashImg);
        }

        @Override
        public void render(float delta) {
           Gdx.gl.glClearColor(0.41f, 0.23f,0.72f, 1f);
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
