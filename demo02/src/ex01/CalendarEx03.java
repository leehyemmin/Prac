package ex01;

import java.util.Calendar;

public class CalendarEx03 {

	public static void main(String[] args) {
		final int[] TIME_UNIT = {3600, 60, 1};  // 1시간 = 3600초
		final String[] TIME_UNIT_NAME = {"시간", "분", "초"};
		
		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		
		// 10시 20분 30초
		time1.set(Calendar.HOUR_OF_DAY, 10); // 10시
		time1.set(Calendar.MINUTE, 20); // 20분
		time1.set(Calendar.SECOND, 30); // 30초
		
		// 20시 30분 10초
		time2.set(Calendar.HOUR_OF_DAY, 20); // 20시
		time2.set(Calendar.MINUTE, 30); // 30분
		time2.set(Calendar.SECOND, 10); // 10초
		
		System.out.println(time1.get(Calendar.HOUR_OF_DAY) + "시" + time1.get(Calendar.MINUTE) + "분" + time1.get(Calendar.SECOND) + "초 입니다.");
		System.out.println(time2.get(Calendar.HOUR_OF_DAY) + "시" + time2.get(Calendar.MINUTE) + "분" + time1.get(Calendar.SECOND) + "초 입니다.");

		System.out.println(Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis()));
		
		long diff = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis()) / 1000;
		
		String tmp = "";
		for(int i=0; i<TIME_UNIT.length;i++) {
			tmp += diff/TIME_UNIT[i] + TIME_UNIT_NAME[i];
			diff %= TIME_UNIT[i]; // 나머지를 저장하고, for문이 반복하여 다시 나눈다.
		}
		
		System.out.println("시분초로 변환한 결과는? " + tmp + "입니다.");
	}

}
