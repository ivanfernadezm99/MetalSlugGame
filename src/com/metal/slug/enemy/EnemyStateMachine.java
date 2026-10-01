package com.metal.slug.enemy;

import com.badlogic.gdx.math.Vector2;
import com.metal.slug.player.Player;

/**
 * Enemy State Machine that manages the different states and behaviors of enemies.
 * This class handles state transitions and AI decision making for enemies.
 */
public class EnemyStateMachine {
    public enum State {
        IDLE,        // Standing still
        PATROL,      // Moving in a patrol pattern
        CHASE,      // Following the player
        ATTACK,    // Shooting at the player
        HURT,      // Taking damage
        DEAD       // Enemy is eliminated
    }
    
    private State currentState;
    private State previousState;
    
    // AI behavior parameters
    private float detectionRange = 300f;
    private float attackRange = 150f;
    private float patrolRadius = 100f;
    private float chaseSpeed = 80f;
    private float patrolSpeed = 50f;
    
    // State timers
    private float stateTimer = 0f;
    private float hurtTimer = 0f;
    private float attackCooldown = 0f;
    
    // References
    private Enemy enemy;
    private Player player;
    
    public EnemyStateMachine(Enemy enemy, Player player) {
        this.enemy = enemy;
        this.player = player;
        this.currentState = State.IDLE;
        this.previousState = State.IDLE;
    }
    
    /**
     * Updates the enemy AI state machine
     */
    public void update(float deltaTime) {
        stateTimer += deltaTime;
        
        // Update hurt timer
        if (hurtTimer > 0) {
            hurtTimer -= deltaTime;
        }
        
        // Update attack cooldown
        if (attackCooldown > 0) {
            attackCooldown -= deltaTime;
        }
        
        // AI decision making based on current state
        switch (currentState) {
            case IDLE:
                updateIdle(deltaTime);
                break;
            case PATROL:
                updatePatrol(deltaTime);
                break;
            case CHASE:
                updateChase(deltaTime);
                break;
            case ATTACK:
                updateAttack(deltaTime);
                break;
            case HURT:
                updateHurt(deltaTime);
                break;
            case DEAD:
                updateDead(deltaTime);
                break;
        }
    }
    
    /**
     * Updates the IDLE state
     */
    private void updateIdle(float deltaTime) {
        // Check if player is in detection range
        if (isPlayerDetected()) {
            changeState(State.CHASE);
            return;
        }
        
        // Transition to patrol after some time
        if (stateTimer > 3f) {
            changeState(State.PATROL);
        }
    }
    
    /**
     * Updates the PATROL state
     */
    private void updatePatrol(float deltaTime) {
        // Check if player is in detection range
        if (isPlayerDetected()) {
            changeState(State.CHASE);
            return;
        }
        
        // Simple patrol behavior
        if (enemy.getVelocity().x == 0) {
            // Start moving in a random direction
            if (Math.random() > 0.7f) {
                enemy.setVelocityX(enemy.isFacingRight() ? -patrolSpeed : patrolSpeed);
            }
        }
        
        // Check if at patrol boundary
        if (Math.abs(enemy.getPosition().x - enemy.getPatrolStartX()) > patrolRadius) {
            // Turn around
            enemy.setDirection(!enemy.isFacingRight());
        }
        
        // Transition to idle after some time
        if (stateTimer > 5f) {
            changeState(State.IDLE);
        }
    }
    
    /**
     * Updates the CHASE state
     */
    private void updateChase(float deltaTime) {
        // Check if player is out of detection range
        if (!isPlayerDetected()) {
            changeState(State.IDLE);
            return;
        }
        
        // Check if player is in attack range
        if (isPlayerInRange(attackRange)) {
            changeState(State.ATTACK);
            return;
        }
        
        // Chase the player
        Vector2 playerPos = player.getPosition();
        Vector2 enemyPos = enemy.getPosition();
        
        // Simple chasing behavior
        if (playerPos.x > enemyPos.x) {
            enemy.setVelocityX(chaseSpeed);
            enemy.setDirection(true);
        } else {
            enemy.setVelocityX(-chaseSpeed);
            enemy.setDirection(false);
        }
    }
    
