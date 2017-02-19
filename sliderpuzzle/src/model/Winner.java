package model;

/**
* A class which represents a winner. Implements comparable for compareTo() usage.
* @author David Glines
*/
public class Winner implements Comparable<Winner>{
	
	private String myName;
	
	private int myScore;
	
	
	public Winner(final String theName, final int theScore) {
		myName = theName;
		myScore = theScore;
	}


	public int compareTo(final Winner theOther) {
		
		return myScore - theOther.myScore;
	}

	
	
}
