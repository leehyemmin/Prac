package ex13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular01 {

	public static void main(String[] args) {

		String[] data = {"bat", "baby", "bonus", 
					"c", "cA", "ca", "co", "c.", "c0", "car", "combat", "count",
					"date", "disc"};
		
		// * 는 빈도문자. 0개이상(생략하거나 여러개 사용가능)
		Pattern p = Pattern.compile("c[a-z]*");
		
		for(int i=0; i<data.length; i++) {
			Matcher m = p.matcher(data[i]); // p.matcher("패턴검색대상 문자열")
			if(m.matches()) {
				System.out.println(data[i] + ",");
			}
		}
	}

}

/* 실행결과
c,
ca,
co,
car,
combat,
count,
*/