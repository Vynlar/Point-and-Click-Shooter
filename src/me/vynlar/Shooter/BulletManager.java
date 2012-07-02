package me.vynlar.Shooter;

import it.marteEngine.entity.Entity;

import java.util.ArrayList;
import java.util.List;

import me.vynlar.Shooter.entities.Bullet;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class BulletManager {

	private List<Bullet> bullets;

	public BulletManager() {
		bullets = new ArrayList<Bullet>();
	}

	public void update(GameContainer container, int delta)
			throws SlickException {

		List<Bullet> remove = new ArrayList<Bullet>();
		for (Bullet b : bullets) {
			b.update(container, delta);

			/*
			 * Entity other = b.collide("enemy"); if(other != null) {
			 * remove.add(b); //remove enemy }
			 */

			if (!b.isOnScreen(container)) {
				remove.add(b);
			}
		}

		for (Bullet b : remove) {
			bullets.remove(b);
		}
	}

	public void render(GameContainer container, Graphics g)
			throws SlickException {
		for (Bullet b : bullets) {
			b.render(container, g);
		}
	}

	public void addBullet(Bullet b) {
		bullets.add(b);
	}
}
