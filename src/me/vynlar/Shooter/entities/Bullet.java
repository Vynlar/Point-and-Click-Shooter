package me.vynlar.Shooter.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import it.marteEngine.ResourceManager;
import it.marteEngine.entity.Entity;

public class Bullet extends Entity{
	
	private Vector2f vel;
	private Vector2f pos;
	int width,height;
	float speed = 0.1F;

	public Bullet(float pX, float pY, float mX, float mY) throws SlickException {
		super(pX, pY);
		
		Image sprite = ResourceManager.getImage("bullet");
		
		addType("bullet");
		
		vel = new Vector2f(mX-pX,mY-pY);
		vel.normalise();
		vel.scale(speed);
		pos = new Vector2f(pX,pY);
		
		//setCentered(true);
		setGraphic(sprite);
		
		width = sprite.getWidth();
		height = sprite.getHeight();
		
		this.setHitBox(width/4, height/4, (width/4)*3, (height/4)*3);
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
		this.checkWorldBoundaries();
		
		pos.set(x, y);
		vel.normalise();
		vel.scale(speed*delta);
		pos.add(vel);
		x = pos.x;
		y = pos.y;
		currentImage.setRotation((float)vel.getTheta());
	}
	
	public boolean isOnScreen(GameContainer container)
	{
		Rectangle bullet = new Rectangle(x,y,width,height);
		Rectangle screen = new Rectangle(0,0,container.getWidth(), container.getHeight());
		
		if(bullet.intersects(screen))
		{
			return true;
		}
		return false;
	}
	
	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		super.render(container, g);
	}
}
