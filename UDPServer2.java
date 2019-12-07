
import java.io.*;
import java.net.*;
public class UDPServer2 {
	public static void main(String[] args) throws Exception {
		byte sd[] = new byte[1024];
		byte rd[] = new byte[1024];
		DatagramSocket sock = new DatagramSocket(5000);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String clientData=" ",serverData=" ";
		while(clientData.trim()!="bye"&&serverData.trim()!="bye") {
			sd = new byte[1024];
			rd = new byte[1024];
			DatagramPacket clientPacket = new DatagramPacket(rd,rd.length);
			sock.receive(clientPacket);
			clientData = new String(clientPacket.getData());
			System.out.println("Client:"+clientData.trim());
			System.out.print("You:");
			serverData = br.readLine();
			sd=serverData.getBytes();
			DatagramPacket serverPacket = new DatagramPacket(sd,sd.length,clientPacket.getAddress(),clientPacket.getPort());
			sock.send(serverPacket);
		}
		sock.close();
	}
}
