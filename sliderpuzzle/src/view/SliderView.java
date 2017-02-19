package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SliderView extends JFrame {
    
    /** Auto-generated serial ID. */
	private static final long serialVersionUID = -8956392921759908157L;

	private static final Dimension DEFAULT_SIZE = new Dimension(400, 400);
    
	//private int[][] myButton;
	
    private Dimension myDimension;

    private JPanel myGameBoard;

    
    public SliderView() {
        super("Slider Game");
        setUpMenuBar();
        
    }
    
    public void start() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        myDimension = DEFAULT_SIZE;
        setGUILayout();
        setMinimumSize(myDimension);
        pack();
        setVisible(true);
    }
    
    public void setGUILayout() {
        add(myGameBoard, BorderLayout.CENTER);
        myGameBoard.setLayout(new GridLayout(4, 4));
        
    }
    
    private void addButtons(int[][] theButtonList) {
        for (int r = 0; r < theButtonList.length; r++) {
            for (int c = 0; c < theButtonList[r].length; c++) {
                final JButton tile = new JButton(Integer.toString
                                                 (theButtonList[r][c]));
                myGameBoard.add(tile);
            }
        }
    }


    private void setUpMenuBar()	{
		JPanel menuBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton newGame = new JButton("New");
		menuBar.add(newGame);
		add(menuBar, BorderLayout.NORTH);
	}
}
