package lab3NP.ServerGUI;

import java.awt.Window;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.Color;

//behöver nog ej någon Observer.
public class GameView2 implements Observer {

	private final static int DEFAULT_SIZE = 10;
	private GameModel m;
	private GameControl c;
	private GamePanel gameGridPanel;
	private JFrame frame;


	/**
	 * Create the application.
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
					  m.getSize() * gameGridPanel.getUNITSIZE() + 90); // Storlek på fönster
		frame.setVisible(true);
		frame.add(panel);
		
	
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
