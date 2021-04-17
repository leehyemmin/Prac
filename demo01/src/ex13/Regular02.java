package ex13;

import java.util.regex.Pattern;

public class Regular02 {

	public static void main(String[] args) {
		
		// Pattern 클래스 사용
		
		String pattern = "^[0-9]+$"; // 정규식패턴
		String val = "123456789"; // 대상문자열
		
		// matches(): 대상문자열과 패턴이 일치하는 경우 true반환
		boolean bool = Pattern.matches(pattern, val);
		System.out.println(bool);
	}

}

/*실행결과
 true
 */
