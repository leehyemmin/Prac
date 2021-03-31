package ex04;

public class NestedClassEx {
	
	
	public static void main(String[] args) {

		// 인스턴스클래스의 인스턴스를 생성하려면
		// 외부 클래스의 인스턴스를 먼저 생성한다.
		Car c = new Car();
		Car.Tire t = c.new Tire();
		
		// 스테틱 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성안해도됨.
		Car.Engine eg = new Car.Engine();
		
	}

}
