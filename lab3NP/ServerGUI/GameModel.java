/*
 * 
 */
package ServerGUI;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.awt.Color;

/**
 * The Class GameModel.
 */
public class GameModel extends Observable implements Observer {

    /** The s. */
    private UDPServer s;
    
    /** The Constant SIZE. */
    private final static int SIZE = 201;
    private Buffer buffRed, buffBlue, buffGreen, buffPink, buffBlack, buffGray, buffWhite, buffYellow;
    
    /** The buffer which stores the data for the different players
     *  identified by the color.*/
    private ConcurrentHashMap<Color, XyColor> grid = new ConcurrentHashMap<Color, XyColor>();
    
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
    }
    
    /**
     * Gets the size.
     *
     * @return the size
     */
    public int getSize() {
        return SIZE;
    }

    /**
     * 
     *
     * @return 
     */
   // public ConcurrentHashMap<Color, XyColor> getGrid() {
    //    return grid;
   // }
    
	public void saveIndata(XyColor item) {
		int x = item.getX();
		int y = item.getY();
		if(item.getSavedColor() == Color.white) {
			
			if(this.buffRed.checkKey(new PairHash(x, y).hashCode())) {
				this.buffRed.remove(new PairHash(x, y).hashCode());
			}
			if(this.buffBlue.checkKey(new PairHash(x, y).hashCode())) {
				this.buffBlue.remove(new PairHash(x, y).hashCode());
			}
			if(this.buffGreen.checkKey(new PairHash(x, y).hashCode())) {
				this.buffGreen.remove(new PairHash(x, y).hashCode());
			}
			if(this.buffPink.checkKey(new PairHash(x, y).hashCode())) {
				this.buffPink.remove(new PairHash(x, y).hashCode());
			}
			if(this.buffBlack.checkKey(new PairHash(x, y).hashCode())) {
				this.buffBlack.remove(new PairHash(x, y).hashCode());
			}
			if(this.buffGray.checkKey(new PairHash(x, y).hashCode())) {
				this.buffGray.remove(new PairHash(x, y).hashCode());
			}
			if(this.buffYellow.checkKey(new PairHash(x, y).hashCode())) {
				this.buffYellow.remove(new PairHash(x, y).hashCode());
			}
		}
		
		else if (item.getSavedColor() == Color.red) {
			if(!this.buffRed.checkKey(new PairHash(x, y).hashCode())) {
				this.buffRed.put(new PairHash(x, y).hashCode(), item);
			}
		}
		else if (item.getSavedColor() == Color.blue) {
			if(!this.buffBlue.checkKey(new PairHash(x, y).hashCode())) {
				this.buffBlue.put(new PairHash(x, y).hashCode(), item);
			}
		}
		else if (item.getSavedColor() == Color.green) {
			if(!this.buffGreen.checkKey(new PairHash(x, y).hashCode())) {
				this.buffGreen.put(new PairHash(x, y).hashCode(), item);
			}
		}
		else if (item.getSavedColor() == Color.pink) {
			if(!this.buffPink.checkKey(new PairHash(x, y).hashCode())) {
				this.buffPink.put(new PairHash(x, y).hashCode(), item);
			}
		}
		else if (item.getSavedColor() == Color.black) {
			if(!this.buffBlack.checkKey(new PairHash(x, y).hashCode())) {
				this.buffBlack.put(new PairHash(x, y).hashCode(), item);
			}
		}
		else if (item.getSavedColor() == Color.gray) {
			if(!this.buffGray.checkKey(new PairHash(x, y).hashCode())) {
				this.buffGray.put(new PairHash(x, y).hashCode(), item);
			}
		}

		else if (item.getSavedColor() == Color.yellow) {
			if(!this.buffYellow.checkKey(new PairHash(x, y).hashCode())) {
				this.buffYellow.put(new PairHash(x, y).hashCode(), item);
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
    
    /* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable o, Object arg) {
        XyColor c = (XyColor)arg;
        saveIndata(c);
        
        //grid.put(c.getSavedColor(), c);
        
        setChanged();                //call update i GamePanel/GUI.
        notifyObservers();
    }
}
	

	
	

