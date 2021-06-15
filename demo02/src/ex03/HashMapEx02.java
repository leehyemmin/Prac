package ex03;

import java.util.*;

public class HashMapEx02 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		
		map.put("홍길동", new Integer(90));
		map.put("홍길동", new Integer(100));
		map.put("홍길동2", new Integer(100));
		map.put("홍길동3", new Integer(80));
		map.put("홍길동4", new Integer(90));
		
		Set set = map.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
		}
		
		// key 목록
		set = map.keySet();
		System.out.println("참가자 명단: " + set);
		
		// values 목록
		Collection values = map.values();
		it = values.iterator();
		
		int total = 0;
		
		while(it.hasNext()) {
			int i = (int)it.next();
			total += i;
		}
		
		System.out.println("총점: " + total);
		System.out.println("평균: " + (float)total/set.size());
		System.out.println("최고점수: " + Collections.max(values));
		System.out.println("최저점수: " + Collections.min(values));
	}

}
