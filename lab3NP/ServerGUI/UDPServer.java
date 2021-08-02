package ServerGUI;

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


/**
 * The Class UDPServer. Takes care of the communication with the client.
 * 
 * @author Sebastian Rydström
 * @date 2020-09-24
 */
public class UDPServer extends Observable implements Runnable {
	
	/** The udp socket. */
	private DatagramSocket udpSocket;
	
	/** The port. */
	private int port;
	
	/** The b. */
	private byte[] b;
	
	/** The Color. */
	private String X, Y, Color;
	
	/**
	 * Instantiates a new UDP server.
	 *
	 * @param port the port
	 * @throws SocketException the socket exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public UDPServer(int port) throws SocketException, IOException {
		this.port = port;
		this.udpSocket = new DatagramSocket(this.port); //server binds to the specified port number.s
		Thread t = new Thread(this);
		t.start();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			System.out.println("--Running server at " + InetAddress.getLocalHost()+ "--");
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
	
		
		while(true) {
			try {
				 byte[] buf = new byte[32]; // är 16 st bytes.
				 DatagramPacket packet = new DatagramPacket(buf, buf.length);  //datagrampacket to be received.
			
				 //blocks until a packet is received. - packet exist of a number of bytes/bytearray.
				 udpSocket.receive(packet);
				 System.out.println("loopar i UDPServer\n");
				 BufferedInputStream buffer = null;
				 buffer = new BufferedInputStream( new ByteArrayInputStream(packet.getData()) );
				
				 b = buffer.readAllBytes();
				 setData(b);
				 
				 //Anropa model och exekvera det som behövs där.
				 setChanged(); 		//call update i Model.
				 notifyObservers();
				 
			} catch (IOException e) {
				e.printStackTrace();
			  } 
			
		
			//System.out.println(message);
			
			
		} 
	}
	
	
	/**
	 * Sets the data.
	 *
	 * @param b the new data
	 */
	public void setData(byte[] b) {
		
		String X = "";
		Integer realValue;
		for(int i = 0; i < b.length; i++) {
			
			if(b[i] >= 48 && b[i] <= 57) {
				realValue = Character.getNumericValue( (int) b[i] );
				X = X + Integer.toString(realValue); //-- x koordinat som sträng.
			}
			
			else if(b[i] == 44) {
				setY(i + 1, b);
				break;
			}	
		}
		this.X = X;
		System.out.println(X);
	}
	
	
	/**
	 * Sets the Y.
	 *
	 * @param i the i
	 * @param b the b
	 */
	public void setY(int i, byte[] b) {
		
		String Y = "";
		Integer realValue;
		for(int j = i; j < b.length; j++) {
			
			if(b[j] >= 48 && b[j] <= 57) {
				realValue = Character.getNumericValue( (int) b[j] );
				Y = Y + Integer.toString(realValue); //-- x koordinat som sträng.
			}
			
			else if(b[j] == 44) {
				setColor(j + 1, b);
				break;
			}	
		}
		this.Y = Y;
		System.out.println(Y);
	}
	
	
	/**
	 * Sets the color.
	 *
	 * @param j the j
	 * @param b the b
	 */
	public void setColor(int j, byte[] b) {
		
		String Color = "";
		for(int k = j; k < b.length; k++) {
			
			if(b[k] >= 97 && b[k] <= 122) {
				Color = Color + Character.toString( (int) b[k] );
			}		
		}
		this.Color = Color;
		System.out.println(Color);
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	//returns the data with coordinates and color.
	public String getX() {
		return this.X;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public String getY() {
		return this.Y;
	}
	
	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public String getColor() {
		return this.Color;
	}
	
}


