package me.vynlar.Shooter.entities;

import org.newdawn.slick.GameContainer;
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

	public Bullet(float pX, float pY, float mX, float mY, Image sprite) {
		super(pX, pY);
		
		setCentered(true);
		setGraphic(sprite);
		
		vel = new Vector2f(mX-pX,mY-pY);
		vel.normalise();
		vel.scale(20F);
		pos = new Vector2f(pX,pY);
		
		width = sprite.getWidth();
		height = sprite.getHeight();
		
		this.setHitBox(0, 0, width, height);
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		//super.update(container, delta);
		
		pos.set(x, y);
		pos.add(vel);
		x = pos.x;
		y = pos.y;
	}
	
	public Entity collide(String type) {
		return collide(type, x + width/2 , y + height/2);	
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
}
