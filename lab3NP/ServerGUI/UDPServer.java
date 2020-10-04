package lab3NP.ServerGUI;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Observable;

//Göra denna observable.
public class UDPServer extends Observable implements Runnable {
	
	private DatagramSocket udpSocket;
	private int port;
	private String message; //Datat från klienten sparas här.
	
	public UDPServer(int port) throws SocketException, IOException {
		this.port = port;
		this.udpSocket = new DatagramSocket(this.port); //server binds to the specified port number.s
	}
	
	public void run() {
		try {
			System.out.println("--Running server at " + InetAddress.getLocalHost()+ "--");
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
	
		
		while(true) {
			try {
				 byte[] buf = new byte[256]; // Storlek är 256 st bytes = 256 tecken.
				 DatagramPacket packet = new DatagramPacket(buf, buf.length);  //datagrampacket to be received.
			
				 //blocks until a packet is received.
				 udpSocket.receive(packet);
			
				 BufferedInputStream buffer = null;
				 buffer = new BufferedInputStream( new ByteArrayInputStream(packet.getData()) );
			
				 BufferedReader bufferReader = null;
				 bufferReader = new BufferedReader( new InputStreamReader(buffer) );
		
			
				 this.message = bufferReader.readLine();
				 setChanged(); 		//call update i Model.
				 notifyObservers();
				 
			} catch (IOException e) {
				e.printStackTrace();
			  } 
			
		
			System.out.println(message);
			
			
		} 
	}
	
	//returns the data with coordinates and color.
	public String getData() {
		return this.message;
	}

}


//this.message = new String(packet.getData()).trim();
//System.out.println(message);
