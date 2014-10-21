package ch.ksimlee.it.TheSwagolouses.objects;

import java.awt.event.KeyEvent;

import ch.ksimlee.it.TheSwagolouses.InputHandler;

/**
 * This is a mario that will be controlled by the player.
 */
public class Mario extends ImageObject {
	
	/** Path to the image on the filesystem. */
	private static final String FILENAME = "Mario-Icon.jpg";
	
	private static final int zIndex = 50;

	private int speed = 7;
	private boolean isjumping = false;
	private int MaxJumpHight = 5;
	private int currentJumpHight;

	public Mario(int x, int y) {
		super(x, y, zIndex, FILENAME);
	}
	public void update(InputHandler currentInput) {
		
		// Check if we need to move left.
		if (currentInput.isKeyPressed(KeyEvent.VK_A) ||
				currentInput.isKeyPressed(KeyEvent.VK_LEFT)) {
			
			move(-speed  , 0);
		}
		
		// Check if we need to move right.
		if (currentInput.isKeyPressed(KeyEvent.VK_D) ||
				currentInput.isKeyPressed(KeyEvent.VK_RIGHT)) {
			
			move(speed, 0);
		}
		if (currentInput.isKeyPressed(KeyEvent.VK_SPACE)) {
			isjumping = true;
			currentJumpHight = 1;
			
		}
		if(isjumping){
			if(currentJumpHight <= MaxJumpHight){
				currentJumpHight++;
				move(0,-3);  
			}
			
		}

	}
}
	