package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Slider;
import model.Tile;

public class TestSlider {

	/** The number of rows in the slider. **/
	private static final int NUM_ROWS = 6;
	
	/** The number of columns in the slider. **/
	private static final int NUM_COLUMNS = 6;
	
	/** The number of tiles in the slider. **/
	private static final int NUM_TILES= 16;
	
	@Before
	public void setUpBefore() {
		Tile[][] mySlider = new Tile[NUM_ROWS][NUM_COLUMNS];
	}

	@Test
	public void testSlider() {
		Tile[][] mySlider = new Tile[NUM_ROWS][NUM_COLUMNS];
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
		System.out.println(inversionCount);
		
	}

	@Test
	public void testMove() {

	}

}
