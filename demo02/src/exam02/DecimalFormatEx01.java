package exam02;

import java.text.DecimalFormat;
import java.text.ParseException;

public class DecimalFormatEx01 {

	public static void main(String[] args) throws ParseException {

		DecimalFormat df = new DecimalFormat("#,###.##");
		Number num = df.parse("1,234,567.89"); // 콤마(,)가 존재해도 캐스팅 가능
		
		double d = (double) num;
		double d2 = num.doubleValue();
		
		System.out.println(d);
		System.out.println(d2);
		
		try {
			double d3 = Double.parseDouble("1,234,567.89"); // 콤마(,) 지원안함
		}catch(Exception e) {
			e.printStackTrace(); // 예외정보를 출력
		}
		
		System.out.println("종료");
	}

}
