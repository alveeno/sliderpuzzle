
/**
 * 
 */
package control;

import model.Slider;
import model.Tile;
import view.SliderView;

/**
 * @author aashishkumar
 *
 */
public class SliderControl {
	
	private int [][] numbers = new int[4][];
	Slider slider = new Slider();
//	Tile tile = new Tile();
	private int[] tiles;
	
	private boolean hasWon() {
		//if(slider.getSlider().equals(slider)) {
		  
			
		//}
		return false;
		
	}
	
	
	
	private boolean isMove(Slider theButtons) {
		return false;
//		int j = tile.getRow();
//	    int x = (theButtons).getRow();
//		int i = tile.getColumn();
//		int y = (theButtons).getColumn();
//		if((j == x && i+1 == y) || (j == x && i+1 == y) || (j == x && i+1 == y) || (j == x && i+1 == y) ) {
//			return true;
//			
//		}
		
	}
//		private void move() {
//			//if(isMove){
//				
//			}
		
	/**
	  * This check if the puzzle is solved already so it should stop doing it..
	  * @return the program..
	  */
		private boolean isSolve() {
			boolean flag;
			int n = 16;
			for (int i = 0; i< n; i++)
				for (int j = 0; j< n; j++)
					if (numbers[i][j] != numbers[i][j]) {
						flag = false;
			
		}

			return true;
		}
		/**
		 * This check if the program can be solved it..
		 * @return a counter if the program is divisible by 2..
		 */
		private boolean isSolvable () {
		   int counter = 0;
	        int numberTile = 16;
			for (int i = 0; i < numberTile; i++) {
	            for (int j = 0; j < i; j++) {
	                if (tiles[j] > tiles[i])
	                    counter++;
	            
	        }
	        
	    }
			return counter % 2 == 0;

		}
		/**
		 * I am trying to check if the puzzle cant be solved so 
		 * it should shuffle the game to make it possible to solve..
		 * @param theshuffle is good.
		 * @return a new order of program..
		 */
		private Slider isnotSolvable(final Slider theshuffle) {
			if(!isSolvable()) {
				
			}
			return theshuffle;
		}
}
