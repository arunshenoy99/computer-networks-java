
import java.io.*;
import java.net.*;
public class UDPClient{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket sock = new DatagramSocket();
		byte sd[],rd[];
		String clientData,serverData;
		boolean entry=true;
		while(entry) {
			sd = new byte[1024];
			rd = new byte[1024];
			System.out.print("You:");
			clientData = br.readLine();
			if(clientData.trim().equals("exit")) {
				entry=false;
			}
			sd=clientData.getBytes();
			DatagramPacket clientPacket = new DatagramPacket(sd,sd.length,InetAddress.getByName("localhost"),5000);
			sock.send(clientPacket);
			DatagramPacket serverPacket = new DatagramPacket(rd,rd.length);
			sock.receive(serverPacket);
			serverData = new String(serverPacket.getData());
			System.out.println("Server:"+serverData.trim());
		}
	}
}