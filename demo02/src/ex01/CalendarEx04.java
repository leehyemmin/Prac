package ex01;

import java.util.Calendar;

public class CalendarEx04 {

	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		
		date.set(2005, 7, 31);

		System.out.println(toString(date));
		System.out.println("1일 후: ");
		date.add(Calendar.DATE, 1);
		System.out.println(toString(date));
		
		System.out.println("6개월 전: ");
		date.add(Calendar.MONTH, -6);
		System.out.println(toString(date));
		
		System.out.println("31일 후(roll): ");
		date.roll(Calendar.DATE, 31);
		System.out.println(toString(date));
		
		System.out.println("31일 후(add): ");
		date.add(Calendar.DATE, 31);
		System.out.println(toString(date));
		
		// roll() vs add()의 차이점은?
		// add() : 앞의 필드에 영향을 준다. (올림발생)
		// roll() : 앞의 필드에 영향을 안준다.
		
		
		
	}
	
	public static String toString(Calendar date) {
	return date.get(Calendar.YEAR) + "년" + (date.get(Calendar.MONDAY) + 1) + "월" + date.get(Calendar.DATE) + "일";

	}
}
