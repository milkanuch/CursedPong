package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Control  extends InputAdapter implements InputProcessor {
    public boolean up;
    public boolean down;

    public Control( ){
    }
    @Override
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

    @Override
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
