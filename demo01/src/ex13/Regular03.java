package ex13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular03 {

	public static void main(String[] args) {
		
		// Matcher 클래스 사용
		
		Pattern pattern = Pattern.compile("^[a-zA-Z]*$"); // 정규식객체
		String val = "abcdef"; // 대상문자열
		
		Matcher matcher = pattern.matcher(val);
		
		// find(): 대상문자열과 패턴이 일치되는 경우 true를 반환하고, 그 위치로 이동한다.
		System.out.println(matcher.find());
	}

}

/*실행결과
 true
 */
