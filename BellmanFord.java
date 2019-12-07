import java.util.Scanner;
public class BellmanFord{
	public static void main(String[] args) {
		int i,j,n,k,l;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of nodes");
		n=sc.nextInt();
		int a[][] = new int[n][n];
		int w[] = new int[n];
		System.out.println("Enter the adjacency matrix");
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				a[i][j]=sc.nextInt();
			}
			w[i]=9999;
		}
		for(k=0;k<n;k++) {
			for(l=0;l<n;l++) {
				w[l]=9999;
			}
			w[k]=0;
			int count=0;
			while(count!=n-1) {
				for(i=0;i<n;i++) {
					for(j=0;j<n;j++) {
						if(a[i][j]!=0) {
							if(w[i]+a[i][j]<w[j]) {
								w[j]=w[i]+a[i][j];
							}
						}
					}
				}
				count++;
			}
			for(l=0;l<n;l++) {
				System.out.println("The shortest path from "+k+" to "+l+" is "+w[l]);
			}
			System.out.println("---------------------------------------------");
		}
	}
}