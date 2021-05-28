package ex03;

import java.util.*;

public class IteratorEx02 {

	public static void main(String[] args) {
		
		HashSet s = new HashSet();
		
		s.add("1");
		s.add("2");
		s.add("3");
		s.add("4");
		s.add("5");
		
		System.out.println(s);
		
		Iterator it = s.iterator();
		
		String str = "";
		while(it.hasNext()) {
			str += (String) it.next() + ",";
		}
		
		System.out.println(str);
	}

}
