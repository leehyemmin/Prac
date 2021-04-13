package ex11;

public class StringBuffer03 {

	public static void main(String[] args) {

		// StringBuffer클래스는 기억장소에 자동으로 증가된다.
		// sb, sb2, sb3는 하나의 기억장소를 공유하고 있다.
		StringBuffer sb = new StringBuffer("01");
		StringBuffer sb2 = sb.append(23);
		
		System.out.println(sb.equals(sb2));
		
		sb.append('4').append(56);
		
		StringBuffer sb3 = sb.append(78);
		sb3.append(9.0);
		
		System.out.println(sb);
		System.out.println(sb2);
		System.out.println(sb3);
		
		System.out.println(sb.deleteCharAt(10));
		System.out.println(sb.delete(3, 6));
		System.out.println(sb.insert(3, "abc"));
		System.out.println(sb.replace(6, sb.length(), "END"));
		
		System.out.println("sb 현재 사용량은? " + sb.capacity());
		System.out.println("length= " + sb.length());
	}

}
/* 실행결과
true
0123456789.0
0123456789.0
0123456789.0
01234567890
01267890
012abc67890
012abcEND
sb 현재 사용량은? 18
length= 9
*/
