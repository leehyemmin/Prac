package review;

import java.util.Scanner;

public class Ex3_6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for(int i=1;i<=T;i++) {
			int A=sc.nextInt();
			int B=sc.nextInt();
			
			System.out.println("Case #" + i + ": " + (A+B));
		}
	}

}
