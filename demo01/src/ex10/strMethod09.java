package ex10;

public class strMethod09 {

	public static void main(String[] args) {

		// toCharArray() : 문자열을 문자배열 형태로 사용가능
		
		String str = "Hello World Java!!!";
		char[] arr = str.toCharArray();
		
		for(char c : arr) {
			System.out.println(c);
		}
	}

}
/*실행결과
H
e
l
l
o
 
W
o
r
l
d
 
J
a
v
a
!
!
!
*/
 
