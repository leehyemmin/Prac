package ex11;

public class StringBuffer02 {

	public static void main(String[] args) {

		// String클래스는 문자열이 연결될 때마다 새로운 문자열을 지정하기 위한 기억장소가 매번 생성된다.
		// StringBuffer클래스는 처음 생성된 기억장소에 누적이 된다. (성능 작업을 할 경우에는 String클래스는 사용하지 말것)
		StringBuffer sb = new StringBuffer("abc");
		
		for(int i=0; i<20; i++) {
			sb.append("" + i);
		}
		System.out.println(sb.toString());
		
		sb.append("123").append("123").append(true).append('a');
		
		System.out.println(sb.toString());
	}

}

/* 실행결과
 abc012345678910111213141516171819
 abc012345678910111213141516171819123123truea
*/