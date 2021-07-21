package ex07;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {
	public static void main(String[] args) {
//		IntStream intStream = new Random().ints(); // 무한 스트림
		IntStream intStream = new Random().ints(5); // 이렇게 잘라줘도 됨
		intStream.limit(5).forEach(System.out::println); // limit()으로 잘라주기
		
	}

}
