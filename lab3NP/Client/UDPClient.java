package lab3NP.Client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.*;

public class UDPClient {
	
	private DatagramSocket udpSocket;
	private InetAddress serverAddress;
	private int port, destinationPort;
	private Scanner scanner;
	
	
	//Välja egen port, ServernsIp adress, loopbackaddressen.
	public UDPClient(String destinationAdress, int port, int destinationPort) throws IOException {
		this.destinationPort = destinationPort;
		this.serverAddress = InetAddress.getByName(destinationAdress); //Ipv6 adress.
		this.port = port;
		this.udpSocket = new DatagramSocket(this.port); //Binds socket to the specified port on the localhost machine.
		this.scanner = new Scanner(System.in);

	}
	
	public int start() throws IOException, InterruptedException {
		String in;
		System.out.println("Syntax : (x, y, color)");
		
		while(true) {
			System.out.print("Enter coordinates and color > ");
			in = scanner.nextLine();
			System.out.println(in);
			
				//Skapar paket som ska levereras.
			DatagramPacket p = new DatagramPacket(in.getBytes(), in.getBytes().length, serverAddress, destinationPort);
			udpSocket.send(p);
			
		}
			
			
		}

	
//	public String correctInput(String s) {
//		String format = "%d, %d, %s";
//		String temp = "";
//		
//		for(int i = 0; i < s.length(); i++) {
//			
//		}
//	}
				
}

//OutputStream out = new ByteArrayOutputStream();
//OutputStreamWriter outWriter = new OutputStreamWriter(out);
//outWriter.write(in);
	


