package me.vynlar.Shooter;

import me.vynlar.Shooter.worlds.FirstWorld;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Shooter extends StateBasedGame {

	public Shooter() {
		super("Shooter!");

	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new FirstWorld(0, container));
	}

	public static void main(String[] args) {
		try {
			AppGameContainer container = new AppGameContainer(new Shooter());
			container.setDisplayMode(800, 600, false);
			container.setTargetFrameRate(60);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}