package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import model.Slider;
import model.Tile;
import model.Winner;

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

	/** A default dimension of 512 x 512 for the game board. */
	private static final Dimension DEFAULT_SIZE = new Dimension(512, 512);
	
	/** A victory message for winners only, if high scores are enabled. */
	private String myWinMessage = "You solved the puzzle!\nEnter your name so you "
								+ "may be remembered for years to come.";
	
	/** Text file used to hold all the high scores for this game, if enabled. */
	private File myHighScores = new File("media/highScoresList.txt");
    
	/** Slider class handles most of the logic in our game. */
	private Slider mySlider;

	/** This JPanel contains all our image buttons. */
    private JPanel myGameBoard;
    
    /** Tiles contain the value for each button, as well as its row and column. */
    private Tile[][] myTiles;
    
    /** This JTextPane will update with our total moves while we play. */
    private JTextPane counter;
    
    /** This String array will contain all the image urls for our buttons. */
    private String[] filenames;


    /**
     * The constructor for this class sets up part of our JFrame and fills all of our
     * above fields.
     */
    public SliderView() {
        super("Slider Game");
        myGameBoard = new JPanel();
        mySlider = new Slider();
        setUpMenuBar(); 
        myTiles = mySlider.getSlider();
        filenames = new String[16];
        for (int i = 1; i < 16; i++)	{
        	filenames[i-1] = "media/" + i + ".gif";
        }
        Image icon;
		try {
			icon = ImageIO.read(new File("media/t-mobile.png"));
	        setIconImage(icon);
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println("Failed to load JFrame icon.");
		}

    }
    
    /**
     * start() finishes setting up our GUI and adds ActionListeners to all our buttons.
     */
    public void start() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setMinimumSize(DEFAULT_SIZE);
        setGUILayout();
        pack();
        setVisible(true);
    }
    
    /**
     * This method sets up the grid containing all our image buttons.
     */
    public void setGUILayout() {

        add(myGameBoard, BorderLayout.CENTER);
        myGameBoard.setLayout(new GridLayout(4, 4));
        addButtons(mySlider.getSlider()); 
    }
    
    /**
     * This method adds all the image buttons needed for the game.
     * @param theButtonList - 2D Tile array containing all the locations of our values.
     */
    private void addButtons(Tile[][] theButtonList) {
    	refreshTiles();
        for (int r = 1; r < 5; r++) {
            for (int c = 1; c < 5; c++) {
            	final int row = r;
            	final int col = c;
            	final JButton tile;
            	if(theButtonList[r][c].getNumber() != 16)	{
	                tile = new JButton();
	                Image img;
					try {
						img = ImageIO.read(new File(filenames[theButtonList[r][c].getNumber()-1]));
		                tile.setIcon(new ImageIcon(img));
					} catch (IOException e) {
						//e.printStackTrace();
						System.err.println("Failed to load image.  Using number instead.");
						tile.setText(Integer.toString(theButtonList[r][c].getNumber()));
					}

            	} else	{
            		tile = new JButton();
            		tile.setEnabled(false);
            	}
            	
            	// Adding our ActionListeners!
                tile.addActionListener(event -> {
                	mySlider.move(myTiles[row][col]);
                	refreshButtons();
                	
                	// If the puzzle is solved:
                	if (mySlider.isSolved()) {
                        int n = javax.swing.JOptionPane.showConfirmDialog(null,
                                                              "Well done!  Would you like to play again?",
                                                              "Winner!", JOptionPane.OK_CANCEL_OPTION);
                                if (n == JOptionPane.OK_OPTION) {
                                    setUpSlider();
                        			refreshButtons();
                        			counter.setText("Moves: " + Long.toString(mySlider.getMoves()));
                        			counter.setVisible(false);
                                }
                                
//						 Code that needs fixing!!!!
//                		long score = mySlider.getMoves();
//                		String winnerName = "";
//                		PrintStream ps = null;
//                		
//                		//get the user name
//                		try {
//                			winnerName = JOptionPane.showInputDialog(getParent(), 
//                					readWinMessage(), "Victory!");
//                			ps = new PrintStream("media/highScoreList.txt");
//                		} catch (FileNotFoundException e) {
//                			e.printStackTrace();
//                		}
//                		//write the userName and score to highscore file.
//                		ps.println(score + winnerName);
//                		
//                		//display high scores
//                		JOptionPane.showMessageDialog(getParent(), sortHighScoreList());
                	}
                	counter.setVisible(true);
                	counter.setText("Moves: " + Long.toString(mySlider.getMoves()));
                });
                myGameBoard.add(tile);
            }
        }
    }
    
    /**
     * This method sorts our high score list. (UNFINISHED)
     * @return String
     */
    private String sortHighScoreList() {
    	String result = "";
    	
    	Scanner readScores = null;
    	String winnerName = "";
    	Integer score;
    	try {
			readScores = new Scanner(myHighScores);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//create a list to hold and sort high scores
    	List<Winner> winnersCircle = new ArrayList<Winner>();
    	
    	while (readScores.hasNextLine()) {
    		
    		winnerName = readScores.nextLine();
    		score = readScores.nextInt();
    		
    		winnersCircle.add(new Winner(winnerName, score));
    		
    	}
    	
    	// Sort winners by score and print top 10
    	Collections.sort(winnersCircle);
    	for (int i = 0; i < 10; i++) {
    		result += winnersCircle.get(i).toString() + "\n";
    	}
    	
    	return result;
    }
    
    /**
     * This method displays the victory message! (UNFINISHED)
     * @return String
     * @throws FileNotFoundException
     */
    private String readWinMessage() throws FileNotFoundException {
    	String result = myWinMessage;
//    	String result = "";
//    	Scanner s = new Scanner(myWinMessage);
    	
//    	for (int i = 0; i < 20; i++) {
//    		result += s.nextLine() + "\t"
//    				+ s.nextLine() + "\n";
//    		
//    	}
    	return result;
    }

    /**
     * This method sets up our menu bar that contains our New Game button and our counter.
     */
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
    			counter.setText("Moves: " + Long.toString(mySlider.getMoves()));
    			counter.setVisible(false);
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
     * This method creates a new instance of Slider and checks if it is solvable. If not,
     * it will instantiate Slider until it is solvable.
     */
    private void setUpSlider()	{
    	mySlider = new Slider();
    	mySlider.shuffle();
    	while(!mySlider.isSolvable())	{
    		mySlider.shuffle();
    	}
    }

	/**
	 * This method updates our GUI.
	 */
    private void refreshButtons()	{
		removeButtons();
		refreshTiles();
		addButtons(myTiles);
		revalidate();
    }
    
    /**
     * This method sets the coords of our Tiles based on their location in our 2D array.
     */
    private void setCoords()	{
    	for (int r = 1; r <= 4; r++)	{
    		for (int c = 1; c <= 4; c++)	{
    			myTiles[r][c].setColumn(c);
    			myTiles[r][c].setRow(r);
    		}
    	}
    }
    
    /**
     * Clears our grid.
     */
    private void removeButtons()	{
    	myGameBoard.removeAll();
    	
    }

    /**
     * Updates our Tile array
     */
    private void refreshTiles()	{
		myTiles = mySlider.getSlider();
		setCoords();
    }

}
