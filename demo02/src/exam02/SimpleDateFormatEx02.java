package exam02;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatEx02 {

	public static void main(String[] args) {

		// 다형성 관점의 코드구문
		DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			Date d= df.parse("2015년 11월 23일");
			System.out.println(df2.format(d));
		}catch(ParseException e) {
			e.printStackTrace();
		}
	

		
	}
	
}
