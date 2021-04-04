package ex09;

public class Str02 {

	public static void main(String[] args) {

		// 상수값들은 상수 풀영역에 저장
		// "abc"문자열을 다시 사용하게되면 상수풀 영역의 기억장소에서 찾아 재사용
		String str1 = "abc";
		String str2 = "abc";
		
		System.out.println("String str1 = \"abc\";");
		System.out.println("String str2 = \"abc\";");
		
		System.out.println("주소값비교  str1 == str2 ? " + (str1 == str2)); // 참조값 비교
		
		System.out.println("str1.equals(str2) ? " + str1.equals(str2)); // 값비교
		
		String str3 = "1234";
		String str4 = "1234";
		
		if(str3.equals(str4)) {
			System.out.println("같다");
		}
	}

}

/* 실행결과
String str1 = "abc";
String str2 = "abc";
주소값비교  str1 == str2 ? true
str1.equals(str2) ? true
같다
*/
