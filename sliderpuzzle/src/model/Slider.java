package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a 4x4 slider object which randomized tiles.
 * Each instance of Slider will be randomized.
 * 
 * @author Alvin Nguyen
 * @author David Glines
 * @author Duc Nguyen
 * @author Alex Reid
 *
 */
public class Slider {
	
	/** The number of rows in the slider. **/
	private static final int NUM_ROWS = 6;
	
	/** The number of columns in the slider. **/
	private static final int NUM_COLUMNS = 6;
	
	/** The 2d array of the slider - rows, columns. **/
	private final Tile[][] mySlider = new Tile[NUM_ROWS][NUM_COLUMNS];
	
	/** A counter for each move performed. */
	private long myCounter = 0;
	
	private final Random randy = new Random();
	
	
	/** 
	 * The slider object; takes tiles and assigns them a number inside
	 * the List.
	 * Grab a random number for our tile. We use nextInt to
	 * grab an int between 1 and 17, (by adding 0 to our list initially).
	 * store correct number inside an arraylist to use as comparison for
	 * our number to assign to a tile.
	 * 
	 */
	public Slider() {
		
		myCounter = 0;
		// create 2D array of 0's
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLUMNS; j++) {
				mySlider [i][j] = new Tile(0);
			}
		}
		List<Integer> numR = new ArrayList<>();
		numR.add(0);
		Integer num = randy.nextInt(17);
		
		// fill 2D array with numbers
		for (int row = 1; row < NUM_ROWS-1; row++) {
			for (int col = 1; col < NUM_COLUMNS-1; col++) {
				while (numR.contains(num)) {
					num = randy.nextInt(17);
				}
				numR.add(num);
				mySlider [row][col] = new Tile(num);
			}
		}
	}
	
	/** Returns the move counter */
	public long getMoves() {
		return myCounter;
	}
	
	/**
	 * returns the Slider.
	 * @return the SLider.
	 */
	public Tile[][] getSlider() {
		return mySlider;
	}

	/**
	 * Move the tile.
	 * 
	 * blankTile is an comparison tile for the real blank tile.
	 * the realBlankTile is the real blank tile.
	 * the clickedTile is the tile we clicked.
	 * 
	 * Check to see if the neighboring tiles are legal and equal to 16.
	 * 
	 * @param theTile the tile which we are trying to move.
	 */
	public void move(final Tile theTile) {
		
		Tile blankTile = new Tile(16);
		Tile realBlankTile;
		Tile clickedTile;
		
		final int row = theTile.getRow();
		final int col = theTile.getColumn();
		
		if (mySlider[row][col + 1].equals(blankTile)) {
			
			realBlankTile = mySlider[row][col + 1];
			
			clickedTile = theTile;
			
			mySlider[row][col] = realBlankTile;
			mySlider[row][col + 1] = clickedTile;
			myCounter++;

		} else if (mySlider[row][col - 1].equals(blankTile)) {
			realBlankTile = mySlider[row][col - 1];
			
			clickedTile = theTile;
			
			mySlider[row][col] = realBlankTile;
			mySlider[row][col - 1] = clickedTile;
			myCounter++;

		} else if (mySlider[row + 1][col].equals(blankTile)) {
			realBlankTile = mySlider[row + 1][col];
			
			clickedTile = theTile;
			
			mySlider[row][col] = realBlankTile;
			mySlider[row + 1][col] = clickedTile;
			myCounter++;

		} else if (mySlider[row + 1][col].equals(blankTile)) {
			realBlankTile = mySlider[row + 1][col];
			
			clickedTile = theTile;
			
			mySlider[row][col] = realBlankTile;
			mySlider[row + 1][col] = clickedTile;
			myCounter++;
		} else if (mySlider[row - 1][col].equals(blankTile)) {
			realBlankTile = mySlider[row - 1][col];
			
			clickedTile = theTile;
			
			mySlider[row][col] = realBlankTile;
			mySlider[row - 1][col] = clickedTile;
			myCounter++;
		}
	}
	
	
	
	/**
	 * counts the nusmber of inversions and calculates their sum.
	 * @return the sum of inversions.
	 * 
	 */
	private int sumInversions() {
		
		int inversionCount = 0;
		
		// convert 2D array to regular array.
		int numOfTiles = 16;
		int[] arr = new int [numOfTiles];
		int index = 0;
		for (int row = 1; row < 5; row++) {
			for (int col = 1; col < 5; col++) {
				arr[index] = mySlider[row][col].getNumber();
				index++;
			}
		}
		
		for (int i = 0; i < numOfTiles; i++) {
			for (int j = i + 1; j < numOfTiles; j++) {
				int current = arr[i];
				if (arr[j] < current) {
					inversionCount++;
				}
				
			}
		}
		return inversionCount;
	}
	
	/**
	 * Determine whether the sum of inversions
	 * is an even number. If yes, then puzzle is
	 * solvable.
	 * 
	 * @return whether the puzzle is solvable.
	 */
	public boolean isSolvable() {
		return sumInversions() % 2 == 0;
	}
	
	/**
	 * determine if the puzzle has been solved.
	 * (If the sum of all the inversions is 0, 
	 *  then the puzzle has been solved)
	 *  
	 *  @return true if the puzzle has been solved.
	 */
	public boolean isSolved() {
		return sumInversions() == 0;
	}
}
