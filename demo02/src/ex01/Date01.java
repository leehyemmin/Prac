package ex01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date01 { 

	public static void main(String[] args) {

		Date now = new Date();  // 현재 날짜와 시간의 정보를 참조
		System.out.println("현재날짜: " + now); // toString()생략되어있음. 객체의 정보를 출력할때 toString()이 내부적으로 호출됨
		System.out.println(now.toGMTString());
		System.out.println(now.toLocaleString());
		
		
//		SimpleDateFormat 클래스 : 날짜정보를 사용하기위한 포맷형식 기능을 제공
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		System.out.println("현재날짜: " + sdf.format(now));
		
	}

}

/* 실행결과
현재날짜: Fri May 07 19:06:42 KST 2021
7 May 2021 10:06:42 GMT
2021. 5. 7 오후 7:06:42
현재날짜: 2021-06-07 07:06:42
*/
