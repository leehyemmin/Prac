package ex10;

public class strMethod05 {

	public static void main(String[] args) {

		// startWith(), endWith() 메서드 사용
		
		String s1 = "Hello World";
		String s2 = "World";
		String s3 = "Hello";
		
		// s1의 문자열이 s3의 내용으로 시작되는 문자열인지 여부? true, false
		System.out.println(s1.startsWith(s3));
		
		// s1의 문자열이 s2의 내용으로 끝나는 문자열인지 여부? true, false
		System.out.println(s1.endsWith(s2));
	}

}
/* 실행결과
	true
	true
*/
