package ex03;

import java.util.*;

public class HashSetEx03 {

	public static void main(String[] args) {

		HashSet set = new HashSet();
		
		set.add("abc");
		set.add("abc"); // 중복이라 저장 안됨.
		set.add(new Person("ham", 20));
		set.add(new Person("ham", 20));
		
		System.out.println(set);
	}
}	
	
// equals()와 hashCode()를 오버라이딩해야 HashSet이 바르게 동작
	class Person{
		String name;
		int age;
		
		Person(String name, int age){
			this.name = name;
			this.age = age;
		}
		
		public String toString() {
			return name + ":" + age;
		}
	}


