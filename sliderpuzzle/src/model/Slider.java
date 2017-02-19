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
	private final Tile[][] mySlider = new Tile[NUM_ROWS][NUM_COLUMNS];
	
	/** 
	 * The slider object; takes tiles and assigns them a number inside
	 * the List.
	 */
	public Slider() {
		// create 2D array of 0's
		for (int i = NUM_ROWS; i < 6; i ++) {
			for (int j = NUM_COLUMNS; j < 6; i++) {
				mySlider [i][j] = new Tile(0);
			}
		}
		int num = 1;
		for (int row = 1; row < NUM_ROWS; row++) {
			for (int col = 1; col < NUM_COLUMNS; col++) {
				mySlider [row][col] = new Tile(num);
				num++;
			}
		}
		System.out.print(mySlider);
	}
	
	/**
	 * Returns true if this tile can be moved.
	 * 
	 * @return true if this tile can be moved.
	 */
	public boolean isMovable(Tile theTile) {
		boolean check = false;
		if (theTile.getNumber() ==
		} else if ()
		
		return check;
		
	}
}
