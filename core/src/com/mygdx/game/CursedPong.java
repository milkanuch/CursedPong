package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.UI.screens.DifficultyScreen;
import com.mygdx.game.UI.screens.LoadingScreen;
import com.mygdx.game.UI.screens.LogoScreen;
import com.mygdx.game.UI.screens.MenuScreen;
import com.mygdx.game.UI.screens.PlayScreen;
import com.mygdx.game.UI.screens.ShopScreen;
import com.mygdx.game.helpers.Const;
import com.mygdx.game.models.Assets;


public class CursedPong extends Game {
	private SpriteBatch batch;
	public OrthographicCamera orthographicCamera;
	public AssetManager assetsManager;
	public Control control;
	//Screens
	public PlayScreen playScreen;
	public LogoScreen logoScreen;
	public MenuScreen menuScreen;
	public LoadingScreen loadingScreen;
	public DifficultyScreen difficultyScreen;
	public ShopScreen shopScreen;

	@Override
	public void create() {
		Assets.loadTexture(); //Load our models for players + ball
		batch = new SpriteBatch();
		assetsManager = new AssetManager();
		//Camera
		orthographicCamera = new OrthographicCamera();
		orthographicCamera.setToOrtho(false, Const.screenWidth,Const.screenHeight);
		orthographicCamera.position.set(Const.screenWidth,Const.screenHeight,0);
		//Control
		control = new Control();
		//Screens for menu
		playScreen = new PlayScreen(this);
		logoScreen = new LogoScreen(this);
		menuScreen = new MenuScreen(this);
		loadingScreen = new LoadingScreen(this);
		difficultyScreen = new DifficultyScreen(this);
		shopScreen = new ShopScreen(this);

		this.setScreen(loadingScreen);
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
		Assets.background.dispose();
	}
}
