package review;

import java.util.*;

public class Ex3_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int sum = 0;
		
		for(int i=0;i<n;i++) {
			sum += (i+1);
		}
		System.out.println(sum);
	}

}
