package me.vynlar.Shooter.worlds.levels;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;

import me.vynlar.Shooter.entities.Enemy;
import me.vynlar.Shooter.entities.Player;
import me.vynlar.Shooter.worlds.World1;
import it.marteEngine.ResourceManager;
import it.marteEngine.World;

public class Level {

	Image background;
	List<Enemy> enemies;

	public Level(String background) {
		this.background = ResourceManager.getImage(background);
	}

	public void init() {
		enemies = new ArrayList<Enemy>();
	}

	public void load(World1 world, Player player) {
		world.clear();
		for (Enemy e : enemies) {
			e.init(player);
			world.add(e, World.GAME);
		}
		world.add(player, World.GAME);
	}

	public void addEnemy(Enemy enemy) {
		enemies.add(enemy);
	}
}
