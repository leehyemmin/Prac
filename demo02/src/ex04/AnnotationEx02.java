package ex04;
// @Deprecated 사용


class Parent1{
	void parentMethod() {}
}

class Child1 extends Parent1{
	@Override
	@Deprecated
	void parentMethod() {} 
}

public class AnnotationEx02 {
	public static void main(String[] args) {
		Child1 c = new Child1();
		c.parentMethod(); // deprecated된 메서드 사용
	}

}
