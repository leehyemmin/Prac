package ex04;
// @SuppressWarnings 사용


class Parent2{
	void parentMethod() {}
}

class Child2 extends Parent2{
	@Override
	@Deprecated
	void parentMethod() {} 
}

public class AnnotationEx04 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Child2 c = new Child2();
		c.parentMethod(); // deprecated된 메서드 사용
	}

}
