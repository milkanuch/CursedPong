package com.mygdx.game.players;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.helpers.Const;

public class SecondPlayer extends Sprite {
    private int posX,posY;

    public SecondPlayer(Texture body){
        //Base position
        super(body);
        setX((Const.screenWidth/2) + 280);
        setY(Const.screenHeight/4);
    }

}
