package lab3NP.ServerGUI;

import java.util.Observable;
import java.util.Observer;
import java.awt.Color;

//Observerar UDPServer
public class GameModel extends Observable implements Observer {

	private UDPServer s;
	private final static int SIZE = 201;
	private Buffer buff;
	private String indata, inColor; // --(x, y, color)
	private XyColor xycolor;
	private int x, y;

	
	
	//allt nedanför gammalt.
	//private final static int ME = 1;
	//private int[][] board;
	
	
	public GameModel(UDPServer s) {
		this.s = s;
		this.s.addObserver(this);
		this.buff = new Buffer();
		//this.board = new int[SIZE][SIZE];
		
	}
	
//	public GameModel() {
//		this.buff = new Buffer();
//		this.indata = "3, 5, red";
//		this.setIndata();
		//this.board = new int[SIZE][SIZE];
	
//	}
	
	public void setIndata() {
		
		String x = this.indata.substring(0, 1);
		String y = this.indata.substring(3, 4);
		this.inColor = this.indata.substring(6);
		this.x = Integer.valueOf(x);
		this.y = Integer.valueOf(y);
		this.saveIndata();
		setChanged();			    //call update i Model.
		notifyObservers();
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Color getColor() {
		System.out.println(inColor);
		switch(inColor) {
		
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
				
			
			default:
				System.out.println("Wrong color");
				return null;
		}
	}
	
	public void saveIndata() {
		if(buff.checkKey(new PairHash(x, y))) {
			buff.put(new PairHash(x, y), new XyColor(x, y, inColor));
		}
	}
	
	public int getSize() {
		return SIZE;
	}
	
	//allt nedanför gammalkod.
	
//	public void setPosition(int x, int y) {
//		board[x][y] = ME;
//	}
//	
//	public int getPosition(int x, int y) {
//		return board[x][y];
//	}
//	
//	public int getSize() {
//		return SIZE;
//	}
	

	//behandlar inkommande data, dvs : (x, y, color)
	
	@Override
	public void update(Observable o, Object arg) {
		this.indata = s.getData();
		this.setIndata();
		
	}
	
	
}
