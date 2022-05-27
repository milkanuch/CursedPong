package com.mygdx.game.UI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.helpers.Const;

public class Score extends Sprite {
    public Score(Texture body){
        super(body);
        setX(11);
        setY(Const.screenHeight - 33f);
    }
}
