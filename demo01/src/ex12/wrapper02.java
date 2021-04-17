package ex12;

public class wrapper02 {

	public static void main(String[] args) {

		int i = Integer.parseInt("100");
		
		System.out.println("i= " + Integer.parseInt("100")); // 10진수
		System.out.println("i= " + Integer.parseInt("100", 10)); // 위와 동일
		System.out.println("i= " + Integer.parseInt("100", 2)); // 2진수
		System.out.println("i= " + Integer.parseInt("FF", 16)); // 16진수
	}

}

/* 실행결과
i= 100
i= 100
i= 4
i= 255
 */

