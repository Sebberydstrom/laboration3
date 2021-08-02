/*
 * 
 */
package ServerGUI;

import java.awt.Color;
/**
 * The Class XyColor.
 */
public class XyColor {

	/** The y. */
	private int x, y;
	
	/** The color. */
	private Color color;
	
	/**
	 * Instantiates a new xy color.
	 *
	 * @param x the x
	 * @param y the y
	 * @param color the color
	 */
	public XyColor(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
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
	 * Gets the saved color.
	 *
	 * @return the saved color
	 */
	public Color getSavedColor() {
		return this.color;
	}
	
	
}
