package com.metal.slug.projectile;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Projectile class representing bullets and other projectiles in the game.
 */
public class Projectile {
    private Vector2 position;
    private Vector2 velocity;
    private float damage;
    private ProjectileType type;
    private boolean active;
    private float lifetime;
    private static final float MAX_LIFETIME = 5.0f;
    private static final float PROJECTILE_SPEED = 300f;
    
    public enum ProjectileType {
        BULLET,
        ROCKET
    }
    
    public Projectile(float x, float y, float direction, float damage, ProjectileType type) {
        this.position = new Vector2(x, y);
        this.damage = damage;
        this.type = type;
        
        // Set velocity based on direction
        this.velocity = new Vector2(direction * PROJECTILE_SPEED, 0);
        
        this.active = true;
        this.lifetime = 0f;
    }
    
    public void update(float deltaTime) {
        // Update position with velocity
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);
        
        // Update lifetime
        lifetime += deltaTime;
        
        // Deactivate if lifetime expired or out of bounds
        if (lifetime > MAX_LIFETIME || position.x < 0 || position.x > 800) {
            active = false;
        }
    }
    
    public void render(SpriteBatch batch) {
        // Simple rendering - in a real game this would draw a sprite
        if (active) {
            // Draw a simple rectangle or sprite here
        }
    }
    
    // Getters
    public Vector2 getPosition() {
        return position;
    }
    
    public float getDamage() {
        return damage;
    }
    
    public ProjectileType getType() {
        return type;
    }
    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public float getWidth() {
        return 8; // Simple width
    }
    
    public float getHeight() {
        return 4; // Simple height
    }
}