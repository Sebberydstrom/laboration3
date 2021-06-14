/*
 * 
 */
package lab3NP.ServerGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * The Class GamePanel.
 */
public class GamePanel extends JPanel implements Observer {

	/** The Constant UNIT_SIZE. */
	private final static int UNIT_SIZE = 5;
	
	/** The model. */
	private GameModel model;
	
	/** The buff. */
	private Buffer buff;
	
	/** The xy C. */
	private XyColor xyC;
	
	/**
	 * Instantiates a new game panel.
	 *
	 * @param model the model
	 */
	public GamePanel(GameModel model) {
		this.model = model;
		model.addObserver(this);
		Dimension d = new Dimension(model.getSize() * UNIT_SIZE + 1, model.getSize() * UNIT_SIZE + 1);
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.repaint();	
	}
	
	/**
	 * Gets the unitsize.
	 *
	 * @return the unitsize
	 */
	public int getUNITSIZE() {
		return UNIT_SIZE;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.buff = model.getBuff();
			
		for(int y = 0; y < model.getSize(); y++) {
			for(int x = 0; x < model.getSize(); x++) {
				g.setColor(Color.black);
				g.drawRect(x * UNIT_SIZE, y * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
				
				if(buff.checkKey(new PairHash(x, y).hashCode())) {
					xyC = (XyColor) buff.get(new PairHash(x, y).hashCode());
					g.setColor(xyC.getSavedColor());
					g.fillRect(xyC.getX()* UNIT_SIZE, xyC.getY()* UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
				}

			}
			this.repaint();
		}
		
		
		if(model.getColor() != null) {
			g.setColor(model.getColor());
			g.fillRect(model.getX() * UNIT_SIZE, model.getY() * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
		}
		
	}
	
	
}
