package ex07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// Stream 만들기


public class StreamEx1 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> intStream = list.stream();  // list를 Stream으로 변환
		intStream.forEach(System.out::print);
		
		// stream은 1회용. stream에 대해 최종연산을 수행하면 stream이 닫힌다.
		intStream = list.stream();  // list로 부터stream을 생성
		intStream.forEach(System.out::print);
		
		
		
	}

}
