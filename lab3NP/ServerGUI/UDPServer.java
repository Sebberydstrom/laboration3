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
import java.awt.Color;


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
                byte[] buf = new byte[32]; 
                DatagramPacket packet = new DatagramPacket(buf, buf.length);  //datagrampacket to be received.
        
                //blocks until a packet is received. - packet exist of a number of bytes/bytearray.
                udpSocket.receive(packet);
                System.out.println("Packet recieved\n");
                //BufferedInputStream buffer = null;
                //buffer = new BufferedInputStream( new ByteArrayInputStream(packet.getData()) );
                //byte[] b = buffer.readAllBytes();
                byte[] b = packet.getData();
                XyColor d = UDPServer.parseData(b);

                setChanged(); 		//call update i Model.
                notifyObservers(d);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }

    
    private static XyColor parseData(byte[] b) throws Exception {
        // Parse format "(x, y, color)".
        String d = new String(b);
        System.out.println(d);
        int start = d.indexOf("(");
        int end = d.indexOf(")");
        String s = d.substring(start+1, end);
        String[] parts = s.split(",");

        int x = Integer.parseInt(parts[0].trim());
        int y = Integer.parseInt(parts[1].trim());
        String color = parts[2].trim();

        System.out.println("x=" + x + ", y=" + y + ", color=" + color);

        Color c = UDPServer.parseColor(color);
        return new XyColor(x, y, c);
    }

	private static Color parseColor(String color) throws Exception {
		Color out;
		switch (color) {
			case "red": out = Color.red; break;
			case "blue": out = Color.blue; break;
			case "green": out = Color.green; break;
			case "pink": out = Color.pink; break;
			case "black": out = Color.black; break;
			case "gray": out = Color.gray; break;
			case "white": out = Color.white; break;
			case "yellow": out = Color.yellow; break;
			default: throw new Exception("This color is not supported");
		};
		return out;
	}
	
}


