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

public class MenuScreen implements Screen {
    private final CursedPong app;
    private Stage stage;
    private ImageButton menu,play,shop,exit;


    public MenuScreen(final CursedPong app) {
        //Set Menu button
        Drawable menuImage = new TextureRegionDrawable(new TextureRegion(Assets.menu));
        menu = new ImageButton(menuImage);
        //Set play button image(texture)
        Drawable playImage = new TextureRegionDrawable(new TextureRegion(Assets.play));
        play = new ImageButton(playImage);
        //Set shop button image(texture)
        Drawable shopImage = new TextureRegionDrawable(new TextureRegion(Assets.shop));
        shop = new ImageButton(shopImage);
        //Set shop button image(texture)
        Drawable exitImage = new TextureRegionDrawable(new TextureRegion(Assets.exit));
        exit = new ImageButton(exitImage);

        //Making something like grid where we put our buttons;
        this.app = app;
        this.stage = new Stage(new FitViewport(Const.screenWidth, Const.screenHeight, app.orthographicCamera));
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.clear();

        buttonRender();
    }

    private void buttonRender() {
        menu.setPosition((Const.screenWidth/2) - 300f,100f);
        menu.setSize(500,100);

        play.setPosition((Const.screenWidth/2) - 300f, Const.screenHeight/2);
        play.setSize(500,100);
        play.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.setScreen(app.playScreen);
            }
        });

        shop.setPosition((Const.screenWidth/2) - 300f, (Const.screenHeight/2) - 50f);
        shop.setSize(500,100);

        exit.setPosition((Const.screenWidth/2) - 300f, (Const.screenHeight/2) - 100f);
        exit.setSize(500, 100);
        exit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        stage.addActor(play);
        stage.addActor(shop);
        stage.addActor(exit);
    }

    private void update(float delta) {
        stage.act(delta);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
    }


}
