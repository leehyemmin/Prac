package exam01;

import java.util.Calendar;

public class CalendarSetEx05 {

	public static void main(String[] args) {
		
		// set()으로 날짜와 시간 지정하기
		/*
		void set(int Field, int value)
		void set(int year, int month, int date)
		void set(int year, int month, int date, int hourOfDay, int minute)
		void set(int year, int month, int date, int hourOfDay, int minute, int second)
		*/
		
		// 날짜 지정하는 방법. 월(month)이 0부터 시작한다는 점!
		Calendar date1 = Calendar.getInstance();
		date1.set(2021, 5, 9); // 2021년 6월 9일(5월 아님)
		System.out.println(date1);
		
		// 시간 지정하는 방법.
		Calendar time1 = Calendar.getInstance();
		// time1을 10시 20분 30초로 설정
		time1.set(Calendar.HOUR_OF_DAY, 10);
		time1.set(Calendar.MINUTE, 20);
		time1.set(Calendar.SECOND, 30);
		System.out.println(time1);
	}

}
