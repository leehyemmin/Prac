package ex06;

// 람다식

public class LambdaEx1 {
	public static void main(String[] args) {
//		Object obj = (a,b) -> a > b ? a : b;  // 람다식. 익명객체
		Object obj = new Object() {
			int max(int a, int b) {
				return a > b ? a : b;
			}
		};
		
		// int value = obj.max(3,5);  // 함수형 인터페이스 필요
	}

}
