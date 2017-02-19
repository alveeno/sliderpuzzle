package model;

/**
 * Represents an individual tile on the Slider Puzzle.
 * 
 * @author David
 * @author Alvin
 *
 */
public class Tile {

	/** The number on the tile. */
	private int myNumber;
	
	/** The row of the Tile. */
	private int myRow;
	
	/** The column of the Tile. */
	private int myColumn;
	
	/**
	 * Constructs a Tile with its number passed as a parameter.
	 * 
	 * @param theNumber is the number of the tile.
	 */
	public Tile(final int theNumber) {
		myNumber = theNumber;
	}
	
	
}
