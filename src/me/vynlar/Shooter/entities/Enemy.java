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
	Player player;
	float speed = 0.03F;

	public Enemy(float x, float y, String type) {
		super(x, y);
		addType("enemy");
		if (type.equalsIgnoreCase("zombie")) {
			health = 10;
			sprite = ResourceManager.getImage("zombie");
			Animation walking = new Animation();
			walking.addFrame(sprite, 500);
			addAnimation("walking", walking);
			this.setHitBox(20, 20, sprite.getWidth()-20, sprite.getHeight()-20);
		}
	}

	public void init(Player player) {
		this.player = player;
		pos = new Vector2f(x, y);
		vel = new Vector2f(x - player.x, y - player.y);
	}

	@Override
	public void update(GameContainer container, int delta) {
		collide("bullet", x + width / 2, y + height / 2);
		vel.set(x - player.x, y - player.y);
		vel.normalise();
		vel.scale(speed * delta * -1);
		pos.set(x, y);
		pos.add(vel);
		x = pos.getX();
		y = pos.getY();
	}

	@Override
	public void collisionResponse(Entity other) {
		if (other.isType("bullet")) {
			health -= 10;
			if (health <= 0) {
				world.remove(this);
			}
		}
	}
}
