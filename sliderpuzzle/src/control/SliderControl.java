
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
	
	private int [][] numbers = new int[4][4];
	Slider slider = new Slider();
	Tile tile = new Tile();
	
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
		
			private boolean isSolve() {
				
				int n = 16;
				for (int i = 0; i< n; i++)
					for (int j = 0; j< n; j++)
						if (numbers[i][j] != numbers[i][j]) {
							return false;
				
			}

				return true;
			}
}
	
