package ch.ksimlee.it.TheSwagolouses.objects;

/**
 * This is a mario that will be controlled by the player.
 */
public class Mario extends ImageObject {
	
	/** Path to the image on the filesystem. */
	private static final String FILENAME = "Mario-Icon.jpg";
	
	private static final int zIndex = 100;

	public Mario(int x, int y) {
		super(x, y, zIndex, FILENAME);
	}

}
