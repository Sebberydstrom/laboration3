/*
 * 
 */
package lab3NP.ServerGUI;

import java.util.Observable;
import java.util.Observer;
import java.awt.Color;

/**
 * The Class GameModel.
 */
public class GameModel extends Observable implements Observer {

	/** The s. */
	private UDPServer s;
	
	/** The Constant SIZE. */
	private final static int SIZE = 201;
	
	/** The buff. */
	private Buffer buff;
	
	/** The in color. */
	private String indata, inColor; // --(x, y, color)
	
	/** The xycolor. */
	private XyColor xycolor;
	
	/** The y. */
	private int x, y;

	
	/**
	 * Instantiates a new game model.
	 *
	 * @param s the s
	 */
	public GameModel(UDPServer s) {
		this.s = s;
		this.s.addObserver(this);
		this.buff = new Buffer();
		//this.board = new int[SIZE][SIZE];
		
	}
	
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public Color getColor() {
	
		
		if(this.inColor != null) {
			
			switch(this.inColor) {
			
			case "red":
				return Color.red;
				
			
			case "blue":
				return Color.blue;
				
			
			case "green":
				return Color.green;
				
			
			case "pink":
				return Color.pink;
				
			
			case "black":
				return Color.black;
				
			
			case "gray":
				return Color.gray;
				
			
			case "white":
				return Color.white;
				
			case "yellow":
				return Color.yellow;
				
			
			default:
				System.out.println("Wrong color");
				return null;
			}
		} else {
			return null;
		}
 	
	}
	
	/**
	 * Save indata.
	 */
	public void saveIndata() {
		if(!this.buff.checkKey(new PairHash(x, y).hashCode())) {
			this.buff.put(new PairHash(x, y).hashCode(), new XyColor(x, y, this.getColor()));
			
		}
	}
	
	/**
	 * Gets the buff.
	 *
	 * @return the buff
	 */
	public Buffer getBuff() {
		return this.buff;
	}
	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return SIZE;
	}
		

	//behandlar inkommande data, dvs : (x, y, color)
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.x = Integer.valueOf(s.getX());
		this.y = Integer.valueOf(s.getY());
		this.inColor = s.getColor();
		this.saveIndata();
		
		setChanged();			    //call update i GamePanel/GUI.
		notifyObservers();
		
	}
	

	
	
}
