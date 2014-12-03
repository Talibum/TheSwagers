package ch.ksimlee.it.TheSwagers.objects;

import ch.ksimlee.it.TheSwagers.Game;

public class Alien extends ImageObject {
	
	/** Path to the image on the filesystem. */
	private static final String FILENAME = "alien.gif";
	
	private static final int zIndex = 100;
	
	
	private int speed = 10;

	public Alien(int x, int y) {
		super(x, y, zIndex, true, FILENAME);
	}

	@Override
	public void update(Game game) {
		
	}

}
