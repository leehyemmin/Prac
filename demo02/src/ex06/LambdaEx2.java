package ex06;

// 람다식
// 함수형 인터페이스

public class LambdaEx2 {
	public static void main(String[] args) {
//		MyFunction f = new MyFunction() {
//			public int max(int a, int b) {  // 오버라이딩 - 접근제어자는 좁게 못바꾼다.
//				return a > b ? a : b;
//			}
//		};
		
		// 람다식(익명 객체)을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다
		MyFunction f = (a,b) -> a > b ? a : b;  // 람다식. 익명객체
		
		int value = f.max(3,5);  // 함수형 인터페이스 필요
		System.out.println("value= " + value);
	}

}

@FunctionalInterface  // 함수형 인터페이스는 단 하나의 추상메서드만 가져야함.
interface MyFunction{
//	public abstract int max(int a, int b);
	int max(int a, int b);
}