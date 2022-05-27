package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import com.mygdx.game.UI.Score;
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
	Score score;
	Sprite upperLimit, lowerLimit, line;

	public Control control;

	@Override
	public void create () {
		Models.loadTexture(); //Load our models for players + ball
		batch = new SpriteBatch();

		ball = new Ball(Models.ball); //Ball
		//Players
		firstPlayer = new FirstPlayer(Models.firstPlayer);
		secondPlayer = new SecondPlayer(Models.secondPlayer);
		//In game Hud
		score = new Score(Models.score);
		//Camera
		orthographicCamera = new OrthographicCamera();
		orthographicCamera.setToOrtho(false, Const.screenWidth,Const.screenHeight);
		orthographicCamera.position.set(Const.screenWidth,Const.screenHeight,0);
		//Lines
		upperLimit = new Sprite();
		upperLimit.setPosition(0,0);
		upperLimit.setSize(Const.screenWidth,5);
		lowerLimit = new Sprite();
		lowerLimit.setPosition(0,Const.screenHeight);
		lowerLimit.setSize(Const.screenWidth,5);

		line = new Sprite();
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
		score.draw(batch); //Score
		firstPlayer.update(control);
		secondPlayer.update();
		if(secondPlayer.getBoundingRectangle().overlaps(upperLimit.getBoundingRectangle())
				|| secondPlayer.getBoundingRectangle().overlaps(lowerLimit.getBoundingRectangle())){
			Const.speedSecondPlayer *=-1;
		}
		if(firstPlayer.getBoundingRectangle().overlaps(upperLimit.getBoundingRectangle())
				|| firstPlayer.getBoundingRectangle().overlaps(lowerLimit.getBoundingRectangle())){
			Const.speedFirstPlayer *=-1;
		}
		ball.update();
			  if(firstPlayer.getBoundingRectangle().overlaps(ball.getBoundingRectangle())
				|| secondPlayer.getBoundingRectangle().overlaps(ball.getBoundingRectangle())
				|| ball.getX() < 0 || ball.getX() > Const.screenWidth
				|| ball.getBoundingRectangle().overlaps(upperLimit.getBoundingRectangle())
				|| ball.getBoundingRectangle().overlaps(lowerLimit.getBoundingRectangle())) {
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
