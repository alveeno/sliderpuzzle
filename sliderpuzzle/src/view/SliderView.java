package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SliderView extends JFrame {
    
    private static final Dimension DEFAULT_SIZE = new Dimension(400, 400);
    
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
        add(myGameBoard, new BorderLayout().CENTER);
        myGameBoard.setLayout(new GridLayout(4, 4));
        
    }
}
