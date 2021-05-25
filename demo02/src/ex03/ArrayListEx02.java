package ex03;

import java.util.*;

public class ArrayListEx02 {

	public static void main(String[] args) {

		final int LIMIT = 10; // 값 변경 불가능
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		
		int length = source.length(); //43
		
		List<String> list = new ArrayList<>(length/LIMIT + 10);
		
		for(int i=0; i<length; i+=LIMIT) {  // i:0, i:10, i:20, i:30 true, i:40 false
			if(i+LIMIT < length) {
				list.add(source.substring(i, i+LIMIT)); // [0]: 0123456789, [1]: abcdefghij
			}else {
				list.add(source.substring(i)); // for 5번째 루프시 "ZZZ" 작업
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
