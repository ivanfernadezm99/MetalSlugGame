package com.metal.slug.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

/**
 * Main application class to start the game.
 */
public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Metal Slug Clone");
        config.setWindowedMode(800, 600);
        config.setResizable(false);
        
        // Create and start the game
        new Lwjgl3Application(new Game(), config);
    }
}