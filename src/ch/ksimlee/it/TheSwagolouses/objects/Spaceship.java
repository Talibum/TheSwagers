package ch.ksimlee.it.TheSwagolouses.objects;

import java.awt.event.KeyEvent;
import java.util.List;

import ch.ksimlee.it.TheSwagolouses.InputHandler;

/**
 * This is a spaceship that will be controlled by the player.
 */
public class Spaceship extends ImageObject {
	
	/** Path to the image on the filesystem. */
	private static final String FILENAME = "spaceship.png";
	   
	private static final int zIndex = 100;

	private int speed = 5;

	public Spaceship(int x, int y) {
		super(x, y, zIndex, false, FILENAME);
	}
	public void update(InputHandler currentInput, List<RenderObject> allObjects) {
		
		// Check if we need to move left.
		if (currentInput.isKeyPressed(KeyEvent.VK_A) ||
				currentInput.isKeyPressed(KeyEvent.VK_LEFT)) {
			
			move(-speed , 0, allObjects);
		}
		
		// Check if we need to move right.
		if (currentInput.isKeyPressed(KeyEvent.VK_D) ||
				currentInput.isKeyPressed(KeyEvent.VK_RIGHT)) {
			
			move(speed, 0, allObjects);
		}
		if (currentInput.isKeyPressed(KeyEvent.VK_W) ||
					currentInput.isKeyPressed(KeyEvent.VK_UP)) {
				
			move(0,-speed, allObjects);
			}
				
		if (currentInput.isKeyPressed(KeyEvent.VK_S) ||
						currentInput.isKeyPressed(KeyEvent.VK_DOWN)) {
					
			move(0, speed, allObjects);
		}
	}
	
}


