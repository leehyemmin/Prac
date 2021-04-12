package ex10;

public class strMethod01 {

	public static void main(String[] args) {

		// charAt() 메서드 사용
		
		String s = "Hello";
		
		try {
			
			System.out.println("인덱스 0번째 해당하는 문자는? " + s.charAt(0));
			System.out.println("인덱스 1번째 해당하는 문자는? " + s.charAt(1));
			System.out.println("인덱스 2번째 해당하는 문자는? " + s.charAt(2));
			System.out.println("인덱스 3번째 해당하는 문자는? " + s.charAt(3));
			System.out.println("인덱스 4번째 해당하는 문자는? " + s.charAt(4));
			
			System.out.println("인덱스 5번째 해당하는 문자는? " + s.charAt(5));
		
		}catch(StringIndexOutOfBoundsException ex){
			ex.printStackTrace();
		}
	}

}
/*실행결과
 	인덱스 0번째 해당하는 문자는? H
	인덱스 1번째 해당하는 문자는? e
	인덱스 2번째 해당하는 문자는? l
	인덱스 3번째 해당하는 문자는? l
	인덱스 4번째 해당하는 문자는? o
	java.lang.StringIndexOutOfBoundsException: String index out of range: 5
		at java.lang.String.charAt(String.java:658)
		at ex10.strMethod01.main(strMethod01.java:19)
  */
