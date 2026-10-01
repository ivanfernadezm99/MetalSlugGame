package com.metal.slug.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import com.metal.slug.graphics.ResourceManager;
import com.metal.slug.player.Player;
import com.metal.slug.enemy.Enemy;
import com.metal.slug.projectile.Projectile;
import com.metal.slug.level.Level;
import com.metal.slug.collision.CollisionManager;

/**
 * Main Game class for the Metal Slug Clone game.
 */
public class Game extends ApplicationAdapter {
    private static final String TAG = "MetalSlugGame";
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Player player;
    private Level currentLevel;
    private Array<Enemy> enemies;
    private Array<Projectile> projectiles;
    private ResourceManager resourceManager;
    
    @Override
    public void create() {
        try {
            Gdx.app.log(TAG, "Game.create() called - initializing game components");
            // Initialize resources
            resourceManager = ResourceManager.getInstance();
            batch = new SpriteBatch();
            camera = new OrthographicCamera();
            camera.setToOrtho(false, 800, 600); // Fixed size camera
            
            // Load assets
            loadAssets();
            
            // Initialize game objects
            initializeGame();
            
            Gdx.app.log(TAG, "Game.create() completed successfully");
        } catch (Exception e) {
            Gdx.app.error(TAG, "Error in create(): " + e.getMessage(), e);
            throw new RuntimeException("Failed to initialize game", e);
        }
    }
    
    private void loadAssets() {
        try {
            Gdx.app.log(TAG, "Loading assets...");
            // Load player sprites
            resourceManager.loadTexture("player_idle_0", "assets/player/idle.png");
            resourceManager.loadTexture("player_walking_0", "assets/player/walking_0.png");
            resourceManager.loadTexture("player_walking_1", "assets/player/walking_1.png");
            resourceManager.loadTexture("player_walking_2", "assets/player/walking_2.png");
            resourceManager.loadTexture("player_walking_3", "assets/player/walking_3.png");
            resourceManager.loadTexture("player_jumping_0", "assets/player/jumping_0.png");
            resourceManager.loadTexture("player_jumping_1", "assets/player/jumping_1.png");
            resourceManager.loadTexture("player_shooting_0", "assets/player/shooting_0.png");
            resourceManager.loadTexture("player_shooting_1", "assets/player/shooting_1.png");
            resourceManager.loadTexture("player_damage_0", "assets/player/damage_0.png");
            resourceManager.loadTexture("player_damage_1", "assets/player/damage_1.png");
            
            // Load enemy sprites
            resourceManager.loadTexture("enemy_walking_0", "assets/enemies/walking_0.png");
            resourceManager.loadTexture("enemy_walking_1", "assets/enemies/walking_1.png");
            resourceManager.loadTexture("enemy_walking_2", "assets/enemies/walking_2.png");
            resourceManager.loadTexture("enemy_walking_3", "assets/enemies/walking_3.png");
            resourceManager.loadTexture("enemy_shooting_0", "assets/enemies/shooting_0.png");
            resourceManager.loadTexture("enemy_shooting_1", "assets/enemies/shooting_1.png");
            resourceManager.loadTexture("enemy_damaged_0", "assets/enemies/damaged_0.png");
            resourceManager.loadTexture("enemy_damaged_1", "assets/enemies/damaged_1.png");
            resourceManager.loadTexture("enemy_death_0", "assets/enemies/death_0.png");
            resourceManager.loadTexture("enemy_death_1", "assets/enemies/death_1.png");
            resourceManager.loadTexture("enemy_death_2", "assets/enemies/death_2.png");
            
            // Load projectile sprites
            resourceManager.loadTexture("projectile", "assets/projectiles/bullet.png");
            
            // Load background
            resourceManager.loadTexture("background", "assets/backgrounds/level1.png");
            
            Gdx.app.log(TAG, "Assets loaded successfully");
        } catch (Exception e) {
            Gdx.app.error(TAG, "Error loading assets: " + e.getMessage(), e);
            throw new RuntimeException("Failed to load assets", e);
        }
    }
    
