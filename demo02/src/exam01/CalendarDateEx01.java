package exam01;

import java.util.Calendar;
import java.util.Date;

public class CalendarDateEx01 {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		
		// ...........
		
		Date d = new Date(cal.getTimeInMillis()); // Date(long 타입)
		
		System.out.println(d);
	}

}
