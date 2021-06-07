package ex03;

import java.util.*;

public class HashSetEx02 {

	public static void main(String[] args) {
		
		Set set = new HashSet();
		
		// set의 크기가 6보다 작은 동안 1~45사이의 난수를 저장
		for(int i=0; set.size()<6; i++) {
			int num = (int)(Math.random()*45) + 1;
			set.add(new Integer(num));
		}
		
		// Set -> List
		List list = new LinkedList(set);
		Collections.sort(list);
		System.out.println(list);
	}

}
