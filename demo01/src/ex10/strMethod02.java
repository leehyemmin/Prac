package ex10;

public class strMethod02 {

	public static void main(String[] args) {
		// compareTo() 메서드 사용
		// 문자열을 사전순으로 비교검색을 한다.
		// 사전순이 앞에 있는 경우엔 음수, 동일한 경우엔 0, 뒤에 올 경우엔 양수
		
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = "AHello";
		String s4 = "ZHello";
		
		// 사전순이 동일한 경우 0
		System.out.println(s1.compareTo(s2));
		// 사전순으로 s3가 앞에 나오기때문에 양수 출력
		System.out.println(s1.compareTo(s3));
		// 사전순으로 s4가 뒤에 나오기때문에 음수 출력
		System.out.println(s1.compareTo(s4));
	}

}

/*실행결과
 0
 7
-18
 */
