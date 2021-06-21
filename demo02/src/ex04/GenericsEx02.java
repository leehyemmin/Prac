package ex04;

import java.util.ArrayList;

class Tv{}
class Audio{}

public class GenericsEx02 {

	public static void main(String[] args) {
		
		ArrayList<Tv> list = new ArrayList<Tv>(); // Tv 타입의 객체만 저장가능
		list.add(new Tv());
//		list.add(new Audio());
	}

}
