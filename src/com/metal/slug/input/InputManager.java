package com.metal.slug.input;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

import com.metal.slug.player.Player;

/**
 * Input manager for handling player input.
 */
public class InputManager implements InputProcessor {
    private Player player;
    private boolean[] keys;
    
    public InputManager(Player player) {
        this.player = player;
        this.keys = new boolean[256]; // ASCII keys
    }
    
    @Override
    public boolean keyDown(int keycode) {
        keys[keycode] = true;
        
        // Handle key presses
        switch (keycode) {
            case com.badlogic.gdx.Input.Keys.LEFT:
            case com.badlogic.gdx.Input.Keys.A:
                player.moveLeft();
                break;
            case com.badlogic.gdx.Input.Keys.RIGHT:
            case com.badlogic.gdx.Input.Keys.D:
                player.moveRight();
                break;
            case com.badlogic.gdx.Input.Keys.UP:
            case com.badlogic.gdx.Input.Keys.W:
                player.jump();
                break;
            case com.badlogic.gdx.Input.Keys.SPACE:
                player.shoot();
                break;
        }
        
        return false;
    }
    
    @Override
    public boolean keyUp(int keycode) {
        keys[keycode] = false;
        
        // Handle key releases
        switch (keycode) {
            case com.badlogic.gdx.Input.Keys.LEFT:
            case com.badlogic.gdx.Input.Keys.A:
            case com.badlogic.gdx.Input.Keys.RIGHT:
            case com.badlogic.gdx.Input.Keys.D:
                player.stopMoving();
                break;
            case com.badlogic.gdx.Input.Keys.SPACE:
                player.stopShooting();
                break;
        }
        
        return false;
    }
    
    @Override
    public boolean keyTyped(char character) {
        return false;
    }
    
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // Handle touch input
        return false;
    }
    
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        // Handle touch release
        return false;
    }
    
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // Handle touch drag
        return false;
    }
    
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }
    
    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }
}