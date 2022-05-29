package com.mygdx.game.UI.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
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

public class DifficultyScreen implements Screen {
    private final CursedPong cursedPong;
    private final Stage stage;
    private final ImageButton easy,hard;

    public DifficultyScreen(final CursedPong game){
        //Easy
        Drawable easyImage = new TextureRegionDrawable(new TextureRegion(Assets.easy));
        easy = new ImageButton(easyImage);
        //Hard
        Drawable hardImage = new TextureRegionDrawable(new TextureRegion(Assets.hard));
        hard = new ImageButton(hardImage);

        //Making something like grid where we put our buttons;
        this.cursedPong = game;
        this.stage = new Stage(new FitViewport(Const.screenWidth, Const.screenHeight, game.orthographicCamera));
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.clear();

        easy.setPosition(Const.screenWidth/2 - 350f,Const.screenHeight/2);
        easy.setSize(250,100);
        easy.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){
                cursedPong.setScreen(cursedPong.playScreen);
                Const.levelOfDifficulty = 1;
            }
        });

        hard.setPosition(Const.screenWidth/2 + 100f,Const.screenHeight/2);
        hard.setSize(250,100);
        hard.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){
                cursedPong.setScreen(cursedPong.playScreen);
                Const.levelOfDifficulty = 2;
            }
        });

        stage.addActor(easy);
        stage.addActor(hard);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        stage.draw();
    }
    private void update(float delta) {
        stage.act(delta);
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