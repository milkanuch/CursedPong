package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.utils.ScreenUtils;

import ball.Ball;
import models.Models;
import players.FirstPlayer;
import players.SecondPlayer;

public class CursedPong extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera orthographicCamera;

	Ball ball; FirstPlayer firstPlayer; SecondPlayer secondPlayer;
	public int screenWidth,screenHeight;

	@Override
	public void create () {
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();

		Models.loadTexture(); //Load our models for players + ball
		batch = new SpriteBatch();

		ball = new Ball();
		firstPlayer = new FirstPlayer();
		secondPlayer = new SecondPlayer();
		//Camera
		orthographicCamera = new OrthographicCamera();
		orthographicCamera.setToOrtho(false,screenWidth,screenHeight);
		orthographicCamera.position.set(screenWidth,screenHeight,0);

		img = new Texture("backgrounds/space.png");//Background
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();

		batch.draw(img, 0, 0); //Background render
		batch.draw(Models.ball, ball.getX(),ball.getY(),200,200); //Ball render
		batch.draw(Models.firstPlayer,0, firstPlayer.getY()/2); //First player render
		batch.draw(Models.secondPlayer, secondPlayer.getX() - 100,secondPlayer.getY()/2); //Second player render

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
