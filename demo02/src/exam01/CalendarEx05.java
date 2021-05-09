package exam01;

import java.util.Calendar;
import java.util.Date;

public class CalendarEx05 {

	public static void main(String[] args) {

		// clear()는 Calendar객체의 모든 필드를 초기화.
		Calendar dt = Calendar.getInstance();
		
		// Sun May 09 22:19:46 KST 2021
		System.out.println(new Date(dt.getTimeInMillis()));
		
		dt.clear(); // 모든 필드를 초기화
		//Thu Jan 01 00:00:00 KST 1970
		System.out.println(new Date(dt.getTimeInMillis()));
		
		
		// clear(int field)는 Calendar객체의 특정 필드를 초기화
		Calendar dt2 = Calendar.getInstance();
		
		// Sun May 09 22:19:46 KST 2021
		System.out.println(new Date(dt2.getTimeInMillis()));
		
		dt2.clear(Calendar.SECOND);  // 초를 초기화
		dt2.clear(Calendar.MINUTE);	// 분을 초기화
		dt2.clear(Calendar.HOUR_OF_DAY); // 시간을 초기화
		dt2.clear(Calendar.HOUR);  // 시간을 초기화
		
		// Sun May 09 12:00:00 KST 2021
		System.out.println(new Date(dt2.getTimeInMillis()));
	}

}
