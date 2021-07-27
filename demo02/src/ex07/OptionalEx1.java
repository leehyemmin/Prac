package ex07;

import java.util.Optional;

public class OptionalEx1 {
	public static void main(String[] args) {
//		int[] arr = null;
		int[] arr = new int[0];
		System.out.println("arr.length= " + arr.length);
		
//		Optional<String> opt = null;  // Ok. but, 바람직X
		Optional<String> opt = Optional.empty();
//		Optional<String> opt = Optional.of("abc");
		System.out.println("opt= " + opt);
//		System.out.println("opt= " + opt.get());  // get()은 잘 안씀
		
		String str = "";
		
//		try {
//			str = opt.get();
//		} catch (Exception e) {
//			str = ""; // 예외가 발생하면 빈문자열("")로 초기화
//		} // 예외발생
		
//		str = opt.orElse("EMPTY");  // Optional에 저장된 값이 null이면 ""반환
//		str = opt.orElseGet(()->"EMPTY");
		
//		= str = opt.orElseGet(()-> new String());
		str = opt.orElseGet(String::new);
		
		System.out.println("str= " + str);
	}	

}
