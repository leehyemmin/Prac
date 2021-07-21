package ex07;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Stream 만들기

public class StreamEx2 {

	public static void main(String[] args) {

		String[] strArr = new String[] {"a", "b", "c", "d"};
//		Stream<String> strStream = Stream.of(strArr); 아래와 같음.
		Stream<String> strStream = Arrays.stream(strArr);
		strStream.forEach(System.out::println);
		
		// 기본형 스트림
		int[] intArr = {1,2,3,4,5};
		IntStream intStream = Arrays.stream(intArr);
//		intStream.forEach(System.out::println);
//		System.out.println("count= " + intStream.count()); // 최종연산
//		System.out.println("sum= " + intStream.sum());
		System.out.println("average= " + intStream.average());
		
		
		
		// Integer 객체 스트림
//		Integer[] intArr = {1,2,3,4,5};
//		Stream<Integer> intStream = Arrays.stream(intArr);
//		intStream.forEach(System.out::println);
//		System.out.println("count= " + intStream.count());
	}

}
