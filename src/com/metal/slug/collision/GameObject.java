package com.metal.slug.collision;

import com.badlogic.gdx.math.Vector2;

/**
 * Minimal GameObject interface for generic collision checks.
 */
public interface GameObject {
    Vector2 getPosition();
    float getWidth();
    float getHeight();
}
