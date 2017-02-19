package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import model.Slider;
import model.Tile;

/**
 * This is the SliderView class extending JFrame that represent the gui
 * of the Slider game.
 * 
 * @author Duc Nguyen
 * @author Alex Reid
 * @author Alvin Nguyen
 * @author David Glines
 */

public class SliderView extends JFrame {
    
    /** Auto-generated serial ID. */
	private static final long serialVersionUID = -8956392921759908157L;

	/** A default dimension of 400 x 400 for the game board. */
	private static final Dimension DEFAULT_SIZE = new Dimension(512, 512);
    
	//private int[][] myButton;
	private Slider mySlider;

    private JPanel myGameBoard;
    
    private Tile[][] myTiles;
    
    private JTextPane counter;

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
            	final JButton tile;
            	if(theButtonList[r][c].getNumber() != 16)	{
	                tile = new JButton((Integer.toString(theButtonList[r][c].getNumber())));
            	} else	{
            		tile = new JButton();
            		tile.setEnabled(false);
            	}
                
                tile.addActionListener(event -> {
                	mySlider.move(myTiles[row][col]);
                	refreshButtons();
                	counter.setVisible(true);
                	counter.setText("Moves: " + Long.toString(mySlider.getMoves()));
                });
                myGameBoard.add(tile);

            }
        }
    }


    private void setUpMenuBar()	{
		JPanel menuBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton newGame = new JButton("New Game");
		newGame.setFocusable(false);
		newGame.addActionListener(event -> {
            int n = javax.swing.
            JOptionPane.showConfirmDialog(null,
                                          "Do you really want to create a new game?",
                                          "ARE YOU SURE?", JOptionPane.OK_CANCEL_OPTION);
            if (n == JOptionPane.OK_OPTION) {
                setUpSlider();
    			refreshButtons();
            }
		});
		counter = new JTextPane();
		counter.setVisible(false);
		Dimension textSize = new Dimension(60, 20);
		counter.setMinimumSize(textSize);
		menuBar.add(newGame);
		menuBar.add(counter);
		add(menuBar, BorderLayout.NORTH);
	}

	/**
     * Instantiates mySlider.
     */
    private void setUpSlider()	{
    	mySlider = new Slider();
    	while(mySlider.isSolvable())	{
    		mySlider = new Slider();
    	}
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
    	myGameBoard.removeAll();
    	
    }
    
    private void refreshTiles()	{
		myTiles = mySlider.getSlider();
		setCoords();
    }

}
