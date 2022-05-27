package com.mygdx.game.players;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.helpers.Const;

public class SecondPlayer extends Sprite {
    private int posX,posY;

    public SecondPlayer(Texture body){
        //Base position
        super(body);
        setPlayerPosition();
    }

    public void update(){
        setY((0 + Const.speedSecondPlayer) + getY());
    }
    public void setPlayerPosition(){
        setX(Const.screenWidth - 54f);
        setY(Const.screenHeight/2);
    }

}
