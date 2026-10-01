package com.metal.slug.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import com.metal.slug.graphics.ResourceManager;

/**
 * Main game screen class.
 */
public class GameScreen implements Screen {
    private Game game;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Viewport viewport;
    private ResourceManager resourceManager;
    
    public GameScreen(Game game) {
        this.game = game;
        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(800, 600, camera);
        this.resourceManager = ResourceManager.getInstance();
    }
    
    @Override
    public void show() {
        // Initialize game screen
        camera.setToOrtho(false, 800, 600);
    }
    
    @Override
    public void render(float delta) {
        // Clear screen
        Gdx.gl.glClearColor(0.5f, 0.5f, 1f, 1f);
        Gdx.gl.glClear(com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT);
        
        // Update and render game objects
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        // Game rendering code would go here
        batch.end();
    }
    
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }
    
    @Override
    public void pause() {
        // Pause game
    }
    
    @Override
    public void resume() {
        // Resume game
    }
    
    @Override
    public void hide() {
        // Hide game screen
    }
    
    @Override
    public void dispose() {
        batch.dispose();
    }
}