package ch.ksimlee.it.TheSwagolouses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;



@SuppressWarnings("serial")
public class Canvas extends JPanel {
	
	public BufferedImage mario;
	public int BewegungY = 40;
	
	public static final int WIDGHT = 800;
	public static final int HIGHT = WIDGHT / 16*9;
	private long aktuelleSekunde = 0;
	private int Counter = 0;
	private int lastFPS;
	

	// This variable stores the size of the canvas (in pixel).
	private Dimension SIZE = new Dimension(WIDGHT, HIGHT);

	// This variable stores with how many frames per second (FPS) the canvas
	// should be redrawn.
	private static final int FPS = 25;

	public Canvas() {
		setPreferredSize(SIZE);

		Log.info("Initialized canvas.");
		try {                
	          mario = ImageIO.read(new File("Mario-Icon.jpg"));
	       } catch (IOException ex) {
	            // handle exception...
	       }
		

		/*
		 * The class timer (from swing) can be used to call a function
		 * periodically. The first argument specifies the frequency in
		 * milliseconds with which the function will be called, and the second
		 * argument an object of type "ActionListener" from which the function
		 * "actionPerformed" will be called with the specified frequency.
		 */
		Timer timer = new Timer((int) (1000.0 / FPS), new ActionListener() {

			// This function is called with the specified frequency.
			@Override
			public void actionPerformed(ActionEvent e) {
				// Repaint the canvas object.
				Canvas.this.repaint();
			}
		});

		// As the timer should immediately start to work, we start it here.
		timer.start();

		Log.info("Drawing timer started.");
	}

	// This function draws this canvas (it draws the JPanel).
	public void paintComponent(Graphics g) {

		Log.debug("Painting the canvas.");

		// Let the swing framework do it's drawing of the JPanel first.
		super.paintComponent(g);
		

		// The following two commands draw the background:

		// Set the color of the "pen". This color will be used in the following
		// drawing commands.
		g.setColor(Color.blue);

		// Draw a rectangle with the size of the canvas. Therefore, this draws a
		// "background".
		g.fillRect(0, 0, SIZE.width, SIZE.height);
		g.setColor(Color.green);
		g.fillRect(0,SIZE.height-40,SIZE.width, SIZE.height);
		g.drawImage(mario,BewegungY, SIZE.height-190,null);
		
		long now = System.currentTimeMillis()/1000;
		if(now>aktuelleSekunde){
			aktuelleSekunde = now;
			lastFPS = Counter;
			Counter = 0;
		}else{
			Counter = Counter + 1;
		}
		g.setColor(Color.white);
		g.drawString(""+lastFPS, SIZE.width-30, 20);
		// TODO: Add more drawing commands here.

	}

}