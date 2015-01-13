package ch.ksimlee.it.TheSwagers.objects;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import ch.ksimlee.it.TheSwagers.Game;

public class Alien extends ImageObject {
	
	/** Path to the image on the filesystem. */
	private static final String FILENAME = "batman_black.gif";
	
	
	private static final int zIndex = 100;
	
	private int speed = 1;
	private int direction;
	private int jumpspeed = -1;
	
	private boolean JumpEnabled1 = false;
	private boolean JumpEnabled2 = false;
	
	private int jumpcounter = 0;
	
	private int WeaponCooldown = 0;
	
	private int MagCapacity = 5;
	private int ReloadSpeed = 100;
	private boolean ReloadingInProcess = false;
	
	private Set <Class> destroyableObjects;
	
	
	RenderObject move;
	 

	public Alien(int x, int y) {
		super(x, y, zIndex, true, FILENAME);
		CollisionObjects.add(Ground.class);
		CollisionObjects.add(Alien.class);
	
		destroyableObjects = new HashSet<Class>();
		destroyableObjects.add(Giuseppe.class);
		
	}

	@Override
	public void update(Game game) {
		//jumping
		if (jumpcounter <= 0){
			move = move(0, speed, game.getObjectsToRender());
			
			if(move != null){
				JumpEnabled1 = true;
				
				
			}
			else{
				JumpEnabled1 = false;
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
		
		
		//Movement towards giuseppe
		
		if (game.giuseppe.getCenterX() - getCenterX() > 0) {
			move = move(speed,0,game.getObjectsToRender());
			if(move != null){
				JumpEnabled2 = true;
			}
			if(move != null && destroyableObjects.contains(move.getClass())) {
				game.reset();
			}
			else{JumpEnabled2 = false;}
			
		
		}
		if (game.giuseppe.getCenterX() - getCenterX() == 0) {
			
		}
		else {
			move = move(-speed,0, game.getObjectsToRender());
			if(move != null){
				JumpEnabled2 = true;
			}
			if(move != null && destroyableObjects.contains(move.getClass())) {
				game.reset();
			}
			else{JumpEnabled2 = false;}
		}
		if (JumpEnabled2 && JumpEnabled1) {
			
			jumpcounter = 20;
			JumpEnabled2 = false;
			JumpEnabled1 = false;
			System.out.println("jumping");
			
		}
		
		//Shooting Process
		if(game.getInputHandler().isKeyPressed(KeyEvent.VK_W) && WeaponCooldown <= 0 && MagCapacity != 0){
			//game.getObjectsToAdd().add(new Weapon_Pizza(this));
			WeaponCooldown = 10;
			MagCapacity --;
			
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