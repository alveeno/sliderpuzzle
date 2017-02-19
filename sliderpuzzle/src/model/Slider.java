package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Represents a 4x4 slider object which randomized tiles.
 * Each instance of Slider will be randomized.
 * 
 * @author Alvin Nguyen 
 *
 */
public class Slider {
	
	/** The number of rows in the slider. **/
	private static final int NUM_ROWS = 6;
	
	/** The number of columns in the slider. **/
	private static final int NUM_COLUMNS = 6;
	
	/** The number of tiles in the slider. **/
	private static final int NUM_TILES= 16;
	
	/** The 2d array of the slider - rows, columns. **/
	private final int[][] mySlider = new int[NUM_ROWS][NUM_COLUMNS];

	private final List<Tile> myTileNumbers = new ArrayList<>();
	
	private final Stack<Tile> myStack = new Stack<>(); 
	
	/** 
	 * The slider object; takes tiles and assigns them a number inside
	 * the List.
	 */
	public Slider() {
		// create 2D array of 0's
		for (int i = NUM_ROWS; i < 6; i ++) {
			for (int j = NUM_COLUMNS; j < 6; i++) {
				mySlider [i][j] = 0;
			}
		}
		int num = 1;
		for (int row = 1; row < NUM_ROWS; row++) {
			for (int col = 1; col < NUM_COLUMNS; col++) {
				mySlider [row][col] = num;
				num++;
			}
		}
		System.out.print(mySlider);
		//shuffle the List of tiles to create a random order.
//		Collections.shuffle(myTileNumbers);
//		 
//		myStack.addAll(myTileNumbers);
//		
//		while (myStack.size() > 0) {
//			for (int row = 0; row < NUM_ROWS; row++) {
//				for (int col = 0; col < NUM_COLUMNS; col++) {
//					mySlider[row][col] = myStack.pop();
//				}
//			}
//		}
	}
//	
//	public Tile[][] getSlider() {
//		return mySlider;
//	}
//	
//	/**
//	 * Returns true if this tile can be moved.
//	 * @return true if this tile can be moved.
//	 */
//	public boolean isMoveable() {
//		
//	}
//	public Tile getTile(final int theRow, final int theCol) {
//		
//	}
}
