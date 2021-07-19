package ex06;

import java.util.function.*;

// Predicate의 결합

public class LambdaEx4 {
	public static void main(String[] args) {
		
		Function<String, Integer> f = (s) -> Integer.parseInt(s, 16); // s를 16진 정수로 변환
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i); // 2진 문자열로 변환
		
		Function<String, String> h = f.andThen(g);  // f를 적용한 후 g를 적용. f와 g를 연결해서 h를 만듦.
		Function<Integer, Integer> h2 = f.compose(g); // =g.andThen(f)
		
		System.out.println(h.apply("FF")); // "FF" -> 225 -> "11111111"
		System.out.println(h2.apply(2)); // 2 -> "10" -> 16
		
		Function<String, String> f2 = x -> x; // 항등 함수(identity function). 그대로 출력하기.
		System.out.println(f2.apply("AAA"));  // AAA가 그대로 출력됨
		
		Predicate<Integer> p = i -> i < 100;
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i%2 == 0;
		Predicate<Integer> notP = p.negate();  // i >= 100
		
		Predicate<Integer> all = notP.and(q.or(r)); // i >= 100 && ( i < 200 || i%2 == 0;)
		System.out.println(all.test(150));  // true
		
		String str1 = "abc";
		String str2 = "abc";
		
		// str1과 str2가 같은지 비교한 결과를 반환
		Predicate<String> p2 = Predicate.isEqual(str1);
		boolean result = p2.test(str2);
		System.out.println(result);
	}

}
