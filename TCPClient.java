
import java.io.*;
import java.net.*;
public class TCPClient{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the address of the server:");
		String address = br.readLine();
		Socket sock = new Socket(address,5000);
		System.out.println("Enter the filename");
		String fname = br.readLine();
		OutputStream ostream = sock.getOutputStream();
		PrintWriter pw = new PrintWriter(ostream,true);
		pw.println(fname);
		InputStream istream = sock.getInputStream();
		BufferedReader contentRead = new BufferedReader(new InputStreamReader(istream));
		String str;
		while((str=contentRead.readLine())!=null) {
			System.out.println(str);
		}
		br.close();
		contentRead.close();
		sock.close();
		pw.close();
	}
}