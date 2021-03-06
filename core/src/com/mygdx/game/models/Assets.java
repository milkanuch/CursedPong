package com.mygdx.game.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
    //Players
    public static Texture firstPlayer,secondPlayer;
    public static Texture creeper,dinosaur,naruto,pink,purple,robot,steve,todoroki;
    //Ball
    public static Texture ball;
    public static Texture ball1,ball2,ball3,ball4;
    //Menu and Hud
    public static Texture score,hard,easy,shop,play,exit,menu,back,use,menuBackground,arcade,background,firstPlayerWin,secondPlayerWin,timer;
    //Game sounds
    public static Sound wallBounceSound,playersBounceSound,winSound,looseSound;

    public static void loadTexture(){
        firstPlayer = new Texture("players_models/naruto.png"); //First player texture picture
        secondPlayer = new Texture("players_models/creeper.png"); //First player texture picture

        ball = new Texture("balls/ball2.png");  //Load ball as png picture
        //In game hud
        score = new Texture("menu/Score.png");
        //Levels of difficulty
        hard = new Texture("menu/Hard.png");
        easy = new Texture("menu/Easy.png");
        //Main Screen navigation
        shop = new Texture("menu/Shop.png");
        menu = new Texture("menu/Menu.png");
        play = new Texture("menu/Play.png");
        exit = new Texture("menu/Exit.png");
        back = new Texture("menu/Back.png");
        use = new Texture("menu/Use.png");
        timer = new Texture("menu/timer.png");
        arcade = new Texture("menu/Arcade.png");

        //Textures for sale
        //Player models
        creeper = new Texture("players_models/creeper.png");
        dinosaur = new Texture("players_models/dinosaur.png");
        naruto = new Texture("players_models/naruto.png");
        pink = new Texture("players_models/pink.png");
        purple = new Texture("players_models/purple.png");
        robot = new Texture("players_models/robot.png");
        steve = new Texture("players_models/steve.png");
        todoroki = new Texture("players_models/todoroki.png");
        //Ball models
        ball1 = new Texture("balls/ball1.png");
        ball2 = new Texture("balls/ball2.png");
        ball3 = new Texture("balls/ball3.png");
        ball4 = new Texture("balls/ball4.png");

        background = new Texture("backgrounds/backg.png");//Background
        menuBackground = new Texture("backgrounds/menu_background.png");
        firstPlayerWin = new Texture("backgrounds/player1win.png");
        secondPlayerWin = new Texture("backgrounds/player2win.png");

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
