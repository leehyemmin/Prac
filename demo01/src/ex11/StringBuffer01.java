package ex11;

public class StringBuffer01 {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		
		System.out.println(sb.toString()); // toString() 재정의
		System.out.println("sb == sb2 ? " + (sb.toString().equals(sb2.toString())));
		System.out.println("----------------------------");
		
		// 주소비교. String클래스의 차이점 확인
		System.out.println("sb == sb2 ? " + (sb == sb2));
		System.out.println("sb.equals(sb2) ? " + (sb.equals(sb2)));
		
		String s1 = sb.toString(); // "abc"
		String s2 = sb2.toString(); // "abc"
		
		// String클래스에서 재정의. 값비교 용도
		if(s1.equals(s2)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
	}

}

/* 실행결과
abc
sb == sb2 ? true
----------------------------
sb == sb2 ? false
sb.equals(sb2) ? false
true

 */

