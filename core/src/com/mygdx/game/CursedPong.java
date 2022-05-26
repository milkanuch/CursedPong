package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import com.mygdx.game.ball.Ball;
import com.mygdx.game.helpers.Const;
import com.mygdx.game.models.Models;
import com.mygdx.game.players.FirstPlayer;
import com.mygdx.game.players.SecondPlayer;

public class CursedPong extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera orthographicCamera;

	Ball ball;
	FirstPlayer firstPlayer;
	SecondPlayer secondPlayer;
	public Control control;

	@Override
	public void create () {
		Models.loadTexture(); //Load our models for players + ball
		batch = new SpriteBatch();

		ball = new Ball(); //Ball
		//Players
		firstPlayer = new FirstPlayer();
		secondPlayer = new SecondPlayer();
		//Camera
		orthographicCamera = new OrthographicCamera();
		orthographicCamera.setToOrtho(false, Const.screenWidth,Const.screenHeight);
		orthographicCamera.position.set(Const.screenWidth,Const.screenHeight,0);

		control = new Control();
		Gdx.input.setInputProcessor(control);

		img = new Texture("backgrounds/space.png"); //Background
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();

		batch.draw(img, 0, 0); //Background render
		batch.draw(Models.ball, ball.getX(),ball.getY(),200,200); //Ball render
		batch.draw(Models.firstPlayer,firstPlayer.getX() - 200, firstPlayer.getY()/2); //First player render
		batch.draw(Models.secondPlayer, (Const.screenWidth/2) + 250,secondPlayer.getY()/2); //Second player render

		firstPlayer.update(control);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
