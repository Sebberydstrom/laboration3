package lab3NP.ServerGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Observer {

	private final static int UNIT_SIZE = 8;
	private GameModel model;
	
	public GamePanel(GameModel model) {
		this.model = model;
		model.addObserver(this);
		Dimension d = new Dimension(model.getSize() * UNIT_SIZE + 1, model.getSize() * UNIT_SIZE + 1);
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		this.repaint();	
	}
	
	//övriga metoder här emellan om det behövs senare
	public int getUNITSIZE() {
		return UNIT_SIZE;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
			
		for(int y = 0; y < model.getSize(); y++) {
			for(int x = 0; x < model.getSize(); x++) {
				g.setColor(Color.black);
				g.drawRect(x * UNIT_SIZE, y * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);		

			}
			this.repaint();
		}
		
		if(model.getColor() != null) {
			g.setColor(model.getColor());
			g.fillRect(model.getX() * UNIT_SIZE, model.getY() * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
		}
		
	}
	
	
}