    /**
     * Updates the ATTACK state
     */
    private void updateAttack(float deltaTime) {
        // Check if player is out of detection range
        if (!isPlayerDetected()) {
            changeState(State.IDLE);
            return;
        }
        
        // Check if player is out of attack range
        if (!isPlayerInRange(attackRange)) {
            changeState(State.CHASE);
            return;
        }
        
        // Shoot at player
        if (attackCooldown <= 0) {
            enemy.shoot();
            attackCooldown = 1.0f; // 1 second between shots
        }
    }
    
    /**
     * Updates the HURT state
     */
    private void updateHurt(float deltaTime) {
        // Stay in hurt state for a short time
        if (hurtTimer <= 0) {
            if (enemy.isAlive()) {
                changeState(previousState); // Return to previous state
            } else {
                changeState(State.DEAD);
            }
        }
    }
    
    /**
     * Updates the DEAD state
     */
    private void updateDead(float deltaTime) {
        // Dead enemies don't update their state
    }
    
    /**
     * Checks if player is detected within detection range
     */
    private boolean isPlayerDetected() {
        if (player == null) return false;
        
        Vector2 playerPos = player.getPosition();
        Vector2 enemyPos = enemy.getPosition();
        float distance = playerPos.dst(enemyPos);
        
        return distance <= detectionRange;
    }
    
    /**
     * Checks if player is within a specific range
     */
    private boolean isPlayerInRange(float range) {
        if (player == null) return false;
        
        Vector2 playerPos = player.getPosition();
        Vector2 enemyPos = enemy.getPosition();
        float distance = playerPos.dst(enemyPos);
        
        return distance <= range;
    }
    
    /**
     * Changes the enemy state and performs necessary initialization
     */
    public void changeState(State newState) {
        previousState = currentState;
        currentState = newState;
        stateTimer = 0f;
        
        // Perform state-specific initialization
        switch (newState) {
            case IDLE:
                enemy.setVelocityX(0);
                break;
            case PATROL:
                enemy.setVelocityX(0);
                enemy.setPatrolStartX(enemy.getPosition().x);
                break;
            case CHASE:
                enemy.setVelocityX(0);
                break;
            case ATTACK:
                enemy.setVelocityX(0);
                break;
            case HURT:
                // Hurt timer is handled in updateHurt
                break;
            case DEAD:
                enemy.setVelocityX(0);
                break;
        }
    }
    
    /**
     * Handles damage to the enemy
     */
    public void takeDamage(float damage) {
        if (currentState != State.HURT && currentState != State.DEAD) {
            enemy.applyDamage(damage);
            hurtTimer = 0.5f; // 0.5 second hurt time
            changeState(State.HURT);
        }
    }
    
    /**
     * Gets the current state of the enemy
     */
    public State getCurrentState() {
        return currentState;
    }
    
    /**
     * Gets the previous state of the enemy
     */
    public State getPreviousState() {
        return previousState;
    }
    
    // Getters and setters for AI parameters
    public float getDetectionRange() {
        return detectionRange;
    }
    
    public void setDetectionRange(float detectionRange) {
        this.detectionRange = detectionRange;
    }
    
    public float getAttackRange() {
        return attackRange;
    }
    
    public void setAttackRange(float attackRange) {
        this.attackRange = attackRange;
    }
    
    public float getPatrolRadius() {
        return patrolRadius;
    }
    
    public void setPatrolRadius(float patrolRadius) {
        this.patrolRadius = patrolRadius;
    }
    
    public float getChaseSpeed() {
        return chaseSpeed;
    }
    
    public void setChaseSpeed(float chaseSpeed) {
        this.chaseSpeed = chaseSpeed;
    }
    
    public float getPatrolSpeed() {
        return patrolSpeed;
    }
    
    public void setPatrolSpeed(float patrolSpeed) {
        this.patrolSpeed = patrolSpeed;
    }
}