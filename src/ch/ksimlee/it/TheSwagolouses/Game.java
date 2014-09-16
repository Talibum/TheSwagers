package ch.ksimlee.it.TheSwagolouses;

import ch.ksimlee.it.TheSwagolouses.Log.Level;



public class Game {
	public static int x = 4;
	
	public static void main() {
		Log.log(Level.DEBUG, "Test loggin");
		
	}
	public static int y() {
		System.out.println("hat funktioniret");
		
		return x*x;
	}
	
	
}
