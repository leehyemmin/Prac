package ex03;

import java.util.*;

public class TreeSetEx01 {

	public static void main(String[] args) {

		Set set = new TreeSet(); // 범위검색, 정렬. 정렬 필요없음
//		Set set = new HashSet(); // 정렬 필요
		
		for(int i=0; set.size() < 6; i++) {
			int num = (int)(Math.random()*45) + 1;
			set.add(num);
		}
		
		System.out.println(set);
		
	}

}
