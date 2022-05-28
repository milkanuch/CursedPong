package com.mygdx.game.UI.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.CursedPong;

public class LoadingScreen implements Screen {
        private final CursedPong cursedPong;

        private ShapeRenderer shapeRenderer;
        private float progress;

        public LoadingScreen(CursedPong game){
            this.cursedPong = game;
            this.shapeRenderer = new ShapeRenderer();
        }

        @Override
        public void show() {
            shapeRenderer.setProjectionMatrix(cursedPong.orthographicCamera.combined);
            this.progress = 0f;

            cursedPong.assetsManager.load("backgrounds/back.png", Texture.class);
            cursedPong.assetsManager.load("ui/skin.atlas", TextureAtlas.class);
        }

        private void update() {
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
          shapeRenderer.setColor(Color.BLACK);
          shapeRenderer.rect(32, cursedPong.orthographicCamera.viewportHeight / 2 - 8, cursedPong.orthographicCamera.viewportWidth - 64, 16);

          shapeRenderer.setColor(Color.PURPLE);
          shapeRenderer.rect(32, cursedPong.orthographicCamera.viewportHeight / 2 - 8, progress * (cursedPong.orthographicCamera.viewportWidth - 64), 16);
          shapeRenderer.end();
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
             shapeRenderer.dispose();
        }
}
