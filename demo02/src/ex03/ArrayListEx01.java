package ex03;

import java.util.*;

public class ArrayListEx01 {

	public static void main(String[] args) {
		// 제네릭(Generic)은 참조형만 사용
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(new Integer(5)); // 0
		list1.add(new Integer(4)); // 1
		list1.add(new Integer(2)); // 2
		list1.add(new Integer(0)); // 3
		list1.add(new Integer(1)); // 4
		list1.add(new Integer(3)); // 5
		
		ArrayList<Integer> list2 = new ArrayList<>(list1.subList(1,4));
		print(list1,list2);
		
		
		// Collection은 인터페이스
		// Collectoins는 유틸 클래스
		
		Collections.sort(list1);
		Collections.sort(list2);
		
		print(list1,list2);
		
		System.out.println("list1.containsAll(list2) ? " + list1.contains(list2));
		
		list2.add(10); // 10 -> new Integer(10); 자동박싱
		list2.add(2);
		list2.add(1, 5); // 인덱스 1위치에 데이터 5를 삽입
		
		print(list1, list2);
		
		list2.set(1, 50); // 인덱스 1위치에 데이터 5를 50으로 변경
		
		print(list1, list2);
		
		for(int i=list2.size()-1; i>=0; i--) {
			if(list1.contains(list2.get(i))) {
				list2.remove(i);
			}
		}
		
		print(list1,list2);
		
	}

	// 객체의 데이터를 출력하는 목적
	private static void print(List<Integer> list1, List<Integer> list2) {
		System.out.println("list1 " + list1);
		System.out.println("list2 " + list2);
		System.out.println();
	}

	

}
