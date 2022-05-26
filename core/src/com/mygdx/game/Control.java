package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

public class Control  extends InputAdapter implements InputProcessor {
    public boolean up;
    public boolean down;

    @Override //When the button is pressed
    public boolean keyUp(int keyCode) {
        switch (keyCode){
            case Input.Keys.W:
                up = false;
                break;
            case Input.Keys.S:
                down = false;
                break;
        }
        return false;
    }

    @Override //When the button is not pressed
    public boolean keyDown(int keyCode) {
        switch (keyCode){
            case Input.Keys.W:
                up = true;
                break;
            case Input.Keys.S:
                down = true;
                break;
        }
        return false;
    }
}
