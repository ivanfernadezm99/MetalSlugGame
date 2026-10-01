package com.metal.slug.collision;

import com.badlogic.gdx.math.Vector2;

import com.metal.slug.player.Player;
import com.metal.slug.enemy.Enemy;
import com.metal.slug.projectile.Projectile;
import com.metal.slug.level.Collectible;

/**
 * CollisionManager class for handling all collision detection and response.
 */
public class CollisionManager {
    
    /**
     * Check collision between two game objects
     * @param a First game object
     * @param b Second game object
     * @return true if objects are colliding
     */
    public static boolean checkCollision(GameObject a, GameObject b) {
        if (a == null || b == null) return false;
        
        // Simple rectangle-based collision detection
        return a.getPosition().x < b.getPosition().x + b.getWidth() &&
               a.getPosition().x + a.getWidth() > b.getPosition().x &&
               a.getPosition().y < b.getPosition().y + b.getHeight() &&
               a.getPosition().y + a.getHeight() > b.getPosition().y;
    }
    
    /**
     * Check if player collides with enemy
     * @param player The player object
     * @param enemy The enemy object
     * @return true if colliding
     */
    public static boolean checkPlayerEnemyCollision(Player player, Enemy enemy) {
        if (player == null || enemy == null) return false;
        
        return player.getPosition().x < enemy.getPosition().x + enemy.getWidth() &&
               player.getPosition().x + player.getWidth() > enemy.getPosition().x &&
               player.getPosition().y < enemy.getPosition().y + enemy.getHeight() &&
               player.getPosition().y + player.getHeight() > enemy.getPosition().y;
    }
    
    /**
     * Check if projectile collides with enemy
     * @param projectile The projectile object
     * @param enemy The enemy object
     * @return true if colliding
     */
    public static boolean checkProjectileEnemyCollision(Projectile projectile, Enemy enemy) {
        if (projectile == null || enemy == null) return false;
        
        return projectile.getPosition().x < enemy.getPosition().x + enemy.getWidth() &&
               projectile.getPosition().x + projectile.getWidth() > enemy.getPosition().x &&
               projectile.getPosition().y < enemy.getPosition().y + enemy.getHeight() &&
               projectile.getPosition().y + projectile.getHeight() > enemy.getPosition().y;
    }
    
    /**
     * Handle collision between player and enemy
     * @param player The player object
     * @param enemy The enemy object
     */
    public static void handlePlayerEnemyCollision(Player player, Enemy enemy) {
        if (player != null && enemy != null) {
            // Apply damage to player
            player.takeDamage(10); // Simple damage amount
            
            // Apply damage to enemy (if player is attacking)
            if (player.isShooting()) {
                enemy.takeDamage(25); // Simple damage amount
            }
        }
    }
    
    /**
     * Handle collision between projectile and enemy
     * @param projectile The projectile object
     * @param enemy The enemy object
     */
    public static void handleProjectileEnemyCollision(Projectile projectile, Enemy enemy) {
        if (projectile != null && enemy != null && projectile.isActive()) {
            // Apply damage to enemy
            enemy.takeDamage(projectile.getDamage());
            
            // Deactivate projectile
            projectile.setActive(false);
        }
    }
    
    /**
     * Check if player collides with collectible
     * @param player The player object
     * @param collectible The collectible object
     * @return true if colliding
     */
    public static boolean checkPlayerCollectibleCollision(Player player, Collectible collectible) {
        if (player == null || collectible == null) return false;
        
        return player.getPosition().x < collectible.getPosition().x + collectible.getWidth() &&
               player.getPosition().x + player.getWidth() > collectible.getPosition().x &&
               player.getPosition().y < collectible.getPosition().y + collectible.getHeight() &&
               player.getPosition().y + player.getHeight() > collectible.getPosition().y;
    }
}