    private void initializeGame() {
        try {
            Gdx.app.log(TAG, "Initializing game objects...");
            // Initialize game objects
            player = new Player(100, 100);
            enemies = new Array<>();
            projectiles = new Array<>();
            
            // Create a simple level
            currentLevel = new Level("Level 1", 800, 600);
            currentLevel.loadFromFile("assets/levels/level1.json");
            
            // Add some enemies
            enemies.add(new Enemy(400, 100, Enemy.EnemyType.BASIC, player));
            enemies.add(new Enemy(500, 100, Enemy.EnemyType.ADVANCED, player));
            
            Gdx.app.log(TAG, "Game objects initialized successfully");
        } catch (Exception e) {
            Gdx.app.error(TAG, "Error initializing game: " + e.getMessage(), e);
            throw new RuntimeException("Failed to initialize game objects", e);
        }
    }
    
    @Override
    public void render() {
        try {
            // Clear screen
            Gdx.gl.glClearColor(0.5f, 0.5f, 1f, 1f);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            
            // Update game logic
            update(Gdx.graphics.getDeltaTime());
            
            // Render everything
            renderGame();
        } catch (Exception e) {
            Gdx.app.error(TAG, "Error in render(): " + e.getMessage(), e);
            // Don't crash the app, just log the error and continue
            // This prevents the app from crashing silently
        }
    }
    
    private void update(float deltaTime) {
        try {
            // Update player
            player.update(deltaTime);
            
            // Update enemies
            for (Enemy enemy : enemies) {
                enemy.update(deltaTime);
            }
            
            // Update projectiles
            for (int i = projectiles.size - 1; i >= 0; i--) {
                Projectile projectile = projectiles.get(i);
                projectile.update(deltaTime);
                
                // Remove inactive projectiles
                if (!projectile.isActive()) {
                    projectiles.removeIndex(i);
                }
            }
            
            // Check collisions
            checkCollisions();
        } catch (Exception e) {
            Gdx.app.error(TAG, "Error in update(): " + e.getMessage(), e);
        }
    }
    
    private void checkCollisions() {
        try {
            // Check player-enemy collisions
            for (Enemy enemy : enemies) {
                if (CollisionManager.checkPlayerEnemyCollision(player, enemy)) {
                    CollisionManager.handlePlayerEnemyCollision(player, enemy);
                }
            }
            
            // Check projectile-enemy collisions
            for (Projectile projectile : projectiles) {
                for (Enemy enemy : enemies) {
                    if (CollisionManager.checkProjectileEnemyCollision(projectile, enemy)) {
                        CollisionManager.handleProjectileEnemyCollision(projectile, enemy);
                    }
                }
            }
        } catch (Exception e) {
            Gdx.app.error(TAG, "Error in checkCollisions(): " + e.getMessage(), e);
        }
    }
    
    private void renderGame() {
        try {
            batch.setProjectionMatrix(camera.combined);
            batch.begin();
            
            // Render background
            // (Implementation would use loaded background texture)
            
            // Render player
            player.render(batch);
            
            // Render enemies
            for (Enemy enemy : enemies) {
                enemy.render(batch);
            }
            
            // Render projectiles
            for (Projectile projectile : projectiles) {
                projectile.render(batch);
            }
            
            batch.end();
        } catch (Exception e) {
            Gdx.app.error(TAG, "Error in renderGame(): " + e.getMessage(), e);
        }
    }
    
    @Override
    public void dispose() {
        try {
            Gdx.app.log(TAG, "Disposing game resources...");
            if (batch != null) {
                batch.dispose();
            }
            if (resourceManager != null) {
                resourceManager.dispose();
            }
            Gdx.app.log(TAG, "Game resources disposed successfully");
        } catch (Exception e) {
            Gdx.app.error(TAG, "Error in dispose(): " + e.getMessage(), e);
        }
    }
}