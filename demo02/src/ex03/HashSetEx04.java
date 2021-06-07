package ex03;

import java.util.*;

public class HashSetEx04 {

	public static void main(String[] args) {

		HashSet set = new HashSet();
		
		set.add("abc");
		set.add("abc"); // 중복이라 저장 안됨.
		set.add(new Person2("ham", 20));
		set.add(new Person2("ham", 20));
		
		System.out.println(set);
	}
}	
	
// equals()와 hashCode()를 오버라이딩해야 HashSet이 바르게 동작
	class Person2{
		String name;
		int age;
		
		Person2(String name, int age){
			this.name = name;
			this.age = age;
		}
		
		@Override
		public int hashCode() {
			// int hash(Object... values); // 가변인자
			return Objects.hash(name, age);
		}

		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof Person2)) return false;
			
			Person2 p2 = (Person2)obj;
			
			// 나자신(this)의 이름과 나이를 p2와 비교
			return this.name.equals(p2.name) && this.age==p2.age;
		}

		public String toString() {
			return name + ":" + age;
		}
	}


