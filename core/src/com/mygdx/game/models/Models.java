package com.mygdx.game.models;

import com.badlogic.gdx.graphics.Texture;

public class Models {
    //Players com.mygdx.game.models
    public static Texture firstPlayer,secondPlayer;

    //Ball
    public static Texture ball;

    public static void loadTexture(){
        firstPlayer = new Texture("players_models/player1.png");
        secondPlayer = new Texture("players_models/player2.png");

        ball = new Texture("balls/ball-2.png");
    }
}
