package ex13;

import java.util.regex.Pattern;

public class Regular04 {

	public static void main(String[] args) {

		String name = "홍길동";
		String tel = "010-1234-4567";
		String email = "abc@abc.com";
		
		// 유효성검사.	 ^문자열시작, $문자열종료.  기본으로 패턴구문을 작성할때 사용
		boolean isName = Pattern.matches("^[가-힣]*$", name);
		boolean isTel = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", tel);
		boolean isEmail = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email);
		
		System.out.println("이름 : " + isName);
		System.out.println("번호 : " + isTel);
		System.out.println("전자우편 : " + isEmail);
	}

}
