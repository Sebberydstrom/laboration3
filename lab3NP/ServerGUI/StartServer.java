package lab3NP.ServerGUI;

import java.awt.Color;
import java.io.IOException;
import java.net.SocketException;

public class StartServer {
	
	private static int port = 7777;
	
	public static void main(String[] args) throws Exception {
		

		//skapar programmet.
		//UDPServer s = new UDPServer(port);
		//GameModel m = new GameModel(s);
		//GameView2 w = new GameView2(m);
		//new GameControl();
		//Startar server.
		//s.listen();
		UDPServer s = new UDPServer(port);
		GameModel m = new GameModel(s);
		GamePanel g = new GamePanel(m);
		GameView2 w = new GameView2(m);
		s.run();
		
		
		
		
	}
	

}
