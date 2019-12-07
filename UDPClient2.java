
import java.io.*;
import java.net.*;
public class UDPClient2 {
	public static void main(String[] args) throws Exception {
		DatagramSocket sock = new DatagramSocket();
		byte sd[] = new byte[1024];
		byte rd[] = new byte[1024];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String clientData=" " ,serverData=" ";
		while(clientData.trim()!="bye"&&serverData.trim()!="bye") {
			sd = new byte[1024];
			rd = new byte[1024];
			System.out.print("You:");
			clientData = br.readLine();
			sd = clientData.getBytes();
			DatagramPacket clientPacket = new DatagramPacket(sd,sd.length,InetAddress.getByName("localhost"),5000);
			sock.send(clientPacket);
			DatagramPacket serverPacket = new DatagramPacket(rd,rd.length);
			sock.receive(serverPacket);
			serverData=new String(serverPacket.getData());
			System.out.print("Server:"+serverData.trim());
		}
		sock.close();
	}
}
