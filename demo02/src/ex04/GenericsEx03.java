package ex04;

import java.util.*;

class Product{}
class Tv1 extends Product{}
class Audio1 extends Product{}


public class GenericsEx03 {

	public static void main(String[] args) {

		ArrayList<Product> productList = new ArrayList<>();
		ArrayList<Tv> tvList = new ArrayList<Tv>();
//		ArrayList<Product> tvList = new ArrayList<Tv>(); // 에러
//		List<Tv> tvList = new ArrayList<Tv>(); // Ok. 다형성
		
		productList.add(new Tv1());
		productList.add(new Audio1());
		
		tvList.add(new Tv());
		tvList.add(new Tv());
//		tvList.add(new Audio()); // 에러
		
		printAll(productList);
//		printAll(tvList); // 컴파일 에러 발생
	}

	public static void printAll(ArrayList<Product> list) {
		for(Product p : list)
			System.out.println(p);
	}

}
