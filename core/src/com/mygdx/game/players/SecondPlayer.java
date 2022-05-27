package com.mygdx.game.players;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.helpers.Const;

public class SecondPlayer extends Sprite {
    private int posX,posY;

    public SecondPlayer(Texture body){
        //Base position
        super(body);
        setX((Const.screenWidth) - 54);
        System.out.println(getX());
        setY(Const.screenHeight/2);
    }

    public void update(){
        setY((0 + Const.speedSecondPlayer) + getY()) ;
    }

}
