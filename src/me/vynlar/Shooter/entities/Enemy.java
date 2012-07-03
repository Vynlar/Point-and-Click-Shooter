package me.vynlar.Shooter.entities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import it.marteEngine.ResourceManager;
import it.marteEngine.entity.Entity;

public class Enemy extends Entity {
	private Image sprite;
	private int health;
	Vector2f pos, vel;

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

	public void init(Player player) {
		pos = new Vector2f(x, y);
		vel = new Vector2f(x - player.x, y - player.y);
		vel.normalise();
		vel.scale(0.1F);
	}

	@Override
	public void update(GameContainer container, int delta) {
		collide("enemy", x, y);
		System.out.println(x);
		pos.set(x, y);
		pos.add(vel);
		x = pos.getX();
		y = pos.getY();
	}

	@Override
	public void collisionResponse(Entity other) {
		world.remove(this);
	}
}
