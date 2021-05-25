package ex03;

import java.util.*;

public class VectorEx01 {

	public static void main(String[] args) {

		Vector v = new Vector(5); // 용량(capacity)이 5인 Vector를 생성
		v.add("1");
		v.add("2");
		v.add("3");
		print(v);
		
		v.trimToSize(); // 빈 공간을 제거(용량과 크기가 같아짐)
		System.out.println("=====After v.trimToSize()");
		print(v);
		
		v.ensureCapacity(6);
		System.out.println("===After ensureCapacity(6)");
		print(v);
		
		v.setSize(7); // 기억장소의 요소(데이터 저장공간 하나를 의미)크기를 지정
		System.out.println("=== After setSize(7)");
		print(v);
		
		v.clear();
		System.out.println("=== After clear()");
		print(v);
		
	}

	public static void print(Vector v) {

		System.out.println(v);
		System.out.println("size: " + v.size()); // 데이터 요소의 개수
		System.out.println("capacity: " + v.capacity());
	}

}
