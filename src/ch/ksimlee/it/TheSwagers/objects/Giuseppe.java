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
	
	private int speed = 4;
	private int direction;
	private int jumpspeed = -5;
	
	private boolean JumpEnabled = false;
	private int jumpcounter = 0;
	RenderObject move;
	 

	public Giuseppe(int x, int y) {
		super(x, y, zIndex, true, FILENAME);
	}

	@Override
	public void update(Game game) {
		
		if (jumpcounter <= 0){
			move = move(0, speed, game.getObjectsToRender());
			
			if(move != null){
				JumpEnabled = true;
				
				
			}
			else{
				JumpEnabled = false;
			}
			
			if (game.getInputHandler().isKeyPressed(KeyEvent.VK_SPACE) && JumpEnabled) {
				
				jumpcounter = 20;
				
			}
			
		}
		
		else if(jumpcounter <= 10 && jumpcounter > 0){
			jumpcounter --;
			move(0,-3,game.getObjectsToRender());
		}
		
		else{
			jumpcounter --;
			move(0,jumpspeed,game.getObjectsToRender());
		}
		
		
		
		// Check if we need to move left.
		if (game.getInputHandler().isKeyPressed(KeyEvent.VK_A) ||
				game.getInputHandler().isKeyPressed(KeyEvent.VK_LEFT)) {
			
			move(-speed, 0, game.getObjectsToRender());
			direction = 1;
		}
		
		// Check if we need to move right.
		if (game.getInputHandler().isKeyPressed(KeyEvent.VK_D) ||
				game.getInputHandler().isKeyPressed(KeyEvent.VK_RIGHT)) {
			
			move(speed, 0, game.getObjectsToRender());
			direction = 2;
			
		}
		if (game.getInputHandler().isKeyPressed(KeyEvent.VK_SPACE) && JumpEnabled == true) {
			
			move(0, speed, game.getObjectsToRender());
		}
	}
	
	public int GetDirection(){
		return direction;
	}
	
}
		
		




