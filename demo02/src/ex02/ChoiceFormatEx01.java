package ex02;

import java.text.ChoiceFormat;

public class ChoiceFormatEx01 {

	public static void main(String[] args) {
		/*
		 4개 범위값
		 60~69 : D
		 70~79 : C
		 80~89 : B
		 90이상 : A 
		 */
		
		
		double[] limits = {30, 70, 80, 90}; // 낮은값부터 큰값 순서로 나열. 배열의 크기가 동일해야 한다.
		String[] grades = {"D", "C", "B", "A"};
		
		int[] scores = {100, 95, 88, 70, 52, 60, 70};
		
		ChoiceFormat form = new ChoiceFormat(limits, grades);
		
		for(int i=0;i<scores.length;i++) {
			System.out.println(scores[i] + ":" + form.format(scores[i]));
		}
	}

}

/* 실행결과
 100:A
95:A
88:B
70:C
52:D
60:D
70:C
 */
 