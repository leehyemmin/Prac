package ex07;

import java.util.stream.Stream;

// 람다식을 소스로 하는 스트림생성
// iterate(), generate()

public class StreamEx4 {

	public static void main(String[] args) {

		// iterate(T seed, UnaryOperator f) 단항 연산자
		Stream<Integer> intStream = Stream.iterate(1, n -> n + 2);
		intStream.limit(10).forEach(System.out::println);
		
		// generate(Supplier s) : 주기만 하는것 입력X, 출력O
		Stream<Integer> oneStream = Stream.generate(()->1);
		oneStream.limit(10).forEach(System.out::println);
	}

}
