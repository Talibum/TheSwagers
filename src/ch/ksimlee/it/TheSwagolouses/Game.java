package ch.ksimlee.it.TheSwagolouses;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;


import ch.ksimlee.it.TheSwagolouses.objects.RenderObject;
import ch.ksimlee.it.TheSwagolouses.objects.Spaceship;


public class Game implements Runnable {
	
	private static final int ACTIONS_PER_SECOND = 30;
	
	/** A list of all objects that can be rendered. */
	private final List<RenderObject> objectsToRender = new ArrayList<RenderObject>();
	
	/** The handler that should receive the user input. */
		private final InputHandler inputHandler = new InputHandler();
	
	private final Spaceship spaceship;
	
	
	public Game() {
		
		Log.info("Starting a game with " + ACTIONS_PER_SECOND + " actions/second.");
		
		// Create the spaceship.
		spaceship = new Spaceship(200, 200);
		
		
		// Add the spaceship to the list of renderable objects.
		objectsToRender.add(spaceship);
		
		
		Log.info("Game initialized.");
	}

	@Override
	public void run() {
		
		
		while (true) {
			// This loop goes forever, since we don't want our game
			// logic to stop.
			
			// TODO: Add game mechanics here.
			
			// XXX: Example
			// Update all game objects.
			for (RenderObject object : objectsToRender) {
				object.update(inputHandler, objectsToRender);
			}
			
			
			// Delay the next action (iteration of the loop).
			try {
				Thread.sleep((long) (1000.0f/ACTIONS_PER_SECOND));
				
			} catch (InterruptedException e) {
				// We were interrupted, exit the game loop.
				
				Log.error("Caught interruption exception, exiting game loop.");
				e.printStackTrace();
				break;
			}
			
		}
		
	}
	
	public List<RenderObject> getObjectsToRender() {
		return objectsToRender;
	}
	public InputHandler getInputHandler() {
				return inputHandler;
			}
	}


