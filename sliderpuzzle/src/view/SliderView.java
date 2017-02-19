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
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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

	/** A default dimension of 400 x 400 for the game board. */
	private static final Dimension DEFAULT_SIZE = new Dimension(512, 512);
	
	/** A vicroty message for winners only. */
	private String myWinMessage = "You solved the puzzle!\nEnter your name so you "
								+ "may be remembered for years to come.";
	
	private File myHighScores = new File("highScoresList.txt");
    

	private Slider mySlider;

    private JPanel myGameBoard;
    
    private Tile[][] myTiles;
    
    private JTextPane counter;
    

    private String[] filenames;


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
        filenames = new String[16];
        for (int i = 1; i < 16; i++)	{
        	filenames[i-1] = "media/" + i + ".gif";
        }
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
	                Image img;
					try {
						img = ImageIO.read(new File(filenames[theButtonList[r][c].getNumber()-1]));
		                tile.setIcon(new ImageIcon(img));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

            	} else	{
            		tile = new JButton();
            		tile.setEnabled(false);
            	}
                
            	
                tile.addActionListener(event -> {
                	mySlider.move(myTiles[row][col]);
                	refreshButtons();
                	
                	// If the puzzle is solved:
                	if (mySlider.isSolved()) {
                		long score = mySlider.getMoves();
                		String winnerName = "";
                		PrintStream ps = null;
                		
                		//get the user name
                		try {
                			winnerName = JOptionPane.showInputDialog(getParent(), 
                					readWinMessage(), "Victory!");
                			ps = new PrintStream("highScoreList.txt");
                		} catch (FileNotFoundException e) {
                			e.printStackTrace();
                		}
                		
                		//write the userName and score to highscore file.
                		ps.println(score + winnerName);
                		
                		//display high scores
                		JOptionPane.showMessageDialog(getParent(), sortHighScoreList());
                	}
                	counter.setVisible(true);
                	counter.setText("Moves: " + Long.toString(mySlider.getMoves()));
                });
                myGameBoard.add(tile);

            }
        }
    }
    
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

    private String readWinMessage() throws FileNotFoundException {
    	String result = "";
    	Scanner s = new Scanner(myWinMessage);
    	
    	for (int i = 0; i < 20; i++) {
    		result += s.nextLine() + "\t"
    				+ s.nextLine() + "\n";
    		
    	}
    	return result;
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
