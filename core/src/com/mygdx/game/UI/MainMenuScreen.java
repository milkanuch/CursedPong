package com.mygdx.game.UI;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.models.Models;

public  class MainMenuScreen extends ApplicationAdapter {
    private Stage stage;
    private Viewport viewport;
    private Table mainTable;
    private ImageButton menu,play,shop,exit;

    @Override
    public void create() {
        viewport = new ExtendViewport(1280,720);
        stage = new Stage(viewport);

        mainTable = new Table();
        mainTable.setFillParent(true);

        stage.addActor(mainTable);
        //Set menu button image(texture)
        Drawable menuImage = new TextureRegionDrawable(new TextureRegion(Models.menu));
        menu = new ImageButton(menuImage);
        //Set play button image(texture)
        Drawable playImage = new TextureRegionDrawable(new TextureRegion(Models.play));
        menu = new ImageButton(playImage);
        //Set shop button image(texture)
        Drawable shopImage = new TextureRegionDrawable(new TextureRegion(Models.shop));
        menu = new ImageButton(shopImage);
        //Set shop button image(texture)
        Drawable exitImage = new TextureRegionDrawable(new TextureRegion(Models.exit));
        menu = new ImageButton(exitImage);
        //Making something like grid where we put our buttons;
        mainTable.add(menu,play,shop,exit);
    }

    @Override
    public void render(){
        stage.act();

        stage.draw();
    }


}
