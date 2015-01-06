package ch.ksimlee.it.TheSwagers;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import ch.ksimlee.it.TheSwagers.log.Log;
import ch.ksimlee.it.TheSwagers.objects.Alien;
import ch.ksimlee.it.TheSwagers.objects.Giuseppe;
import ch.ksimlee.it.TheSwagers.objects.Ground;
import ch.ksimlee.it.TheSwagers.objects.RenderObject;
import ch.ksimlee.it.TheSwagers.objects.WeaponDisplay;




public class Game implements Runnable {
	
	private static final int ACTIONS_PER_SECOND = 50;
	
	
	
	/** A list of all objects that can be rendered. */
	private final Set<RenderObject> objectsToRender = new HashSet<RenderObject>();
	
	private final Set<RenderObject> objectsToAdd = new HashSet<RenderObject>();

	public Set<RenderObject> getObjectsToAdd() {
		return objectsToAdd;
	}

	public Set<RenderObject> getObjectsToRemove() {
		return objectsToRemove;
	}

	private final Set<RenderObject> objectsToRemove = new HashSet<RenderObject>();

	
	/** The handler that should receive the user input. */
	private final InputHandler inputHandler = new InputHandler();
	
	
	private  Ground ground;
	public  Giuseppe giuseppe;
	public  WeaponDisplay weapondisplay;
	public Canvas canvas;
	//private int ScrollX = canvas.GetScrollX;
	
	public Game() {
		
		Log.info("Starting a game with " + ACTIONS_PER_SECOND + " actions/second.");
		
		
		
	initialize();
		
		Log.info("Game initialized.");
	}
private void initialize() {
	// Create the spaceship.
			ground = new Ground(0,500);
			weapondisplay = new WeaponDisplay(0, 0);
			giuseppe = new Giuseppe(200, 200, weapondisplay);
			weapondisplay.giuseppel = giuseppe;
		
			
			// Add the spaceship to the list of renderable objects.
			objectsToRender.add(giuseppe);
			objectsToRender.add(ground);
			objectsToRender.add(weapondisplay);
			
			
			for (int i = 0; i < 500; i += 100) {
				objectsToRender.add(new Alien(i, 100));
			}	
}
/**
 * Reset the game, i.e., perform a restart
 */
private void reset() {
	
	//Clear alle the objects from the game.
	objectsToRender.clear();
	
	//Reintialize the game.
	initialize();
	
}

	@Override
	public void run() {
		
		while (true) {
			// This loop goes forever, since we don't want our game
			// logic to stop.
			
			// Check if the game should be resetted.
			if (inputHandler.isKeyPressed(KeyEvent.VK_R)) {
				reset();
			}
			// TODO: Add game mechanics here.
			
			// Update all game objects.
			for (RenderObject object : objectsToRender) {
				object.update(this);
			}
			
			objectsToRender.removeAll(objectsToRemove);
			objectsToRender.addAll(objectsToAdd);
			
			objectsToAdd.clear();
			objectsToRemove.clear();
			
			// Update the input state.
			inputHandler.updatedReleasedKeys();
			
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
	
	public Set<RenderObject> getObjectsToRender() {
		return objectsToRender;
	}

	public InputHandler getInputHandler() {
		return inputHandler;
	}
}
