package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Slider;
import model.Tile;

/**
 * This is the SliderView class extending JFrame that represent the gui
 * of the Slider game.
 * 
 * @author Duc Nguyen
 * @author Alex Reid
 */

public class SliderView extends JFrame {
    
    /** Auto-generated serial ID. */
	private static final long serialVersionUID = -8956392921759908157L;

	/** A default dimension of 400 x 400 for the game board. */
	private static final Dimension DEFAULT_SIZE = new Dimension(400, 400);
    
	//private int[][] myButton;
	private Slider mySlider;

    private JPanel myGameBoard;
    
    private Tile[][] myTiles;


    /**
     * This is the constructor for the SliderView that set up the menu
     * bar.
     */
    public SliderView() {
        super("Slider Game");
        myGameBoard = new JPanel();
        setUpSlider();
        setUpMenuBar(); 
        myTiles = mySlider.getSlider();
    }
    
    /**
     * This is the start method that set the layout for the gui.
     */
    public void start() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setMinimumSize(DEFAULT_SIZE);
        setGUILayout();
        pack();
        setVisible(true);
    }
    
    public void setGUILayout() {
        add(myGameBoard, BorderLayout.CENTER);
        myGameBoard.setLayout(new GridLayout(4, 4));
        addButtons(mySlider.getSlider()); 
    }
    
    private void addButtons(Tile[][] theButtonList) {
    	refreshTiles();
        for (int r = 1; r < 5; r++) {
            for (int c = 1; c < 5; c++) {
            	final int row = r;
            	final int col = c;
            	System.out.println("Adding new JButton ("+theButtonList[r][c].getNumber()+")");
                final JButton tile = new JButton((Integer.
                                toString(theButtonList[r][c].getNumber())));
                
                tile.addActionListener(event -> {
                	System.out.println("Row: " + myTiles[row][col].getRow());
                	System.out.println("Column: " + myTiles[row][col].getColumn());

                	mySlider.move(myTiles[row][col]);
                	refreshButtons();
                });
//                final JButton tile = new JButton(Integer.toString
//                                                 (theButtonList[r][c]));
                myGameBoard.add(tile);
            }
        }
    }


    private void setUpMenuBar()	{
		JPanel menuBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton newGame = new JButton("New Game");
		newGame.addActionListener(event -> {
//			System.out.println("New Game button pressed.");
//			mySlider.shuffle();
			refreshButtons();
		});
		menuBar.add(newGame);
		add(menuBar, BorderLayout.NORTH);
	}
    
    /**
     * Instantiates mySlider.
     */
    private void setUpSlider()	{
    	mySlider = new Slider();
    }
    
    private void refreshButtons()	{
		removeButtons();
		refreshTiles();
		addButtons(myTiles);
		revalidate();
    }
    private void setCoords()	{
    	for (int r = 1; r <= 4; r++)	{
    		for (int c = 1; c <= 4; c++)	{
    			myTiles[r][c].setColumn(c);
    			myTiles[r][c].setRow(r);
    		}
    	}
    }
    
    private void removeButtons()	{
    	System.out.println("Removing all buttons");
    	myGameBoard.removeAll();
    	
    }
    
    private void refreshTiles()	{
		myTiles = mySlider.getSlider();
		setCoords();
    }

}
