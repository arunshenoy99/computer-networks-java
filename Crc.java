import java.util.Scanner;
public class Crc {
	public static void div(int a[],int k) {
		int gp[] = {1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};
		int i,j,count=0;
		for(i=0;i<k;i++) {
			if(a[i]==1) {
				for(j=i;j<17+i;j++) {
					a[j]=a[j]^gp[count++];
				}
				count=0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i,j,n;
		System.out.print("Enter the length of the data to be sent:");
		n=sc.nextInt();
		int a[] = new int[n+16];
		int b[] = new int[n+16];
		System.out.print("Enter the data to be sent:");
		for(i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		for(i=n;i<a.length;i++) {
			a[i]=0;
		}
		for(i=0;i<a.length;i++) {
			b[i]=a[i];
		}
		div(a,n);
		for(i=0;i<a.length;i++) {
			a[i]=a[i]^b[i];
		}
		System.out.print("The data to be sent is:");
		for(i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.print("Enter the data recieved");
		for(i=0;i<a.length;i++) {
			a[i]=sc.nextInt();
		}
		div(a,n);
		for(i=0;i<a.length;i++) {
			if(a[i]==1) {
				System.out.println("There is an error in data");
				return;
			}
		}
		System.out.println("There is no error in data");
	}
}
