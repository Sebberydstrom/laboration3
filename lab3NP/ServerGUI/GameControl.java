package lab3NP.ServerGUI;


public class GameControl {

	private final static int DEFAULT_SIZE = 201;
	private GameModel gameGrid;
	
	public GameControl() {
		gameGrid = new GameModel(DEFAULT_SIZE);
	}
	
	public int getDEFAULTSIZE() {
		return DEFAULT_SIZE;
	}
	
	public GameGrid getGameGrid() {
		return gameGrid;
	}
}
