package ex10;

public class str04 {

	public static void main(String[] args) {

		// 숫자 -> 문자열
		int i = 100;
		String str1 = i + ""; // 100 -> "100" 변환. 방법1
		String str2 = String.valueOf(i); // 방법2 
		
		
		// 문자열 -> 숫자
		int i2 = Integer.parseInt("100");
		int i3 = Integer.valueOf("100");
		
		Integer iObj = 100; // auto Boxing //Integer iObj =new Integer(100);
		int i4 = iObj; // 형변환 생략가능 (자동형변환)
		
		// String형 -> char형변환 작업
		char c = "A".charAt(0); // "A" -> 'A'
	}

}
