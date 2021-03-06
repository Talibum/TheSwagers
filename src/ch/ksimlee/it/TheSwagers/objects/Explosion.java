package ch.ksimlee.it.TheSwagers.objects;

import ch.ksimlee.it.TheSwagers.Game;

public class Explosion extends ImageObject {
	
	/** Path to the image on the filesystem. */
	private static final String FILENAME = "batman_black.gif";
	
	private static final int zIndex = 100;
	
	private int lifetime = 5;
	

	public Explosion(int x, int y) {
		super(x, y, zIndex, false, FILENAME);
	}
	
	public Explosion(RenderObject object) {
		this(0,0);
		
		x = object.getCenterX() - getHeight()/2;
		y = object.getCenterY() - getWidth()/2;
	}

	@Override
	public void update(Game game) {
		
		
		if (lifetime == 0) {
			game.getObjectsToRemove().add(this);
		}
		
		lifetime--;
		
	}

}
