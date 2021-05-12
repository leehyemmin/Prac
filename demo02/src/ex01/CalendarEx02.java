package ex01;

import java.util.Calendar;

public class CalendarEx02 {

	public static void main(String[] args) {
		
		// 보안적으로 막고자 하는 목적
		final String[] DAY_OF_WEEK = {"","일","월","화","수","목","금","토"};
		
		// 현재날짜. 시간정보참조
		Calendar date1 = Calendar.getInstance(); // 과거날짜
		Calendar date2 = Calendar.getInstance(); // 최신날짜
		
//		date1.set(Calendar.HOUR, 5);
		date1.set(2020,1,1); // 2020년2월1일 의미. 2021.01.13 - > 2020.01.01   // 0은 1월
		
		System.out.println("date1은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일이다.");
		System.out.println("date2은 " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일이다.");
		
		// 두 날짜간의 차이를 밀리세컨드 단위로 계산하여, 초로 결과값을 구하자
		
		long diff = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
		System.out.println("date2에서 date1의 날짜간의 차이는? " + diff + "초 간격이 발생합니다.");
		System.out.println("일(day)로 계산하면 " + diff / (24*60*60) + "일 입니다.");
		
	}
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년" + (date.get(Calendar.MONDAY) + 1) + "월" + date.get(Calendar.DATE) + "일";
	}

}
