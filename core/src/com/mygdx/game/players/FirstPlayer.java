package com.mygdx.game.players;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Control;
import com.mygdx.game.CursedPong;
import com.mygdx.game.helpers.Const;
import com.mygdx.game.models.Models;

public class FirstPlayer extends Sprite {
    private int posX,posY;
    public int dirY;

    public FirstPlayer(Texture body){
        super(body);
        //Basic position
        setX(24);
        setY(Const.screenHeight/2);

    }

    public void update(Control control){
        dirY = 0;
        if(control.up)  dirY = 1;
        if(control.down) dirY -=1;
        setY((dirY * Const.speedFirstPlayer) + getY()) ;
    }
}
