package me.vynlar.Shooter.worlds;

import me.vynlar.Shooter.entities.Enemy;
import me.vynlar.Shooter.entities.Player;
import it.marteEngine.World;

public class Level {

	public Level() {
		
	}
	
	public void load(World world, Player player){
		world.clear();
		world.add(new Enemy(100, 100, "zombie"), World.GAME);
	}
}
