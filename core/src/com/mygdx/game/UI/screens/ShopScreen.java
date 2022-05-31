package com.mygdx.game.UI.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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

public class ShopScreen implements Screen {
    private final CursedPong cursedPong;


    private final Stage stage;
    private final ImageButton back,naruto,creeper,dinosaur,pink,purple,robot,steve,todoroki,ball1,ball2,ball3,ball4;
    private final BitmapFont bitmapFont;
    private final SpriteBatch batch;

    public ShopScreen(final CursedPong game){
        //Back
        Drawable backImage = new TextureRegionDrawable(new TextureRegion(Assets.back));
        back = new ImageButton(backImage);
        //Use
        bitmapFont = new BitmapFont();
        //Players buttons for sale
        Drawable narutoImage = new TextureRegionDrawable(new TextureRegion(Assets.naruto));
        naruto = new ImageButton(narutoImage);
        Drawable creeperImage = new TextureRegionDrawable(new TextureRegion(Assets.creeper));
        creeper = new ImageButton(creeperImage);
        Drawable dinosaurImage = new TextureRegionDrawable(new TextureRegion(Assets.dinosaur));
        dinosaur = new ImageButton(dinosaurImage);
        Drawable pinkImage = new TextureRegionDrawable(new TextureRegion(Assets.pink));
        pink = new ImageButton(pinkImage);
        Drawable purpleImage = new TextureRegionDrawable(new TextureRegion(Assets.purple));
        purple = new ImageButton(purpleImage);
        Drawable robotImage = new TextureRegionDrawable(new TextureRegion(Assets.robot));
        robot = new ImageButton(robotImage);
        Drawable steveImage = new TextureRegionDrawable(new TextureRegion(Assets.steve));
        steve = new ImageButton(steveImage);
        Drawable todorokiImage = new TextureRegionDrawable(new TextureRegion(Assets.todoroki));
        todoroki = new ImageButton(todorokiImage);
        //Ball buttons for sale
        Drawable ball1Image = new TextureRegionDrawable(new TextureRegion(Assets.ball1));
        ball1 = new ImageButton(ball1Image);
        Drawable ball2Image = new TextureRegionDrawable(new TextureRegion(Assets.ball2));
        ball2 = new ImageButton(ball2Image);
        Drawable ball3Image = new TextureRegionDrawable(new TextureRegion(Assets.ball3));
        ball3 = new ImageButton(ball3Image);
        Drawable ball4Image = new TextureRegionDrawable(new TextureRegion(Assets.ball4));
        ball4 = new ImageButton(ball4Image);

        bitmapFont.getData().setScale(2,2);
        batch = new SpriteBatch();
        this.cursedPong = game;
        this.stage = new Stage(new FitViewport(Const.screenWidth, Const.screenHeight, game.orthographicCamera));
    }

    @Override
    public void show() {
       Gdx.input.setInputProcessor(stage);
       stage.clear();

       back.setPosition(Const.screenWidth/2 - 100f,100f);
       back.setSize(200,100);
       back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                cursedPong.setScreen(cursedPong.menuScreen);
            }
        });
       renderShopModels();
       stage.addActor(back);
    }

    private void update(float delta) {
        stage.act(delta);
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(Assets.menuBackground,0,0);
        update(delta);
        bitmapFont.draw(batch,"Players Models",Const.screenWidth/2,Const.screenHeight - 120f);
        bitmapFont.draw(batch,"Balls Models",Const.screenWidth/2,Const.screenHeight/2 + 170f);
        bitmapFont.draw(batch,"Current Models",Const.screenWidth/2 - 70f,450);

        batch.draw(Assets.firstPlayer,Const.screenWidth/2 - 100f,300f);
        batch.draw(Assets.ball,Const.screenWidth/2 - 20f,300f);
        batch.draw(Assets.secondPlayer,Const.screenWidth/2 + 100f,300f);

        batch.end();
        stage.draw();
    }

    public void renderShopModels(){
        steve.setPosition(500,Const.screenHeight - 300f);
        steve.setSize(26,101);
        steve.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Assets.firstPlayer.load(Assets.steve.getTextureData());
                Assets.secondPlayer.load(Assets.creeper.getTextureData());
            }
        });

        creeper.setPosition(600f,Const.screenHeight - 300f);
        creeper.setSize(26,101);
        creeper.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Assets.firstPlayer.load(Assets.creeper.getTextureData());
                Assets.secondPlayer.load(Assets.steve.getTextureData());
            }
        });

        dinosaur.setPosition(700f,Const.screenHeight - 300f);
        dinosaur.setSize(26,101);
        dinosaur.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Assets.firstPlayer.load(Assets.dinosaur.getTextureData());
                Assets.secondPlayer.load(Assets.naruto.getTextureData());
            }
        });

        todoroki.setPosition(800f,Const.screenHeight - 300f);
        todoroki.setSize(26,101);
        todoroki.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Assets.firstPlayer.load(Assets.todoroki.getTextureData());
                Assets.secondPlayer.load(Assets.robot.getTextureData());
            }
        });

        robot.setPosition(900f,Const.screenHeight - 300f);
        robot.setSize(26,101);
        robot.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Assets.firstPlayer.load(Assets.robot.getTextureData());
                Assets.secondPlayer.load(Assets.naruto.getTextureData());
            }
        });

        naruto.setPosition(1000f,Const.screenHeight - 300f);
        naruto.setSize(26,101);
        naruto.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Assets.firstPlayer.load(Assets.naruto.getTextureData());
                Assets.secondPlayer.load(Assets.todoroki.getTextureData());
            }
        });

        purple.setPosition(1100f,Const.screenHeight - 300f);
        purple.setSize(26,101);
        purple.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Assets.firstPlayer.load(Assets.purple.getTextureData());
                Assets.secondPlayer.load(Assets.pink.getTextureData());
            }
        });

        pink.setPosition(1200f,Const.screenHeight - 300f);
        pink.setSize(26,101);
        pink.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Assets.firstPlayer.load(Assets.pink.getTextureData());
                Assets.secondPlayer.load(Assets.purple.getTextureData());
            }
        });

        ball1.setPosition(Const.screenWidth /2 - 220f,Const.screenHeight/2);
        ball1.setSize(120,120);
        ball1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Assets.ball.load(Assets.ball1.getTextureData());
            }
        });
        ball2.setPosition(Const.screenWidth /2 - 80f,Const.screenHeight/2);
        ball2.setSize(120,120);
        ball2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Assets.ball.load(Assets.ball2.getTextureData());
            }
        });
        ball3.setPosition(Const.screenWidth /2 + 80f,Const.screenHeight/2);
        ball3.setSize(120,120);
        ball3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Assets.ball.load(Assets.ball3.getTextureData());
            }
        });
        ball4.setPosition(Const.screenWidth /2 + 220f,Const.screenHeight/2);
        ball4.setSize(120,120);
        ball4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Assets.ball.load(Assets.ball4.getTextureData());
            }
        });

        //players
        stage.addActor(steve);
        stage.addActor(creeper);
        stage.addActor(dinosaur);
        stage.addActor(todoroki);
        stage.addActor(naruto);
        stage.addActor(robot);
        stage.addActor(purple);
        stage.addActor(pink);
        //balls
        stage.addActor(ball1);
        stage.addActor(ball2);
        stage.addActor(ball3);
        stage.addActor(ball4);
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
    public void dispose() { stage.dispose(); }
}
