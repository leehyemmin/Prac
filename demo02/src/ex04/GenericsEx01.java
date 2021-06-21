package ex04;

import java.util.ArrayList;

public class GenericsEx01 {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10); // list.add(new Integer(10));
		list.add(20);
		list.add(30); // 지네릭스로 타입체크가 강화됨.
		
		Integer i = list.get(2); // 형변환 생략가능.
		
		System.out.println(list);
	}

}

/*
지네릭 사용전.

ArrayList list = new ArrayList();
list.add(10);
list.add(20);
list.add("30");  // String을 추가

Integer i = (Integer)list.get(2); // 컴파일 OK, but 실행하면 에러

System.out.println(list);

*/