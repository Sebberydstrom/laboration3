/*
 * 
 */
package ServerGUI;

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
	
	/** The buffer which stores the data for the different players
	 *  identified by the color.*/
	private Buffer buffRed, buffBlue, buffGreen, buffPink, buffBlack, buffGray, buffWhite, buffYellow;
	
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
		this.buffRed = new Buffer();
		this.buffBlue = new Buffer();
		this.buffGreen = new Buffer();
		this.buffPink = new Buffer();
		this.buffBlack = new Buffer();
		this.buffGray = new Buffer();
		this.buffWhite = new Buffer();
		this.buffYellow = new Buffer();
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
		//Checkt to see if the color is ok format.
		System.out.println(this.inColor);
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
	 * Save indata. Each player has a separate buffer.
	 */
	public void saveIndata() {
		if (this.getColor() == Color.red) {
			if(!this.buffRed.checkKey(new PairHash(x, y).hashCode())) {
				this.buffRed.put(new PairHash(x, y).hashCode(), new XyColor(x, y, this.getColor()));
			}
		}
		if (this.getColor() == Color.blue) {
			if(!this.buffBlue.checkKey(new PairHash(x, y).hashCode())) {
				this.buffBlue.put(new PairHash(x, y).hashCode(), new XyColor(x, y, this.getColor()));
			}
		}
		if (this.getColor() == Color.green) {
			if(!this.buffGreen.checkKey(new PairHash(x, y).hashCode())) {
				this.buffGreen.put(new PairHash(x, y).hashCode(), new XyColor(x, y, this.getColor()));
			}
		}
		if (this.getColor() == Color.pink) {
			if(!this.buffPink.checkKey(new PairHash(x, y).hashCode())) {
				this.buffPink.put(new PairHash(x, y).hashCode(), new XyColor(x, y, this.getColor()));
			}
		}
		if (this.getColor() == Color.black) {
			if(!this.buffBlack.checkKey(new PairHash(x, y).hashCode())) {
				this.buffBlack.put(new PairHash(x, y).hashCode(), new XyColor(x, y, this.getColor()));
			}
		}
		if (this.getColor() == Color.gray) {
			if(!this.buffGray.checkKey(new PairHash(x, y).hashCode())) {
				this.buffGray.put(new PairHash(x, y).hashCode(), new XyColor(x, y, this.getColor()));
			}
		}
		if (this.getColor() == Color.white) {
			if(!this.buffWhite.checkKey(new PairHash(x, y).hashCode())) {
				this.buffWhite.put(new PairHash(x, y).hashCode(), new XyColor(x, y, this.getColor()));
			}
		}
		if (this.getColor() == Color.yellow) {
			if(!this.buffYellow.checkKey(new PairHash(x, y).hashCode())) {
				this.buffYellow.put(new PairHash(x, y).hashCode(), new XyColor(x, y, this.getColor()));
			}
		}
	}
	
	
	public Buffer getRed() {
		return this.buffRed;
	}
	
	public Buffer getBlue() {
		return this.buffBlue;
	}
	
	public Buffer getGreen() {
		return this.buffGreen;
	}
	
	public Buffer getPink() {
		return this.buffPink;
	}
	
	public Buffer getBlack() {
		return this.buffBlack;
	}
	
	public Buffer getGray() {
		return this.buffGray;
	}
	
	public Buffer getWhite() {
		return this.buffWhite;
	}
	
	public Buffer getYellow() {
		return this.buffYellow;
	}
	/**
	 * Gets the buff.
	 *
	 * @return the buff
	 */
	/*public Buffer getBuff() {
		return this.buff;
	}
	/
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
