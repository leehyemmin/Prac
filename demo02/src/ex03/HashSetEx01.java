package ex03;

import java.util.*;

public class HashSetEx01 {

	public static void main(String[] args) {
		// Set 인터페이스 특징 : 순서유지X, 중복X
		Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4"};
		Set set = new HashSet();
		
		for(int i=0; i<objArr.length; i++) {
			set.add(objArr[i]);
		}
		
		System.out.println(set);
	}

}
