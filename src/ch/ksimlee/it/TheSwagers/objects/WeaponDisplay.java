package ch.ksimlee.it.TheSwagers.objects;

import java.awt.event.KeyEvent;

import ch.ksimlee.it.TheSwagers.Game;

public class WeaponDisplay extends ImageObject {
	
	private static final String FILENAME = "batman_black.gif";
	
	private static final int zIndex = 0;
	
	private int MagCapacity = 30;
	private boolean ReloadNeed = false;
	
	public Giuseppe giuseppel;

	
	public WeaponDisplay(int x, int y) {
		super(x, y, zIndex, false, FILENAME);
	}
	
	@Override
	public boolean IsFixPos() {
		// TODO Auto-generated method stub
		return true;
	}

	public void update(Game game) {
		
	}
	public int GetOO(){
		return 6;
	}
}
