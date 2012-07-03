package me.vynlar.Shooter.entities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import it.marteEngine.Camera;
import it.marteEngine.ResourceManager;
import it.marteEngine.World;
import it.marteEngine.entity.Entity;

public class Player extends Entity {

	int health;
	float speed = 0.3F;

	public Player(float x, float y) {
		super(x, y);
		
		setCentered(true);

		Animation up = new Animation();
		up.addFrame(ResourceManager.getImage("up1"), 500);
		up.addFrame(ResourceManager.getImage("up2"), 500);
		addAnimation("up", up);

		Animation down = new Animation();
		down.addFrame(ResourceManager.getImage("down1"), 500);
		down.addFrame(ResourceManager.getImage("down2"), 500);
		addAnimation("down", down);

		Animation left = new Animation();
		left.addFrame(ResourceManager.getImage("left1"), 500);
		left.addFrame(ResourceManager.getImage("left2"), 500);
		addAnimation("left", left);

		Animation right = new Animation();
		right.addFrame(ResourceManager.getImage("right1"), 500);
		right.addFrame(ResourceManager.getImage("right2"), 500);
		addAnimation("right", right);

		this.setAnim("down");

		define("UP", Input.KEY_W);
		define("DOWN", Input.KEY_S);
		define("LEFT", Input.KEY_A);
		define("RIGHT", Input.KEY_D);
		define("ATTACK", Input.MOUSE_LEFT_BUTTON);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);

		Input in = container.getInput();

		if (check("UP")) {
			y += -speed * delta;
			this.setAnim("up");
		}
		if (check("DOWN")) {
			y += speed * delta;
			this.setAnim("down");
		}
		if (check("LEFT")) {
			x += -speed * delta;
			this.setAnim("left");
		}
		if (check("RIGHT")) {
			x += speed * delta;
			this.setAnim("right");
		}
		if (check("ATTACK")) {
			float mouseX = in.getMouseX();
			float mouseY = in.getMouseY();
			world.add(new Bullet(x,y,mouseX,mouseY), World.GAME);
		}
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		super.render(container, g);
		
	}
}
