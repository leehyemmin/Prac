package ex10;

public class strMethod08 {

	public static void main(String[] args) {

		// subString() 메서드 사용 : 부분 문자열을 추출. 2번째 인덱스값은 포함하지 않는다.
		// trim() : 좌우측 공백 문자열 제거
		
		String str = "Hello World Java";
		
		System.out.println(str.substring(0, 5));
		System.out.println(str.substring(0, 7));
		System.out.println(str.substring(6));
		
		String str2 = "   Hello World   ";
		
		System.out.println(str2.trim());
	}

}
/*실행결과
Hello
Hello W
World Java
Hello World
*/
