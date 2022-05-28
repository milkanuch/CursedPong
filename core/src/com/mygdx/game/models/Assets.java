package com.mygdx.game.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
    //Players
    public static Texture firstPlayer,secondPlayer;
    //Ball
    public static Texture ball;
    //Menu and Hud
    public static Texture score,pause,hard,easy,shop,play,exit,menu,background;
    //Game sounds
    public static Sound wallBounceSound,playersBounceSound,winSound,looseSound;

    public static void loadTexture(){
        firstPlayer = new Texture("players_models/player.png"); //First player texture picture
        secondPlayer = new Texture("players_models/player1.png"); //First player texture picture

        ball = new Texture("balls/ball2.png");  //Load ball as png picture
        //In game hud
        score = new Texture("menu/Score.png");
        pause = new Texture("menu/Pause.png");
        //Levels of difficulty
        hard = new Texture("menu/Hard.png");
        easy = new Texture("menu/Easy.png");
        //Main Screen navigation
        shop = new Texture("menu/Shop.png");
        menu = new Texture("menu/Menu.png");
        play = new Texture("menu/Play.png");
        exit = new Texture("menu/Exit.png");
        background = new Texture("backgrounds/backg.png");//Background
        //Sounds
        wallBounceSound = Gdx.audio.newSound(Gdx.files.internal("sounds/wall-bounce.wav"));
        playersBounceSound = Gdx.audio.newSound(Gdx.files.internal("sounds/players-bounce.mp3"));
        winSound = Gdx.audio.newSound(Gdx.files.internal("sounds/win.wav"));
        looseSound = Gdx.audio.newSound(Gdx.files.internal("sounds/loose.wav"));
    }

    public static void playPlayersBounceSound(){
        long id = Assets.playersBounceSound.play(0.1f);
        Assets.playersBounceSound.setPitch(id,2);
        Assets.playersBounceSound.setLooping(id,false);
    }

    public static void playWallBounceSound(){
        long id = Assets.wallBounceSound.play(0.1f);
        Assets.wallBounceSound.setPitch(id,2);
        Assets.wallBounceSound.setLooping(id,false);
    }

    public static void playWinnerSound(){
        long id = Assets.winSound.play(0.1f);
        Assets.winSound.setPitch(id,2);
        Assets.winSound.setLooping(id,false);
    }

    public static void playLooserSound(){
        long id = Assets.looseSound.play(0.1f);
        Assets.looseSound.setPitch(id,2);
        Assets.looseSound.setLooping(id,false);
    }
}
