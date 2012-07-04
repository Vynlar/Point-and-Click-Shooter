package me.vynlar.Shooter.worlds;

import java.io.IOException;

import me.vynlar.Shooter.entities.Enemy;
import me.vynlar.Shooter.entities.Player;
import me.vynlar.Shooter.worlds.levels.Level;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import it.marteEngine.ResourceManager;
import it.marteEngine.World;
import it.marteEngine.entity.Entity;

public class World1 extends World {

	Player player;
	Level[] level;

	int delta;

	public World1(int id, GameContainer container) {
		super(id, container);
		try {
			ResourceManager.loadResources("data/resources.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		player = new Player(container.getWidth() / 2, container.getHeight() / 2);

		this.add(player, World.GAME);
		
		level = new Level[1];

		level[0] = new Level("background");
		level[0].init();
		for (int i = 0; i < 10; i++) {
			level[0].addEnemy(new Enemy((float)(Math.random()*container.getWidth()), (float)(Math.random()*container.getHeight()), "zombie"));
		}
		level[0].load(this, player);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		for (Entity e : this.getEntities()) {
			if (e.isType("bullet")) {
				e.update(container, delta);
				e.render(container, g);
			} else {
				e.render(container, g);
			}
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		super.update(container, game, delta);
		this.delta = delta;
	}
}