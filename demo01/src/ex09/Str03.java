package ex09;

public class Str03 {

	public static void main(String[] args) {
		char[] cArr = new char[0]; 
		
		String s = new String(cArr);
		String s2 = "";
		
		System.out.println("cArr.length= " + cArr.length);
		System.out.println("@@@" + s + "@@@");
		System.out.println("@@@" + s2 + "@@@");
		
		
	}

}

/* 실행결과
cArr.length= 0
@@@@@@
@@@@@@
 */
