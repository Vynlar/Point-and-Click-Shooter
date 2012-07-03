package me.vynlar.Shooter.entities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

import it.marteEngine.ResourceManager;
import it.marteEngine.entity.Entity;

public class Enemy extends Entity {
	private Image sprite;
	private int health;

	public Enemy(float x, float y, String type) {
		super(x, y);
		if (type.equalsIgnoreCase("zombie")) {
			health = 10;
			sprite = ResourceManager.getImage("zombie");
			Animation walking = new Animation();
			walking.addFrame(sprite, 500);
			addAnimation("walking", walking);
			this.setHitBox(0, 0, sprite.getWidth(), sprite.getHeight());
		}
	}

	@Override
	public void update(GameContainer container, int delta) {
		collide("enemy",x,y);
	}

	@Override
	public void collisionResponse(Entity other) {
		world.remove(this);
	}
}
