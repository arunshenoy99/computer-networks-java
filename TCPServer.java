
import java.io.*;
import java.net.*;
public class TCPServer{
	public static void main(String[] args) throws Exception {
		ServerSocket ssock = new ServerSocket(5000);
		System.out.println("Server waiting for connection");
		Socket sock = ssock.accept();
		System.out.println("Connection established with "+sock.getInetAddress().toString());
		InputStream istream = sock.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(istream));
		String fname = br.readLine();
		BufferedReader contentRead = new BufferedReader(new FileReader(fname));
		OutputStream ostream = sock.getOutputStream();
		PrintWriter pw = new PrintWriter(ostream,true);
		String str;
		while((str=contentRead.readLine())!=null) {
			pw.println(str);
		}
		pw.close();
		br.close();
		contentRead.close();
		sock.close();
		ssock.close();
	}
}