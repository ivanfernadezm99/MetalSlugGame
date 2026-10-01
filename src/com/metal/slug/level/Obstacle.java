package com.metal.slug.level;

import com.badlogic.gdx.math.Vector2;

import java.util.List;

/**
 * Obstacle class for level geometry.
 */
public class Obstacle {
    private Vector2 position;
    private float width;
    private float height;
    
    public Obstacle(float x, float y, float width, float height) {
        this.position = new Vector2(x, y);
        this.width = width;
        this.height = height;
    }
    
    // Getters
    public Vector2 getPosition() {
        return position;
    }
    
    public float getWidth() {
        return width;
    }
    
    public float getHeight() {
        return height;
    }
    
    public boolean isCollidingWith(Vector2 otherPosition, float otherWidth, float otherHeight) {
        return position.x < otherPosition.x + otherWidth &&
               position.x + width > otherPosition.x &&
               position.y < otherPosition.y + otherHeight &&
               position.y + height > otherPosition.y;
    }
}