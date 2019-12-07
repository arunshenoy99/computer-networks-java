package daalab;
import java.util.Scanner;
public class leakybuckets{
	public static void main(String[] args) {
		int bandwidth,bucket=0,drop=0,bucketSize,time,i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the bandwidth");
		bandwidth=sc.nextInt();
		System.out.println("Enter the bucket size");
		bucketSize=sc.nextInt();
		System.out.println("Enter the simulation time");
		time=sc.nextInt();
		int inp[] = new int[time];
		for(i=0;i<time;i++) {
			System.out.println("Enter the packet entering at "+(i+1)+" s");
			inp[i]=sc.nextInt();
		}
		System.out.print("Time\t"+"Packets Arrived\t"+"Packets Sent\t"+"Packets Remaining\t"+"Packets Dropped\n");
		for(i=0;i<time;i++) {
			drop=0;
			System.out.print((i+1)+"\t\t");
			System.out.print(inp[i]+"\t\t");
			System.out.print(bandwidth+"\t\t");
			if(bucket+inp[i]>bucketSize) {
				drop=bucket+inp[i]-bucketSize;
			}
			inp[i]=inp[i]-drop;
			bucket = bucket+inp[i];
			bucket=bucket-bandwidth;
			System.out.print(bucket+"\t\t");
			System.out.print(drop+"\t\t");
			System.out.println();
		}
		while(bucket!=0) {
			if(bucket>bandwidth) {
				bucket=bucket-bandwidth;
			}
			else {
				bandwidth=bandwidth-bucket;
				bucket=0;
			}
			System.out.print((i+1)+"\t\t");
			System.out.print("0"+"\t\t");
			System.out.print(bandwidth+"\t\t");
			System.out.print(bucket+"\t\t");
			System.out.print("0\t\t");
			System.out.println();
			i++;
		}
	}
}