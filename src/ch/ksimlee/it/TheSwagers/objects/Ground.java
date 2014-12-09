package ch.ksimlee.it.TheSwagers.objects;

import ch.ksimlee.it.TheSwagers.Game;


	
public class Ground extends ImageObject {
		
	/** Path to the image on the filesystem. */
	private static final String FILENAME = "ground1.jpg";
		
	private static final int zIndex = 100;
		
	

	public Ground(int x, int y) {
			super(x, y, zIndex, true, FILENAME);
			CollisionObjects.add(Ground.class);
			CollisionObjects.add(Alien.class);
	}

	@Override
	public void update(Game game) {
			
	}

}

