package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Represents a 4x4 slider object which randomized tiles.
 * 
 * @author Alvin Nguyen 
 *
 */
public class Slider {
	
	/** The number of rows in the slider. **/
	private static final int NUM_ROWS = 4;
	
	/** The number of columns in the slider. **/
	private static final int NUM_COLUMNS = 4;
	
	/** The number of tiles in the slider. **/
	private static final int NUM_TILES= 16;
	
	/** The 2d array of the slider - rows, columns. **/
	private final Tile[][] mySlider = new Tile[NUM_ROWS][NUM_COLUMNS];

	private final List<Tile> myTileNumbers = new ArrayList<>();
	
	private final Stack<Tile> myStack = new Stack<>(); 
	
	/** 
	 * The slider object; takes tiles and assigns them a number inside
	 * the List.
	 */
	public Slider() {
		for (int i = 0; i < NUM_TILES; i++) {
			Tile tile = new Tile();
			//tile.setNumber(i);
			myTileNumbers.add(tile);
		}
		
		//shuffle the List of tiles to create a random order.
		Collections.shuffle(myTileNumbers);
		 
		myStack.addAll(myTileNumbers);
		
		while (myStack.size() > 0) {
			for (int row = 0; row < NUM_ROWS; row++) {
				for (int col = 0; col < NUM_COLUMNS; col++) {
					mySlider[row][col] = myStack.pop();
				}
			}
		}
	}
	
	public Tile[][] getSlider() {
		return mySlider;
	}
	
	
}
