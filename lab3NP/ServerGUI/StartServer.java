/*
 * 
 */
package lab3NP.ServerGUI;

/**
 * The Class StartServer.
 */
public class StartServer {
	
	/** The port. */
	private static int port = 7777;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		

		//Startar Server och GUI.
		UDPServer s = new UDPServer(port);
		GameModel m = new GameModel(s);
		GamePanel g = new GamePanel(m);
		GameView2 w = new GameView2(m);
		
			
	}
	

}
