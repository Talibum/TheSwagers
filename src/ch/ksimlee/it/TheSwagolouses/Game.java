package ch.ksimlee.it.TheSwagolouses;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import ch.ksimlee.it.TheSwagolouses.Log.Level;

public class Game extends Canvas implements Runnable {
	
	public static final int WIDGHT = 800;
	public static final int HIGHT = WIDGHT * 16 / 9;
	

	
	
	public Game(){
		
		
		
		
		JFrame WINDOW = new JFrame("FrameTest");
		
		WINDOW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WINDOW.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        WINDOW.setPreferredSize(new Dimension(HIGHT, WIDGHT));
        WINDOW.setBackground(Color.red);
        WINDOW.pack();
        WINDOW.setResizable(false);
        WINDOW.setLocationRelativeTo(null);
        WINDOW.setVisible(true);
	}
	public synchronized void start(){
		new Thread(this).start
	}
		
    public static void main(String[] args) {
    	Log.log(Level.INFO , "game version alpha 0.001");
    	new Game(start);
    }
	
	
}
	
	

