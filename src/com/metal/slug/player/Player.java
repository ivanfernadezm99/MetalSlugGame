package com.metal.slug.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import com.metal.slug.graphics.ResourceManager;
import com.metal.slug.weapon.Weapon;

/**
 * Player class representing the main character in the game.
 */
public class Player {
    private Vector2 position;
    private Vector2 velocity;
    private float health;
    private int lives;
    private Weapon currentWeapon;
    
    // Animation states
    private Animation<TextureRegion> walkingAnimation;
    private Animation<TextureRegion> jumpingAnimation;
    private Animation<TextureRegion> shootingAnimation;
    private Animation<TextureRegion> idleAnimation;
    private Animation<TextureRegion> damageAnimation;
    
    private float stateTime;
    private TextureRegion currentFrame;
    private boolean isFacingRight;
    private boolean isJumping;
    private boolean isShooting;
    private boolean isDamaged;
    private float damageTimer;
    
    private static final float PLAYER_WIDTH = 32;
    private static final float PLAYER_HEIGHT = 48;
    private static final float JUMP_FORCE = 400f;
    private static final float MOVE_SPEED = 150f;
    private static final float GRAVITY = -800f;
    
    public Player(float x, float y) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        health = 100;
        lives = 3;
        isFacingRight = true;
        isJumping = false;
        isShooting = false;
        isDamaged = false;
        damageTimer = 0f;
        stateTime = 0f;
        
        // Initialize animations
        initializeAnimations();
    }
    
    private void initializeAnimations() {
        ResourceManager rm = ResourceManager.getInstance();
        
        // Load walking animation (4 frames)
        Array<TextureRegion> walkingFrames = new Array<>();
        for (int i = 0; i < 4; i++) {
            walkingFrames.add(new TextureRegion(rm.getTexture("player_walking_" + i)));
        }
        walkingAnimation = new Animation<>(0.1f, walkingFrames);
        
        // Load jumping animation (2 frames)
        Array<TextureRegion> jumpingFrames = new Array<>();
        jumpingFrames.add(new TextureRegion(rm.getTexture("player_jumping_0")));
        jumpingFrames.add(new TextureRegion(rm.getTexture("player_jumping_1")));
        jumpingAnimation = new Animation<>(0.2f, jumpingFrames);
        
        // Load shooting animation (2 frames)
        Array<TextureRegion> shootingFrames = new Array<>();
        shootingFrames.add(new TextureRegion(rm.getTexture("player_shooting_0")));
        shootingFrames.add(new TextureRegion(rm.getTexture("player_shooting_1")));
        shootingAnimation = new Animation<>(0.1f, shootingFrames);
        
        // Load idle animation (1 frame)
        idleAnimation = new Animation<>(0.5f, new TextureRegion(rm.getTexture("player_idle_0")));
        
        // Load damage animation (2 frames)
        Array<TextureRegion> damageFrames = new Array<>();
        damageFrames.add(new TextureRegion(rm.getTexture("player_damage_0")));
        damageFrames.add(new TextureRegion(rm.getTexture("player_damage_1")));
        damageAnimation = new Animation<>(0.1f, damageFrames);
    }
    
    public void update(float deltaTime) {
        // Update state time for animations
        stateTime += deltaTime;
        
        // Apply gravity
        velocity.y += GRAVITY * deltaTime;
        
        // Update position with velocity
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);
        
        // Handle damage timer
        if (isDamaged) {
            damageTimer -= deltaTime;
            if (damageTimer <= 0) {
                isDamaged = false;
            }
        }
        
        // Ground collision
        if (position.y <= 0) {
            position.y = 0;
            velocity.y = 0;
            isJumping = false;
        }
        
        // Update current frame based on animation state
        if (isDamaged) {
            currentFrame = damageAnimation.getKeyFrame(stateTime, true);
        } else if (isShooting) {
            currentFrame = shootingAnimation.getKeyFrame(stateTime, true);
        } else if (velocity.y != 0) {
            currentFrame = jumpingAnimation.getKeyFrame(stateTime, true);
        } else if (velocity.x != 0) {
            currentFrame = walkingAnimation.getKeyFrame(stateTime, true);
        } else {
            currentFrame = idleAnimation.getKeyFrame(stateTime, true);
        }
    }
    
    public void render(SpriteBatch batch) {
        if (currentFrame != null) {
            boolean flipX = !isFacingRight;
            // Handle horizontal flip by drawing with negative width
            if (flipX) {
                batch.draw(currentFrame, position.x + PLAYER_WIDTH, position.y, -PLAYER_WIDTH, PLAYER_HEIGHT);
            } else {
                batch.draw(currentFrame, position.x, position.y, PLAYER_WIDTH, PLAYER_HEIGHT);
            }
        }
    }
    
    public void moveLeft() {
        velocity.x = -MOVE_SPEED;
        isFacingRight = false;
    }
    
    public void moveRight() {
        velocity.x = MOVE_SPEED;
        isFacingRight = true;
    }
    
    public void stopMoving() {
        velocity.x = 0;
    }
    
    public void jump() {
        if (!isJumping) {
            velocity.y = JUMP_FORCE;
            isJumping = true;
        }
    }
    
    public void shoot() {
        isShooting = true;
        stateTime = 0f;
        // Trigger shooting from weapon system
        if (currentWeapon != null) {
            currentWeapon.shoot(position, isFacingRight);
        }
    }
    
    public void stopShooting() {
        isShooting = false;
    }
    
    public void takeDamage(float damage) {
        health -= damage;
        isDamaged = true;
        damageTimer = 0.5f; // Damage invincibility time
    }
    
    public void setWeapon(Weapon weapon) {
        this.currentWeapon = weapon;
    }
    
    // Getters
    public Vector2 getPosition() {
        return position;
    }
    
    public float getHealth() {
        return health;
    }
    
    public int getLives() {
        return lives;
    }
    
    public float getWidth() {
        return PLAYER_WIDTH;
    }
    
    public float getHeight() {
        return PLAYER_HEIGHT;
    }
    
    public boolean isAlive() {
        return health > 0;
    }
    
    public boolean isJumping() {
        return isJumping;
    }
    
    public boolean isShooting() {
        return isShooting;
    }
}