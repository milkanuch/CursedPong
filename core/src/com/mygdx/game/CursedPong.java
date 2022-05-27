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

import java.awt.Rectangle;

public class CursedPong extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera orthographicCamera;

	Ball ball;
	FirstPlayer firstPlayer;
	SecondPlayer secondPlayer;
	Rectangle upperLimit, lowerLimit, line;

	public Control control;

	@Override
	public void create () {
		Models.loadTexture(); //Load our models for players + ball
		batch = new SpriteBatch();

		ball = new Ball(Models.ball); //Ball
		//Players
		firstPlayer = new FirstPlayer(Models.firstPlayer);
		secondPlayer = new SecondPlayer(Models.secondPlayer);
		//Camera
		orthographicCamera = new OrthographicCamera();
		orthographicCamera.setToOrtho(false, Const.screenWidth,Const.screenHeight);
		orthographicCamera.position.set(Const.screenWidth,Const.screenHeight,0);
		//Lines
		upperLimit = new Rectangle(0,Const.screenHeight-10,Const.screenWidth,5);
		lowerLimit = new Rectangle(0,10,Const.screenWidth,5);
		line = new Rectangle(Const.screenWidth/2, 10, 2,Const.screenHeight-20);
		control = new Control();
		Gdx.input.setInputProcessor(control);

		img = new Texture("backgrounds/space.png"); //Background
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();

		batch.draw(img, 0, 0); //Background render

		ball.draw(batch); //Ball render
		firstPlayer.draw(batch); //First player render
		secondPlayer.draw(batch); //Second player render
		firstPlayer.update(control);
		secondPlayer.update();
		if(secondPlayer.getY() > Const.screenHeight - 400 || secondPlayer.getY() < -190 ){
			Const.speedSecondPlayer *=-1;
		}
		ball.update();
		if(firstPlayer.getBoundingRectangle().overlaps(ball.getBoundingRectangle()) || secondPlayer.getBoundingRectangle().overlaps(ball.getBoundingRectangle())) {
			Const.speedBall *= -1;
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
