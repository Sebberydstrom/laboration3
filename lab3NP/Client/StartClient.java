
package Client;

import java.io.IOException;
import java.net.InetAddress;

/**
 * The Class StartClient.
 */
public class StartClient {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		
		String adress = "::1";
		int port = 6666;
		int destinationP = 7123;
		
		UDPClient c = new UDPClient(adress, port, destinationP);
		System.out.println("-- Running UDP Client at " + InetAddress.getLocalHost() + " --");
		try {
			c.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}
