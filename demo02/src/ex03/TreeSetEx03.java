package ex03;

import java.util.*;

public class TreeSetEx03 {

	public static void main(String[] args) {

		TreeSet set = new TreeSet();
		int[] score = {80, 95, 50, 35, 45, 65, 10, 100};
		
		for(int i=0; i<score.length; i++) 
			set.add(new Integer(score[i]));
			
			System.out.println("50보다 작은 값 : "+ set.headSet(new Integer(50)));
			System.out.println("50보다 큰 값 : "+ set.tailSet(new Integer(50)));
		
	}

}

/* 실행결과
50보다 작은 값 : [10, 35, 45]
50보다 큰 값 : [50, 65, 80, 95, 100]
*/