package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.helpers.Const;

public class Control  extends InputAdapter implements InputProcessor {
    public boolean up,down;
    @Override //When the button is pressed
    public boolean keyUp(int keyCode) {
        switch (keyCode) {
            case Input.Keys.UP:
            case Input.Keys.W:
                up = false;
                break;
            case Input.Keys.DOWN:
            case Input.Keys.S:
                down = false;
                break;
            case Input.Keys.ESCAPE:
                Const.mainMenu = true;
                break;
        }
        return false;
    }

    @Override //When the button is not pressed
    public boolean keyDown(int keyCode) {
        switch (keyCode) {
            case Input.Keys.UP:
            case Input.Keys.W:
                up = true;
                break;
            case Input.Keys.DOWN:
            case Input.Keys.S:
                down = true;
                break;
        }
        return false;
    }
}
