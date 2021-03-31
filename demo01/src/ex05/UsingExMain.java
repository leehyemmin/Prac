package ex05;

public class UsingExMain {

	public static void main(String[] args) {

		UsingEx ue = new UsingEx();
		
		
		try {
			System.out.println(ue.sub(5, 2));
			System.out.println(ue.subs(5, 3));
			System.out.println(ue.sub(5, 0));
		}catch (MyZeroException me) {
//			me.printStackTrace();
//			System.out.println(me.getMessage());
			System.out.println(me);
		}
	}

}

/* 실행결과
2
1
ex05.MyZeroException: 0으로 나누지 마라.
*/
