package review;

import java.util.Scanner;

public class Ex3_10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt(); 
		int X = sc.nextInt(); 
		int arr[] = new int[A];
		
		for(int i=0;i<A;i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		for(int i=0;i<A;i++) {
			if(arr[i] < X) {
				System.out.print(arr[i] + " ");
			}
		}
	}

}
