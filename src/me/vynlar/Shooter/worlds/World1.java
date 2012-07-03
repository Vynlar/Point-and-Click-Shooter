package me.vynlar.Shooter.worlds;

import java.io.IOException;
import java.util.List;

import me.vynlar.Shooter.entities.Enemy;
import me.vynlar.Shooter.entities.Player;

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
	Image background;

	int delta;

	public World1(int id, GameContainer container) {
		super(id, container);
		try {
			ResourceManager.loadResources("data/resources.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		background = ResourceManager.getImage("background");
		player = new Player(container.getWidth() / 2, container.getHeight() / 2);

		this.add(player, World.GAME);
		this.add(new Enemy(300, 300, "zombie"), World.GAME);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.drawImage(background, 0, 0);
		for (Entity e : this.getEntities()) {
			if (e.isType("enemy")) {
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