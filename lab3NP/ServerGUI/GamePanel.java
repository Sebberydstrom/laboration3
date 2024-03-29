/*
 * 
 */
package ServerGUI;

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
    private final static int UNIT_SIZE = 6;
    
    /** The model. */
    private GameModel model;
    
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
        
        Buffer red = model.getRed();
		Buffer blue = model.getBlue();
		Buffer green = model.getGreen();
		Buffer pink = model.getPink();
		Buffer black = model.getBlack();
		Buffer gray = model.getGray();
		Buffer white = model.getWhite();
		Buffer yellow = model.getYellow();
		XyColor xyC;
			
		for(int y = 0; y < model.getSize(); y++) {
			for(int x = 0; x < model.getSize(); x++) {
				g.setColor(Color.black);
				g.drawRect(x * UNIT_SIZE, y * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
				
				if(red.checkKey(new PairHash(x, y).hashCode())) {
					xyC = (XyColor) red.getLastObject();
					g.setColor(xyC.getSavedColor());
					g.fillRect(xyC.getX()* UNIT_SIZE, xyC.getY()* UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
				}
				if(blue.checkKey(new PairHash(x, y).hashCode())) {
					xyC = (XyColor) blue.getLastObject();
					g.setColor(xyC.getSavedColor());
					g.fillRect(xyC.getX()* UNIT_SIZE, xyC.getY()* UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
				}
				if(green.checkKey(new PairHash(x, y).hashCode())) {
					xyC = (XyColor) green.getLastObject();
					g.setColor(xyC.getSavedColor());
					g.fillRect(xyC.getX()* UNIT_SIZE, xyC.getY()* UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
				}
				if(pink.checkKey(new PairHash(x, y).hashCode())) {
					xyC = (XyColor) pink.getLastObject();
					g.setColor(xyC.getSavedColor());
					g.fillRect(xyC.getX()* UNIT_SIZE, xyC.getY()* UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
				}
				if(gray.checkKey(new PairHash(x, y).hashCode())) {
					xyC = (XyColor) gray.getLastObject();
					g.setColor(xyC.getSavedColor());
					g.fillRect(xyC.getX()* UNIT_SIZE, xyC.getY()* UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
				}
				if(black.checkKey(new PairHash(x, y).hashCode())) {
					xyC = (XyColor) black.getLastObject();
					g.setColor(xyC.getSavedColor());
					g.fillRect(xyC.getX()* UNIT_SIZE, xyC.getY()* UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
				}
				if(white.checkKey(new PairHash(x, y).hashCode())) {
					xyC = (XyColor) white.getLastObject();
					g.setColor(xyC.getSavedColor());
					g.fillRect(xyC.getX()* UNIT_SIZE, xyC.getY()* UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
				}
				if(yellow.checkKey(new PairHash(x, y).hashCode())) {
					xyC = (XyColor) yellow.getLastObject();
					g.setColor(xyC.getSavedColor());
					g.fillRect(xyC.getX()* UNIT_SIZE, xyC.getY()* UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
				}

			}
		}
		 
        g.dispose();
 
        
    }
    
    
}
