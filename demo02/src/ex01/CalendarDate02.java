package ex01;

import java.util.Calendar;
import java.util.Date;

public class CalendarDate02 {

	public static void main(String[] args) {

		Date d = new Date();
		
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(d);
		
		System.out.println(Calendar.DATE);
	}

}
