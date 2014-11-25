package ch.ksimlee.it.TheSwagers.objects;

import java.awt.event.KeyEvent;

import ch.ksimlee.it.TheSwagers.Game;

/**
 * This is a spaceship that will be controlled by the player.
 */
public class Giuseppe extends ImageObject {
	
	/** Path to the image on the filesystem. */
	private static final String FILENAME = "batman_black.gif";
	
	private static final int zIndex = 100;
	
	private int speed = 5;
	
	private boolean JumpEnabled = false;
	private int jumpcounter = 50;
	 

	public Giuseppe(int x, int y) {
		super(x, y, zIndex, true, FILENAME);
	}

	@Override
	public void update(Game game) {
		
		if (jumpcounter <= 0){
			RenderObject move = move(0, speed, game.getObjectsToRender())
		}
		
		
		
		if(move != null){
			JumpEnabled = true;
			
			
		}
		
		if (game.getInputHandler().isKeyPressed(KeyEvent.VK_SPACE) && JumpEnabled == true) {
			
			jump(getY(), 100, 500,game.getObjectsToRender());
			System.out.println("lol");
		
		}
		
		
		
		// Check if we need to move left.
		if (game.getInputHandler().isKeyPressed(KeyEvent.VK_A) ||
				game.getInputHandler().isKeyPressed(KeyEvent.VK_LEFT)) {
			
			move(-speed, 0, game.getObjectsToRender());
		}
		
		// Check if we need to move right.
		if (game.getInputHandler().isKeyPressed(KeyEvent.VK_D) ||
				game.getInputHandler().isKeyPressed(KeyEvent.VK_RIGHT)) {
			
			move(speed, 0, game.getObjectsToRender());
			
		}
	}
	
}
		
		




