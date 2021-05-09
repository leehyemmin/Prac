package exam01;

import java.util.Calendar;

public class CalendarEx06 {

	public static void main(String[] args) {
		
		// add()는 특정 필드의 값을 증가 또는 감소(다른 필드에 영향O)
		Calendar date = Calendar.getInstance();
		date.clear(); // 모든 필드를 초기화
		date.set(2021, 7, 31); // 2021년 8월 31일로 설정
		
		// 날짜(DATE)에 1을 더한다. 월(MONTH)에도 영향을 줌.
		date.add(Calendar.DATE, 1); // 9월 1일
		// 월(MONTH)에서 8을 뺸다
		date.add(Calendar.MONTH, -8); // 1월 1일
		
		
		// roll()은 특정 필드의 값을 증가 또는 감소(다른 필드에 영향X)
		date.set(2021, 7, 31); // 2021년 8월 31일로 설정
		
		// add()와 달리 roll()은 다른 필드에 영향을 미치지 않는다.
		//날짜(DATE)에 1을 더한다. 월(MONTH)에 영향X
		date.roll(Calendar.DATE, 1); // 8월 1일
		// 월(MONTH)에서 8을 뺸다
		date.roll(Calendar.MONTH, -8);
	}

}
