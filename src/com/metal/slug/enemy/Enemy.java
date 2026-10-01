package com.metal.slug.enemy;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import com.metal.slug.graphics.ResourceManager;
import com.metal.slug.player.Player;

/**
 * Enemy class representing enemy characters in the game.
 */
public class Enemy {
    private Vector2 position;
    private Vector2 velocity;
    private float health;
    private EnemyType type;
    
    // Animation states
    private Animation<TextureRegion> walkingAnimation;
    private Animation<TextureRegion> shootingAnimation;
    private Animation<TextureRegion> damagedAnimation;
    private Animation<TextureRegion> deathAnimation;
    
    private float stateTime;
    private TextureRegion currentFrame;
    private boolean isFacingRight;
    private boolean isShooting;
    private boolean isDamaged;
    private float damageTimer;
    
    // AI State Machine
    private EnemyStateMachine stateMachine;
    
    // Patrol start position
    private float patrolStartX;
    
    private static final float ENEMY_WIDTH = 32;
    private static final float ENEMY_HEIGHT = 32;
    private static final float MOVE_SPEED = 50f;
    private static final float GRAVITY = -800f;
    
    public enum EnemyType {
        BASIC,
        ADVANCED,
        BOSS
    }
    
    public Enemy(float x, float y, EnemyType type) {
        this(x, y, type, null);
    }
    
    public Enemy(float x, float y, EnemyType type, Player player) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        this.type = type;
        
        // Set health based on enemy type
        switch (type) {
            case BASIC:
                health = 50;
                break;
            case ADVANCED:
                health = 100;
                break;
            case BOSS:
                health = 500;
                break;
        }
        
        isFacingRight = false;
        isShooting = false;
        isDamaged = false;
        damageTimer = 0f;
        stateTime = 0f;
        
        // Initialize state machine
        stateMachine = new EnemyStateMachine(this, player);
        
        // Initialize animations
        initializeAnimations();
    }
    
    private void initializeAnimations() {
        ResourceManager rm = ResourceManager.getInstance();
        
        // Load walking animation
        Array<TextureRegion> walkingFrames = new Array<>();
        for (int i = 0; i < 4; i++) {
            walkingFrames.add(new TextureRegion(rm.getTexture("enemy_walking_" + i)));
        }
        walkingAnimation = new Animation<>(0.15f, walkingFrames);
        
        // Load shooting animation (if applicable)
        if (type == EnemyType.BASIC || type == EnemyType.ADVANCED) {
            Array<TextureRegion> shootingFrames = new Array<>();
            shootingFrames.add(new TextureRegion(rm.getTexture("enemy_shooting_0")));
            shootingFrames.add(new TextureRegion(rm.getTexture("enemy_shooting_1")));
            shootingAnimation = new Animation<>(0.2f, shootingFrames);
        } else {
            shootingAnimation = null;
        }
        
        // Load damaged animation
        Array<TextureRegion> damagedFrames = new Array<>();
        damagedFrames.add(new TextureRegion(rm.getTexture("enemy_damaged_0")));
        damagedFrames.add(new TextureRegion(rm.getTexture("enemy_damaged_1")));
        damagedAnimation = new Animation<>(0.1f, damagedFrames);
        
        // Load death animation (3 frames)
        Array<TextureRegion> deathFrames = new Array<>();
        deathFrames.add(new TextureRegion(rm.getTexture("enemy_death_0")));
        deathFrames.add(new TextureRegion(rm.getTexture("enemy_death_1")));
        deathFrames.add(new TextureRegion(rm.getTexture("enemy_death_2")));
        deathAnimation = new Animation<>(0.2f, deathFrames);
    }
    
    public void update(float deltaTime) {
        // Update AI state machine
        stateMachine.update(deltaTime);
        
        // Update state time for animations
        stateTime += deltaTime;
        
        // Apply gravity
        velocity.y += GRAVITY * deltaTime;
        
        // Update position with velocity
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);
        
        // Ground collision
        if (position.y <= 0) {
            position.y = 0;
            velocity.y = 0;
        }
        
        // Update current frame based on animation state
        if (isDamaged) {
            currentFrame = damagedAnimation.getKeyFrame(stateTime, true);
        } else if (isShooting && shootingAnimation != null) {
            currentFrame = shootingAnimation.getKeyFrame(stateTime, true);
        } else {
            currentFrame = walkingAnimation.getKeyFrame(stateTime, true);
        }
    }
    
    public void render(SpriteBatch batch) {
        if (currentFrame != null) {
            boolean flipX = !isFacingRight;
            if (flipX) {
                batch.draw(currentFrame, position.x + ENEMY_WIDTH, position.y, -ENEMY_WIDTH, ENEMY_HEIGHT);
            } else {
                batch.draw(currentFrame, position.x, position.y, ENEMY_WIDTH, ENEMY_HEIGHT);
            }
        }
    }
    
    public void takeDamage(float damage) {
        // Use state machine for handling damage
        stateMachine.takeDamage(damage);
    }

    public void applyDamage(float damage) {
        this.health -= damage;
    }
    
    public void shoot() {
        // Simple shooting behavior
        isShooting = true;
        stateTime = 0f;
    }
    
    public void stopShooting() {
        isShooting = false;
    }
    
    // Getters
    public Vector2 getPosition() {
        return position;
    }
    
    public Vector2 getVelocity() {
        return velocity;
    }
    
    public float getHealth() {
        return health;
    }
    
    public EnemyType getType() {
        return type;
    }
    
    public float getWidth() {
        return ENEMY_WIDTH;
    }
    
    public float getHeight() {
        return ENEMY_HEIGHT;
    }
    
    public boolean isAlive() {
        return health > 0;
    }
    
    public boolean isDamaged() {
        return isDamaged;
    }
    
    public void setDirection(boolean facingRight) {
        this.isFacingRight = facingRight;
    }
    
    public boolean isFacingRight() {
        return isFacingRight;
    }
    
    public void setVelocityX(float x) {
        velocity.x = x;
    }
    
    public void setVelocityY(float y) {
        velocity.y = y;
    }
    
    public float getPatrolStartX() {
        return patrolStartX;
    }
    
    public void setPatrolStartX(float patrolStartX) {
        this.patrolStartX = patrolStartX;
    }
    
    public EnemyStateMachine getStateMachine() {
        return stateMachine;
    }
    
    // State machine access methods
    public EnemyStateMachine.State getCurrentState() {
        return stateMachine.getCurrentState();
    }
}