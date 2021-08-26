package pracEx2;

// 사용자가 정의한 예외 사용하기

public class UsingMainEx_2 {
	public static void main(String[] args) {
		
		UsingEx_2 uex = new UsingEx_2();
//		System.out.println("add :" + uex.adds(5, 0));
//		System.out.println(uex.sub(5, 6)); // unreported exception;
		try {
			System.out.println(uex.sub(5, 2));
			System.out.println(uex.subs(5, 3));
			System.out.println(uex.sub(5, 0));
		} catch (MyZeroException_2 e) {
			System.out.println(e);
		}
	}

}
