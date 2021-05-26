package ex03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedList {

	public static void main(String[] args) {
		
		ArrayList al = new ArrayList(2000000);
		LinkedList ll = new LinkedList();
		
		System.out.println("순차적으로 추가");
		System.out.println("ArrayList: " + add1(al));
		System.out.println("LinkedList: " + add1(ll));
		System.out.println();
		System.out.println("중간추가(삽입)");
		System.out.println("ArrayList: " + add2(al));
		System.out.println("LinkedList: " + add2(ll));
		System.out.println();
		System.out.println("중간 삭제");
		System.out.println("ArrayList: " + remove2(al));
		System.out.println("LinkedList: " + remove2(ll));
		System.out.println();
		System.out.println("순차 삭제");
		System.out.println("ArrayList: " + remove1(al));
		System.out.println("LinkedList: " + remove1(ll));
		
	}
	
	// 추가
	public static long add1(List list) {  // 다형성
		long start = System.currentTimeMillis();
		for(int i=0; i<1000000; i++) list.add(i+"");
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	// 중간에 추가. 삽입
	public static long add2(List list) {
		long start = System.currentTimeMillis();
		for(int i=0; i<10000; i++) list.add(500, "X");
		long end = System.currentTimeMillis();
		return end - start;
	}

	// 제거 : 뒤
	public static long remove1(List list) {
		long start = System.currentTimeMillis();
		for(int i=list.size()-1; i>=0; i--) list.remove(i); // 데이터를 뒤에서부터 제거
		long end = System.currentTimeMillis();
		return end - start;
	} 
	
	// 제거 : 앞
	public static long remove2(List list) {
		long start = System.currentTimeMillis();
		for(int i=0; i<10000; i++) list.remove(i); // 데이터를 앞에서부터 제거
		long end = System.currentTimeMillis();
		return end - start;
	}
}
