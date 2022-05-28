package com.mygdx.game.players;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Control;
import com.mygdx.game.helpers.Const;

public class FirstPlayer extends Sprite {
    public int dirY;

    public FirstPlayer(Texture body){
        super(body);
        //Basic position
        setPlayerPosition();
    }

    public void update(Control control){
        dirY = 0;
        if(control.up)  dirY = 1;
        if(control.down) dirY -=1;
        setY((dirY * Const.speedFirstPlayer) + getY()) ;
    }

    public void setPlayerPosition(){
        setX(24);
        setY(Const.screenHeight/2);
    }
}
