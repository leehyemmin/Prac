package review;

public class Ex2_1 {

	public static void main(String[] args) {
		Data_1 d1 = new Data_1();
//		Data_2 d2 = new Data_2();  // compile error발생
		// The constructor Data_2() is undefined
		
		
		System.out.println(d1);
		System.out.println();
		
	}

}

class Data_1{
	int value;
//	Data_1(){} // 기본생성자를 추가. 컴파일 자동 추가됨.
}

class Data_2{
	int value;
	
//	Data_2(){} // 기본생성자
	
	Data_2(int x){ // 매개변수가 있는 생성자
		value = x;
	}
}
