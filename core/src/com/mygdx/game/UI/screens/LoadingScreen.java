package com.mygdx.game.UI.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.CursedPong;


public class LoadingScreen implements Screen {
        private final CursedPong cursedPong;

        private final ShapeRenderer shapeRenderer;
        private float progress;

        public LoadingScreen(CursedPong game){
            this.cursedPong = game;
            this.shapeRenderer = new ShapeRenderer();
        }

        @Override
        public void show() {
            shapeRenderer.setProjectionMatrix(cursedPong.orthographicCamera.combined);
            this.progress = 0f;
            cursedPong.assetsManager.load("backgrounds/coffee.png", Texture.class);
            cursedPong.assetsManager.load("ui/skin.atlas", TextureAtlas.class);
        }

        private void update() {
            //Checks our asset's loading
            progress = MathUtils.lerp(progress, cursedPong.assetsManager.getProgress(), .1f);
            if (cursedPong.assetsManager.update() && progress >= cursedPong.assetsManager.getProgress() - .001f) {
                  cursedPong.setScreen(cursedPong.logoScreen);
            }
        }

        @Override
        public void render(float delta) {
          Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
          Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

          update();
          shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
          shapeRenderer.setColor(0.16f,0.16f,0.16f,1f);
          shapeRenderer.rect(32, cursedPong.orthographicCamera.viewportHeight / 2 - 8, cursedPong.orthographicCamera.viewportWidth - 64, 16);

          shapeRenderer.setColor(0.41f, 0.23f,0.72f, 1f);
          //Renders loading progress bar on screen
          shapeRenderer.rect(32, cursedPong.orthographicCamera.viewportHeight / 2 - 8, progress * (cursedPong.orthographicCamera.viewportWidth - 64), 16);
          shapeRenderer.end();
        }

        @Override
        public void resize(int width, int height) { }

        @Override
        public void pause() { }

        @Override
        public void resume() { }

        @Override
        public void hide() { }

        @Override
        public void dispose() {
             shapeRenderer.dispose();
        }
}
