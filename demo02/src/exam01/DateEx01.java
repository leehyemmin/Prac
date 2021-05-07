package exam01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx01 {

	public static void main(String[] args) {
		Date now = new Date(); // 현재 날짜와 시간의 정보를 참조한다.
		System.out.println("현재날짜: " + now); // toString()생략되어있음. 객체의 정보를 출력할때 toString()이 내부적으로 호출됨
		System.out.println(now.toGMTString());
		System.out.println(now.toLocaleString());
		
		
		// Date클래스에 getter(읽기)/ setter(변경) 메서드 지원.
		
		System.out.println(now.getYear() + " 년" + now.getDay());
		
		
//		SimpleDateFormat 클래스 : 날짜정보를 사용하기위한 포맷형식 기능을 제공
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		System.out.println("현재날짜: " + sdf.format(now));
	}

}
