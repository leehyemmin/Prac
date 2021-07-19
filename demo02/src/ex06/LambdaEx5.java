package ex06;

import java.util.function.Function;

// 메서드 참조

public class LambdaEx5 {
	public static void main(String[] args) {
//		Function<String, Integer> f = (String s) -> Integer.parseInt(s); // 람다식
//		Function<String, Integer> f = 클래스이름::메서드이름;
		Function<String, Integer> f = Integer::parseInt; // 메서드참조
		System.out.println(f.apply("100")+200);
	}	

}
