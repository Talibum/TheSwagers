package ch.ksimlee.it.TheSwagers.objects;

import ch.ksimlee.it.TheSwagers.Game;

public class Weapon_Pizza extends ImageObject {
	
	/** Path to the image on the filesystem. */
	private static final String FILENAME = "shot.png";
	
	private static final int zIndex = 100;
	
	private int direction;
	
	private int speed = 10;

	public Weapon_Pizza(int x, int y) {
		super(x, y, zIndex, true, FILENAME, 0);
	}

	public Weapon_Pizza(Giuseppe giuseppe) {
		this(0,0);
		
		
		direction = giuseppe.GetDirection();a
		x = giuseppe.getCenterX() - getWidth() / 2;
		y = giuseppe.y - getHeight();
	}

	@Override
	public void update(Game game) {
		
		RenderObject collision = move(speed, 0, game.getObjectsToRender());
		
		if (collision != null) {
			if (collision instanceof Alien) {
				game.getObjectsToRemove().add(collision);
				game.getObjectsToRemove().add(this);
				
				game.getObjectsToAdd().add(new Explosion(collision));
			}
		}
		
		if (y <= -getHeight()) {
			// The shot is outside of the visible area.
			game.getObjectsToRemove().add(this);
		}
	}
}
