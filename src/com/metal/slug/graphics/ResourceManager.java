package com.metal.slug.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Resource manager for loading and managing game assets.
 */
public class ResourceManager {
    private static ResourceManager instance;
    private Map<String, Texture> textures;
    private Map<String, Animation<TextureRegion>> animations;
    
    private ResourceManager() {
        textures = new HashMap<>();
        animations = new HashMap<>();
    }
    
    public static ResourceManager getInstance() {
        if (instance == null) {
            instance = new ResourceManager();
        }
        return instance;
    }
    
    /**
     * Load a texture from file.
     */
    public void loadTexture(String name, String path) {
        Texture texture = new Texture(path);
        textures.put(name, texture);
    }
    
    /**
     * Load an animation from a sprite sheet.
     */
    public void loadAnimation(String name, String path, int frameWidth, int frameHeight, int frameCount, float frameDuration) {
        Texture texture = new Texture(path);
        Array<TextureRegion> frames = new Array<>();
        
        for (int i = 0; i < frameCount; i++) {
            TextureRegion frame = new TextureRegion(texture, i * frameWidth, 0, frameWidth, frameHeight);
            frames.add(frame);
        }
        
        Animation<TextureRegion> animation = new Animation<>(frameDuration, frames);
        animations.put(name, animation);
    }
    
    /**
     * Get a loaded texture.
     */
    public Texture getTexture(String name) {
        return textures.get(name);
    }
    
    /**
     * Get a loaded animation.
     */
    public Animation<TextureRegion> getAnimation(String name) {
        return animations.get(name);
    }
    
    /**
     * Dispose of all loaded resources.
     */
    public void dispose() {
        for (Texture texture : textures.values()) {
            texture.dispose();
        }
        textures.clear();
        animations.clear();
    }
}