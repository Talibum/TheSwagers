package init;

import init.Log.Level;



public class Game {
	public static int x = 4;
	
	public static void main() {
		Log.log(Level.DEBUG, "TEst loggin");
		
	}
	public static int y() {
		System.out.println("hat funktioniret");
		
		return x*x;
	}
	
	
}
