package ex12;

//다음 클래스의 static구성요소를 클래스명을 생략하여 코딩을 할때 import문을 다음과같이 선언한다
import static java.lang.Math.*;
import static java.lang.System.*;


public class MathEx {

	public static void main(String[] args) {

		double val = 90.7552;
		
		System.out.println("round(): " + round(val));
		
		val *= 100;
		System.out.println("round(): " + round(val)/100);
		System.out.println("round(): " + round(val)/100.0);

		// 연산이 이루어질때 타입은 큰데이터타입으로 타입일치가 된다.
		
		out.println();
		out.printf("ceil(%3.1f)=%3.1f%n", 1.1, ceil(1.1));  // 올림
		out.printf("floor(%3.1f)=%3.1f%n", 1.5, floor(1.1)); // 내림
		out.printf("round(%3.1f)=%d%n", 1.1, round(1.1));  // 반올림
		out.printf("round(%3.1f)=%d%n", 1.5, round(1.5)); // 반올림
		out.printf("round(%3.1f)=%d%n", -1.5, round(-1.1)); // 반올림
		out.printf("ceil(%3.1f)=%3.1f%n", -1.5, ceil(-1.5)); // 올림
		out.printf("floor(%3.1f)=%3.1f%n", -1.5, floor(-1.5)); // 내림
	}

}
