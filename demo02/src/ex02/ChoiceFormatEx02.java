package ex02;

import java.text.ChoiceFormat;

public class ChoiceFormatEx02 {

	public static void main(String[] args) {
		/*
		 4개 범위값
		 나머지 : D
		 60~69 : D
		 70~80 : C
		 81~89 : B
		 90이상 : A 
		 */
		
		
		String pattern = "60#D|70#C|80<B|90#A";
		
		int[] scores = {91, 90, 80, 88, 70, 52, 60};
		
		ChoiceFormat form = new ChoiceFormat(pattern);  // #은 경계값이 범위에 포함, < 는 경계값이 포함되지 않는다.
		
		for(int i=0;i<scores.length;i++) {
			System.out.println(scores[i] + ":" + form.format(scores[i]));
		}
	}

}
/* 실행결과
91:A
90:A
80:C
88:B
70:C
52:D
60:D
*/