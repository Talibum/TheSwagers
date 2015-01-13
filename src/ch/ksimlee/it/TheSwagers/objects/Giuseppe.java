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
	private int jumpspeed = -6;
	
	private boolean JumpEnabled = false;
	private int jumpcounter = 0;
	
	private int WeaponCooldown = 0;
	
	private int MagCapacity = 10;
	private int ReloadSpeed = 50;
	private boolean ReloadingInProcess = false;
	
	public WeaponDisplay weapondisplay;
	
	RenderObject move;
	 

	public Giuseppe(int x, int y,WeaponDisplay b) {
		super(x, y, zIndex, true, FILENAME);
		weapondisplay = b;
		CollisionObjects.add(Ground.class);
		CollisionObjects.add(Alien.class);
	}

	@Override
	public void update(Game game) {
		//jumping
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
				JumpEnabled = false;
				
			}
			
		}
		else{
			if(jumpcounter <= 7 && jumpcounter >= 0){
				move(0,-3,game.getObjectsToRender());
				jumpcounter --;
			}
			else{
				jumpcounter --;
				move(0,jumpspeed,game.getObjectsToRender());
			}
		}
		
		RenderObject collision = null;
		
		// KEYS
		
		//Movement Process
		if (game.getInputHandler().isKeyPressed(KeyEvent.VK_A) ||
				game.getInputHandler().isKeyPressed(KeyEvent.VK_LEFT)) {
			
			collision = move(-speed, 0, game.getObjectsToRender());
			direction = 1;
			
			
		}
		
		
		if (game.getInputHandler().isKeyPressed(KeyEvent.VK_D) ||
				game.getInputHandler().isKeyPressed(KeyEvent.VK_RIGHT)) {
			
			move(speed, 0, game.getObjectsToRender());
			direction = 2;
			
		}
		if (game.getInputHandler().isKeyPressed(KeyEvent.VK_SPACE) && JumpEnabled == true) {
			
			move(0, speed, game.getObjectsToRender());
		}
		
		//Shooting Process
		if(game.getInputHandler().isKeyPressed(KeyEvent.VK_W) && WeaponCooldown <= 0 && MagCapacity != 0){
			game.getObjectsToAdd().add(new Weapon_Pizza(this));
			WeaponCooldown = 10;
			MagCapacity --;
			
		}
		
		//Reloading Process
		if(game.getInputHandler().isKeyPressed(KeyEvent.VK_R)) {
			
				ReloadingInProcess = true;
			
		}
		
		if(ReloadingInProcess) {
			if(ReloadSpeed > 0) {
				ReloadSpeed--;
			}
			else{
				ReloadingInProcess = false;
				ReloadSpeed = 50;
				MagCapacity = 10;
				System.out.println("Reloaded!");
			}
		}
	
		WeaponCooldown --;
	}
	
	public int GetDirection(){
		return direction;
	}
	
}
		
		




