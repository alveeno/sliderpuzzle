package model;

/**
 * Represents an individual tile on the Slider Puzzle.
 * 
 * @author David Glines
 */
public class Tile {
	

	/** The number on the tile. */
	private int myNumber;
	
	/** The row of the Tile. */
	private int myRow;
	
	/** The column of the Tile. */
	private int myColumn;
	
//	/**
//	 * Constructs a Tile with its number passed as a parameter.
//	 * 
//	 * @param theNumber is the number of the tile.
//	 */
//	public Tile(final int theNumber) {
//		myNumber = theNumber;
//	}

	/**
	 * Returns the number of the Tile.
	 * @return the number of the Tile.
	 */
	public int getNumber() {
		return myNumber;
	}
	
	/**
	 * Returns the row of the Tile.
	 * @return the row of the Tile.
	 */
	public int getRow() {
		return myRow;
	}
	
	/**
	 * Returns the row of the Tile.
	 * @return the row of the Tile.
	 */
	public int getColumn() {
		return myColumn;
	}
	
	/**
	 * Sets the row of the Tile.
	 * @param theRow is the Row to set the Tile to.
	 */
	public void setRow(final int theRow) {
		myRow = theRow;
	}
	
	/**
	 * Sets the row of the Tile. 
	 * @param theColumn is the Column to set the Tile to.
	 */
	protected void setColumn(final int theColumn) {
		myColumn = theColumn;
	}
	
	/**
	 * Sets the Number of the Tile.
	 * @param theNumber is the Number to change the Tile number to.
	 */
	protected void setNumber(final int theNumber) {
		myNumber = theNumber;
	}
	
}
