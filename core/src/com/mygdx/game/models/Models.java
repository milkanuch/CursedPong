package com.mygdx.game.models;

import com.badlogic.gdx.graphics.Texture;

public class Models {
    //Players
    public static Texture firstPlayer,secondPlayer;
    //Ball
    public static Texture ball;
    //Menu and Hud
    public static Texture score,pause,hard,easy,shop,play,exit,menu;
    public static void loadTexture(){
        firstPlayer = new Texture("players_models/player.png"); //First player texture picture
        secondPlayer = new Texture("players_models/player1.png"); //First player texture picture

        ball = new Texture("balls/ball1.png");  //Load ball as png picture
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
    }
}
