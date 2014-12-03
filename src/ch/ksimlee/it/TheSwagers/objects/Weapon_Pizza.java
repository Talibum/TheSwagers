package ch.ksimlee.it.TheSwagers.objects;

import ch.ksimlee.it.TheSwagers.Game;

public class Weapon_Pizza extends ImageObject {
	
	/** Path to the image on the filesystem. */
	private static final String FILENAME = "batman.jpg";
	
	private static final int zIndex = 100;
	
	private int direction;
	
	private int speed = 10;
	
	RenderObject shot;

	public Weapon_Pizza(int x, int y) {
		super(x, y, zIndex, true, FILENAME);
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
		
		if(shot != null) {
			game.getObjectsToRemove().add(shot);
		}
		
		if (y <= -getHeight()) {
			// The shot is outside of the visible area.
			game.getObjectsToRemove().add(this);
		}
	}
}
