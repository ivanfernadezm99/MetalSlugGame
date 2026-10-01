package com.metal.slug.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import com.badlogic.gdx.math.Vector2;

import com.metal.slug.enemy.Enemy;

import java.util.ArrayList;
import java.util.List;

/**
 * Level class for managing game levels and their data.
 */
public class Level {
    private String name;
    private int width;
    private int height;
    private String backgroundPath;
    private String musicPath;
    private List<Obstacle> obstacles;
    private List<Enemy> enemies;
    private List<Collectible> collectibles;
    private Vector2 playerStart;
    
    public Level(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.obstacles = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.collectibles = new ArrayList<>();
    }
    
    /**
     * Load level data from JSON file
     */
    public void loadFromFile(String filename) {
        try {
            FileHandle file = Gdx.files.internal(filename);
            String jsonContent = file.readString();
            
            JsonReader jsonReader = new JsonReader();
            JsonValue json = jsonReader.parse(jsonContent);
            
            // Parse level properties
            this.name = json.getString("name", "Unknown Level");
            this.width = json.getInt("width", 800);
            this.height = json.getInt("height", 600);
            
            // Parse background
            this.backgroundPath = json.getString("background", "assets/backgrounds/default.png");

            // Parse music (estilo Ikari/KOF - rock pesado)
            this.musicPath = json.getString("music", "assets/music/battle_heavy_03.ogg");
            
            // Parse obstacles
            JsonValue obstaclesJson = json.get("obstacles");
            if (obstaclesJson != null) {
                for (JsonValue obstacleJson : obstaclesJson) {
                    float x = obstacleJson.getFloat("x", 0);
                    float y = obstacleJson.getFloat("y", 0);
                    float width = obstacleJson.getFloat("width", 32);
                    float height = obstacleJson.getFloat("height", 32);
                    Obstacle obstacle = new Obstacle(x, y, width, height);
                    obstacles.add(obstacle);
                }
            }
            
            // Parse enemies
            JsonValue enemiesJson = json.get("enemies");
            if (enemiesJson != null) {
                for (JsonValue enemyJson : enemiesJson) {
                    float x = enemyJson.getFloat("x", 0);
                    float y = enemyJson.getFloat("y", 0);
                    String type = enemyJson.getString("type", "basic");
                    int health = enemyJson.getInt("health", 50);
                    Enemy enemy = new Enemy(x, y, Enemy.EnemyType.valueOf(type.toUpperCase()));
                    enemies.add(enemy);
                }
            }
            
            // Parse collectibles
            JsonValue collectiblesJson = json.get("collectibles");
            if (collectiblesJson != null) {
                for (JsonValue collectibleJson : collectiblesJson) {
                    float x = collectibleJson.getFloat("x", 0);
                    float y = collectibleJson.getFloat("y", 0);
                    String type = collectibleJson.getString("type", "health");
                    Collectible collectible = new Collectible(x, y, Collectible.CollectibleType.valueOf(type.toUpperCase()));
                    collectibles.add(collectible);
                }
            }
            
            // Parse player start position
            JsonValue playerStartJson = json.get("playerStart");
            if (playerStartJson != null) {
                float x = playerStartJson.getFloat("x", 100);
                float y = playerStartJson.getFloat("y", 100);
                playerStart = new Vector2(x, y);
            }
            
        } catch (Exception e) {
            Gdx.app.error("Level", "Error loading level from " + filename + ": " + e.getMessage());
        }
    }
    
    /**
     * Save level data to JSON file
     */
    public void saveToFile(String filename) {
        // Implementation for saving level data
        // This would serialize the level properties to JSON
    }
    
    /**
     * Render the level
     */
    public void render() {
        // Render background
        // Render obstacles
        // Render collectibles
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public List<Obstacle> getObstacles() {
        return obstacles;
    }
    
    public List<Enemy> getEnemies() {
        return enemies;
    }
    
    public List<Collectible> getCollectibles() {
        return collectibles;
    }
    
    public Vector2 getPlayerStart() {
        return playerStart;
    }

    public String getBackgroundPath() {
        return backgroundPath;
    }

    public String getMusicPath() {
        return musicPath;
    }
}