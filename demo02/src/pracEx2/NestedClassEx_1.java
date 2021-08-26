package pracEx2;

// 중첩 클래스 & 중첩 인터페이스

public class NestedClassEx_1 {
	public static void main(String[] args) {
		Car_1 myCar = new Car_1();
		Car_1.Tire tire = myCar.new Tire();
		Car_1.Engine engine = new Car_1.Engine();
	}

}
