package ch.ksimlee.it.TheSwagolouses;

import java.awt.BorderLayout;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Window extends JFrame {

	/*
	 * This variable stores the title of the game. As it will not change at
	 * runtime, we defined it as "final", meaning that it _cannot_ be modified.
	 */
	public static final String GAME_TITLE = "SWAG";

	/*
	 * This is the constructor of the class. Every object that is created with a
	 * " new ..." command is created with a constructor, which is executed once
	 * during the creation of the object.
	 * 
	 * NOTE: Constructors do not have a return type, since they "implicitly"
	 * return the object that was created.
	 */
	public Window() {

		// Set the title of the JFrame (swing function).
		setTitle(GAME_TITLE);

		// Specify what should happen when the close button is clicked (Swing
		// function). 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		

		// Specify the layout that should be used inside this JFrame (swing
		// function).
		setLayout(new BorderLayout());

		// Create the canvas on which we are going to draw the game.
		Canvas canvas = new Canvas();
		canvas.setVisible(true);

		// Add the canvas to this JFrame (swing function).
		add(canvas, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setResizable(false);

		// This swing function is necessary so that the JFrame is rendered.
		pack();

		Log.info("Initialized main window.");
	}

}