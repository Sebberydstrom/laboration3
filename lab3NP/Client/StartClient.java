package lab3NP.Client;

import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class StartClient {
	
	public static void main(String[] args) throws IOException {
		
		String adress = "::1";
		int port = 6666;
		int destinationP = 7777;
		
		UDPClient c = new UDPClient(adress, port, destinationP);
		System.out.println("-- Running UDP Client at " + InetAddress.getLocalHost() + " --");
		try {
			c.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}
