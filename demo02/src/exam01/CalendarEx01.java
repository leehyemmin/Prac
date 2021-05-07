package exam01;

import java.util.Calendar;

public class CalendarEx01 {

	public static void main(String[] args) {
//		추상클래스이므로 객체를 생성할 수 없다.
//		Calendar today = new Calendar();
		
		// getInstance()메서드를 통하여 내부적으로 생성된 객체를 참조
		Calendar today = Calendar.getInstance();
		System.out.println("올해 년도: " + today.get(Calendar.YEAR));
		System.out.println("월(0~11): " + today.get(Calendar.MONTH)); //0 -> 1월
		System.out.println("올해의 몇째주: " + today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이번달의 몇째주: " + today.get(Calendar.WEEK_OF_MONTH));
		System.out.println("이달의 몇일: " + today.get(Calendar.DATE));
		System.out.println("이달의 몇일: " + today.get(Calendar.DAY_OF_MONTH));
		System.out.println("올해의 몇일: " + today.get(Calendar.DAY_OF_YEAR));
		System.out.println("요일(1~7), 1:월요일 " + today.get(Calendar.DAY_OF_WEEK));
		
		System.out.println("오전_오후(0:오전, 1:오후) " + today.get(Calendar.AM_PM));
		System.out.println("현재 시간: " + today.get(Calendar.HOUR));
		System.out.println("현재 분: " + today.get(Calendar.MINUTE));
		System.out.println("현재 초: " + today.get(Calendar.SECOND));
		System.out.println("현재 밀리세컨드: " + today.get(Calendar.MILLISECOND));
		
		// 천분의 일초(밀리세컨드)를 시간으로 표시. 1시간(60분*60초*1000) = 밀리세컨드
		System.out.println("TimeZone(-12~+12)" + today.get(Calendar.ZONE_OFFSET/(60*60*1000)));
		System.out.println("이달의 마지막일 : " + today.getActualMaximum(Calendar.DATE));
	}

}
