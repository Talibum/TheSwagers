package ch.ksimlee.it.TheSwagers.objects;

import java.awt.event.KeyEvent;

import ch.ksimlee.it.TheSwagers.Game;

public class WeaponDisplay extends ImageObject {
	
	private static final String FILENAME = "alien.gif";
	
	private static final int zIndex = 0;
	
	private int MagCapacity = 30;
	private boolean ReloadNeed = false;

	
	public WeaponDisplay(int x, int y) {
		super(x, y, zIndex, true, FILENAME);
	}
	
	public void update(Game game) {
		if(game.getInputHandler().isKeyPressed(KeyEvent.VK_W) && MagCapacity > 0){
			MagCapacity--;
		}
		if(MagCapacity <= 0 ){
			ReloadNeed = true;
			System.out.println("reloading?");
			
		}
		if(game.getInputHandler().isKeyPressed(KeyEvent.VK_R)) {
			ReloadNeed = false;
			MagCapacity = 30;
			System.out.println("reloaded!!!");
		}
	}
	

	public boolean GetReloadNeed() {
		return ReloadNeed;
	}
}
