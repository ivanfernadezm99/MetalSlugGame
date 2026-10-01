package com.metal.slug.weapon;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Projectile {
	private Vector2 position;
	private Vector2 velocity;
	private int damage;
	private float range;
	private float maxRange;
	private boolean active;
	
	public Projectile(Vector2 position, Vector2 direction, int damage, float range) {
		this.position = new Vector2(position);
		this.damage = damage;
		this.range = range;
		this.maxRange = range;
		this.active = true;
		
		// Set velocity based on direction (simplified)
		// In a real implementation, this might be more complex
		this.velocity = new Vector2(direction).nor().scl(300f); // 300 pixels per second
	}
	
	public void update(float deltaTime) {
		if (!active) return;
		
		// Update position
		position.add(velocity.x * deltaTime, velocity.y * deltaTime);
		
		// Decrease range
		range -= velocity.len() * deltaTime;
		
		// Check if projectile is out of range or has hit something
		if (range <= 0) {
			active = false;
		}
	}
	
	public void render(SpriteBatch batch) {
		// In a real implementation, we would render the projectile
		// For now, this is just a placeholder
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public float getRange() {
		return range;
	}
	
	public float getMaxRange() {
		return maxRange;
	}
}