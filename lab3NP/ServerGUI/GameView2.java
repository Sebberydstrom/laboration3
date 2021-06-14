/*
 * 
 */
package lab3NP.ServerGUI;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The Class GameView2.
 */

public class GameView2 {

	/** The Constant DEFAULT_SIZE. */
	private final static int DEFAULT_SIZE = 10;
	
	/** The m. */
	private GameModel m;
	
	/** The game grid panel. */
	private GamePanel gameGridPanel;
	
	/** The frame. */
	private JFrame frame;


	/**
	 * Create the application.
	 *
	 * @param m the m
	 */
	public GameView2(GameModel m) {
		this.m = m;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//skapar spelbräde och gör den synlig
		gameGridPanel = new GamePanel(m);
		gameGridPanel.setVisible(true);
		
		Box gameGrid = Box.createHorizontalBox();
		gameGrid.add(gameGridPanel);
		
		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		panel.add(gameGrid);
		
		JFrame frame = new JFrame("Coordinate Grid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(m.getSize() * gameGridPanel.getUNITSIZE() + 30,
					  m.getSize() * gameGridPanel.getUNITSIZE() + 30); // Storlek på fönster
		frame.setVisible(true);
		frame.add(panel);
		
	
	}


}
