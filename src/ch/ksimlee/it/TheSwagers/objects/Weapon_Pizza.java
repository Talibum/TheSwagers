package ch.ksimlee.it.TheSwagers.objects;

import ch.ksimlee.it.TheSwagers.Game;

public class Weapon_Pizza extends ImageObject {
	
	/** Path to the image on the filesystem. */
	private static final String FILENAME = "batman.jpg";
	
	private static final int zIndex = 100;
	
	private int direction;
	
	private int speed = 10;

	public Weapon_Pizza(int x, int y) {
		super(x, y, zIndex, true, FILENAME);
	}

	public Weapon_Pizza(Giuseppe giuseppe) {
		this(0,0);
		
		
		direction = giuseppe.GetDirection();
		x = giuseppe.getCenterX() - getWidth() / 2;
		y = giuseppe.y - getHeight();
	}

	@Override
	public void update(Game game) {
		
		if (direction == 1) {
			move(-speed, 0, game.getObjectsToRender());
		}
		else{
			move(speed, 0, game.getObjectsToRender());
		}
		
		
		
		if (y <= -getHeight()) {
			// The shot is outside of the visible area.
			game.getObjectsToRemove().add(this);
		}
	}
}
