package ex04;

import java.util.HashMap;

public class GenericsEx04 {

	public static void main(String[] args) {
		HashMap<String, Student> map = new HashMap<String, Student>();
		map.put("자바왕", new Student("자바왕", 1, 1, 100, 100, 100));
	
		Student s = map.get("d왕");
		
		System.out.println(map.get("자바왕").name);
	}

}


class Student{
	String name = "";
	int ban; // 반
	int no;  // 번호
	int kor;
	int eng;
	int math;
	
	Student(String name, int ban, int no, int kor, int eng, int math){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
}
