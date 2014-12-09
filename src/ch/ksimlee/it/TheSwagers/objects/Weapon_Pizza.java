package ch.ksimlee.it.TheSwagers.objects;

import java.util.HashSet;
import java.util.Set;

import ch.ksimlee.it.TheSwagers.Game;

public class Weapon_Pizza extends ImageObject {
	
	/** Path to the image on the filesystem. */
	private static final String FILENAME = "pizza.jpeg";
	
	private static final int zIndex = 100;
	
	private int direction;
	
	private int speed = 10;
	
	RenderObject shot;
	
	private Set <Class> destroyableObjects;
	
	
	
	public Weapon_Pizza(int x, int y) {
		super(x, y, zIndex, true, FILENAME);
		
		destroyableObjects = new HashSet<Class>();
		destroyableObjects.add(Alien.class);
		CollisionObjects.add(Alien.class);
	}

	public Weapon_Pizza(Giuseppe giuseppe) {
		this(0,0);
		
		
		direction = giuseppe.GetDirection();
		if(direction == 1) {
			x = giuseppe.x - getWidth();
		}
		else{
			x = giuseppe.x + getWidth();
		}
		
		y = giuseppe.y;
	}

	@Override
	public void update(Game game) {
		
		if (direction == 1) {
			
			
			shot = move(-speed, 0, game.getObjectsToRender());
		}
		else{
			shot = move(speed, 0, game.getObjectsToRender());
		}
		
		if(shot != null && destroyableObjects.contains(shot.getClass())) {
			game.getObjectsToRemove().add(shot);
		}
		
		if (y <= -getHeight()) {
			// The shot is outside of the visible area.
			game.getObjectsToRemove().add(this);
		}
	}
}
