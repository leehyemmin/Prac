package ex10;

public class strMethod03 {

	public static void main(String[] args) {
		
		// concat() 메서드 사용
		
		String s1 = "Hello";
		String s2 = " World";
		String s3 = s1.concat(s2);
		
		System.out.println(s1.concat(s2));
		System.out.println(s3);
		
		System.out.println("------------------------");
		System.out.println(s1.concat(s2).hashCode());
		System.out.println(s3.hashCode());

	}

}

/* 실행결과
Hello World
Hello World
------------------------
-862545276
-862545276
*/
