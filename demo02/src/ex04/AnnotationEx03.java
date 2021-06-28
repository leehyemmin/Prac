package ex04;
// @FunctionalInterface 사용


@FunctionalInterface // 함수형 인터페이스에는 하나의 추상메서드만 가져야 한다는 제약이 있음
interface Testable{
	void test(); // 추상메서드
//	void check(); // 추상메서드
}