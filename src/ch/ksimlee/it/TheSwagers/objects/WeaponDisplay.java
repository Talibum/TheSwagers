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
		
	}
}
