package lab3NP.ServerGUI;

import java.awt.Color;

public class XyColor {

	private int x, y;
	private String color;
	
	public XyColor(int x, int y, String color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String getNameColor() {
		return this.color;
	}
	
	
}
