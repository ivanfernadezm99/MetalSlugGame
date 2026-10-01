package com.metal.slug.level;

import com.badlogic.gdx.math.Vector2;

/**
 * Collectible class for items that can be picked up.
 */
public class Collectible {
    public enum CollectibleType {
        HEALTH,
        AMMO,
        COIN,
        POWER_UP
    }
    
    private Vector2 position;
    private CollectibleType type;
    private boolean collected;
    
    public Collectible(float x, float y, CollectibleType type) {
        this.position = new Vector2(x, y);
        this.type = type;
        this.collected = false;
    }
    
    // Getters
    public Vector2 getPosition() {
        return position;
    }
    
    public CollectibleType getType() {
        return type;
    }
    
    public boolean isCollected() {
        return collected;
    }
    
    public void collect() {
        collected = true;
    }

    public float getWidth() {
        return 16f;
    }

    public float getHeight() {
        return 16f;
    }
}