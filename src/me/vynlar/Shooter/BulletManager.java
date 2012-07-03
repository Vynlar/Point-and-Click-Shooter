package me.vynlar.Shooter;

import it.marteEngine.entity.Entity;

import java.util.ArrayList;
import java.util.List;

import me.vynlar.Shooter.entities.Bullet;
import me.vynlar.Shooter.entities.Enemy;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class BulletManager {

	private List<Bullet> bullets;
	int delta;

	public BulletManager() {
		bullets = new ArrayList<Bullet>();
	}

	public void update(GameContainer container, int delta)
			throws SlickException {
		this.delta = delta;
	}

	public void render(GameContainer container, Graphics g)
			throws SlickException {
		List<Bullet> remove = new ArrayList<Bullet>();
		for (Bullet b : bullets) {
			// update
			b.update(container, delta);

			if (!b.isOnScreen(container)) {
				remove.add(b);
			}

			b.render(container, g);
		}
		for (Bullet b : remove) {
			bullets.remove(b);
		}
	}

	public void addBullet(Bullet b) {
		bullets.add(b);
	}
}
