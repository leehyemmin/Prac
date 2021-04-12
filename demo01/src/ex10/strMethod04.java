package ex10;

public class strMethod04 {

	public static void main(String[] args) {
		
		// replace 메서드 사용
		
		String s1 = "ababab";
		
		System.out.println(s1.replace('a', 'b')); // 매개변수가 char 데이터타입 사용
		System.out.println(s1.replace("ab", "AB"));
	}

}

/*실행결과
 bbbbbb
 ABABAB 
 */
