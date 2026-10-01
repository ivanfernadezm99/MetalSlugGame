package com.metal.slug.weapon;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

/**
 * Base Weapon class representing different weapon types in the game.
 */
public class Weapon {
    protected WeaponType type;
    protected float damage;
    protected float fireRate;
    protected int maxAmmo;
    protected int currentAmmo;
    protected boolean isAutomatic;
    protected float lastFiredTime;
    
    public enum WeaponType {
        PISTOL,
        MACHINE_GUN,
        ROCKET_LAUNCHER
    }
    
    public Weapon(WeaponType type, float damage, float fireRate, int maxAmmo, boolean isAutomatic) {
        this.type = type;
        this.damage = damage;
        this.fireRate = fireRate;
        this.maxAmmo = maxAmmo;
        this.currentAmmo = maxAmmo;
        this.isAutomatic = isAutomatic;
        this.lastFiredTime = 0f;
    }
    
    /**
     * Shoot method to create a projectile
     * @param position The position to shoot from
     * @param isFacingRight Whether the shooter is facing right
     * @return The created projectile or null if not enough ammo
     */
    public com.metal.slug.projectile.Projectile shoot(Vector2 position, boolean isFacingRight) {
        if (currentAmmo > 0 || maxAmmo == -1) { // -1 means infinite ammo
            // Calculate direction
            float direction = isFacingRight ? 1 : -1;

            // Map WeaponType to ProjectileType
            com.metal.slug.projectile.Projectile.ProjectileType projType;
            if (type == WeaponType.ROCKET_LAUNCHER) {
                projType = com.metal.slug.projectile.Projectile.ProjectileType.ROCKET;
            } else {
                projType = com.metal.slug.projectile.Projectile.ProjectileType.BULLET;
            }

            // Create a new projectile (uses projectile package)
            com.metal.slug.projectile.Projectile projectile = new com.metal.slug.projectile.Projectile(
                position.x,
                position.y,
                direction,
                damage,
                projType
            );
            
            // Decrease ammo
            if (maxAmmo != -1) {
                currentAmmo--;
            }
            
            lastFiredTime = 0f; // Reset fire timer
            return projectile;
        }
        return null; // No ammo left
    }
    
    /**
     * Reload the weapon (if applicable)
     */
    public void reload() {
        if (maxAmmo != -1) {
            currentAmmo = maxAmmo;
        }
    }
    
    /**
     * Check if weapon can fire
     * @return true if weapon can fire
     */
    public boolean canFire(float deltaTime) {
        lastFiredTime += deltaTime;
        return lastFiredTime >= 1f / fireRate;
    }
    
    // Getters
    public WeaponType getType() {
        return type;
    }
    
    public float getDamage() {
        return damage;
    }
    
    public int getCurrentAmmo() {
        return currentAmmo;
    }
    
    public int getMaxAmmo() {
        return maxAmmo;
    }
    
    public boolean isAutomatic() {
        return isAutomatic;
    }
}