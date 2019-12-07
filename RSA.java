package daalab;
import java.util.Scanner;
public class RSA{
	public static int gcd(int m,int n) {
		while(n!=0) {
			int r=m%n;
			m=n;
			n=r;
		}
		return m;
	}
	public static void main(String[] args) {
		int p=0,q=0,e=0,d=0,phi=0,n=0,i,j;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the message to be sent");
		String msg = sc.nextLine();
		int msglen = msg.length();
		int nummes[] = new int[msglen];
		int encrypted[] = new int[msglen];
		int decrypted[] = new int[msglen];
		System.out.println("Enter the value of p and q");
		p=sc.nextInt();
		q=sc.nextInt();
		n=p*q;
		phi=(p-1)*(q-1);
		for(i=2;i<phi;i++) {
			if(gcd(i,phi)==1) {
				break;
			}
		}
		e=i;
		for(i=2;i<phi;i++) {
			if((e*i-1)%phi==0) {
				break;
			}
		}
		d=i;
		for(i=0;i<msglen;i++) {
			char c = msg.charAt(i);
			int a = (int)c;
			nummes[i]=a-96;
		}
		for(i=0;i<msglen;i++) {
			encrypted[i]=1;
			for(j=0;j<e;j++) {
				encrypted[i]=(encrypted[i]*nummes[i])%n;
			}
		}
		System.out.println();
		System.out.println("The encrypted message is");
		for(i=0;i<msglen;i++) {
			System.out.print(encrypted[i]);
			System.out.print(" "+(char)(encrypted[i]+96));
		}
		System.out.println();
		for(i=0;i<msglen;i++) {
			decrypted[i]=1;
			for(j=0;j<d;j++) {
				decrypted[i]=(decrypted[i]*encrypted[i])%n;
			}
		}
		System.out.println("The decrypted message is");
		for(i=0;i<msglen;i++) {
			System.out.print((char)(decrypted[i]+96));
		}
	}
}