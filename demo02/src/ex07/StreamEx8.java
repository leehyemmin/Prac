package ex07;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 최종연산

public class StreamEx8 {
	public static void main(String[] args) {
		String[] strArr = {
			"Inheritance", "Java", "Lambda", "stream",
			"OptionalDouble", "IntStream", "count", "sum"
		};
		
		Stream.of(strArr).forEach(System.out::println);
		
		boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length()==0);
		Optional<String> sWord = Stream.of(strArr)
									.filter(s->s.charAt(0)=='s').findFirst();
		
		System.out.println("noEmptyStr= " + noEmptyStr);
		System.out.println("sWord= " + sWord.get());
		
		
		// Stream<String>을 Stream<Integer>으로 변환
//		Stream<Integer> intStream1 = Stream.of(strArr).map(String::length);
		
		// Stream<String[]>을 IntStream으로 변환
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);
		
		int count = intStream1.reduce(0, (a,b) -> a + 1);
		int sum = intStream2.reduce(0, (a,b) -> a + b);
		
		OptionalInt max = intStream3.reduce(Integer::max);
		OptionalInt min = intStream4.reduce(Integer::min);
		
		System.out.println("count= " + count);
		System.out.println("sum= " + sum);
		System.out.println("max= " + max.getAsInt());
		System.out.println("min= " + min.getAsInt());
	}

}
