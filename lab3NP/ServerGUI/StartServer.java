/*
 * 
 */
package ServerGUI;

/**
 * The Class StartServer.
 */
public class StartServer {
	
	/** The port. */
	private static int port = 7123;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		
			//create a new thread for every new server that are to run.
			//depending on input from args.
			UDPServer s = new UDPServer(port);
			GameModel m = new GameModel(s);
			GamePanel g = new GamePanel(m);
			GameView2 w = new GameView2(m);
			
	
		
			
	}
	

}
