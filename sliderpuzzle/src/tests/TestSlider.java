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
	
	/** The 2d array of the slider - rows, columns. **/
	private final Tile[][] mySlider = new Tile[NUM_ROWS][NUM_COLUMNS];
	
	@Before
	public void setUpBefore() {
		Slider slider = new Slider();
	}

	@Test
	public void testSlider() {
		for (int i = NUM_ROWS; i < 6; i ++) {
			for (int j = NUM_COLUMNS; j < 6; i++) {
				mySlider [i][j] = new Tile(0);
				assertTrue("Not equal to zero!", mySlider [i][j].getNumber() == 0);
			}
		}
		int num = 1;
		for (int row = 1; row < NUM_ROWS; row++) {
			for (int col = 1; col < NUM_COLUMNS; col++) {
				mySlider [row][col] = new Tile(num);
				assertTrue("Not equal to num!", mySlider [row][col].getNumber() == num);
				num++;
			}
		}
	}

	@Test
	public void testMove() {

	}

}
