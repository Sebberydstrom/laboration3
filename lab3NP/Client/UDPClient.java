/*
 * 
 */
package lab3NP.Client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.*;
/**
 * The Class UDPClient.
 */
public class UDPClient {
	
	/** The udp socket. */
	private DatagramSocket udpSocket;
	
	/** The server address. */
	private InetAddress serverAddress;
	
	/** The destination port. */
	private int port, destinationPort;
	
	/** The scanner two. */
	private Scanner scanner, scannerTwo;
	
	/** The file. */
	private File file;
	
	/** The buffer. */
	private BufferedReader buffer;
	
	/** The filename. */
	private String filename = "coordinates.txt";
	
	
	
	/**
	 * Instantiates a new UDP client.
	 *
	 * @param destinationAdress the destination adress
	 * @param port the port
	 * @param destinationPort the destination port
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public UDPClient(String destinationAdress, int port, int destinationPort) throws IOException {
		this.destinationPort = destinationPort;
		this.serverAddress = InetAddress.getByName(destinationAdress); //Ipv6 adress.
		this.port = port;
		this.udpSocket = new DatagramSocket(this.port); //Binds socket to the specified port on the localhost machine.
		this.scanner = new Scanner(System.in);
		
		this.file = new File(filename);
		this.scannerTwo = new Scanner(file);
		
	}
	
	/**
	 * Start.
	 *
	 * @return the int
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public int start() throws IOException, InterruptedException {
		String in;
		System.out.println("Syntax : (x, y, color)");
		
		while(true) {
			System.out.print("Enter coordinates and color > ");
			if(scannerTwo.hasNextLine()) {
				in = scannerTwo.nextLine();
				System.out.println(in);
			} 
			else {
				in = scanner.nextLine();
				System.out.println(in);
			 }
			
				//Skapar paket som ska levereras.
			DatagramPacket p = new DatagramPacket(in.getBytes(), in.getBytes().length, serverAddress, destinationPort);
			udpSocket.send(p);
			
		}
	}	
							
}


	


