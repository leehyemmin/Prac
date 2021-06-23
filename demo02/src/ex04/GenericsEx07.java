package ex04;

// 지네릭 타입의 형변환

import java.util.ArrayList;

class Fruit3 implements Eatable3{
	public String toString() {return "Fruit";}
}
class Apple3 extends Fruit3 {public String toString() {return "Apple";}}
class Grape3 extends Fruit3 {public String toString() {return "Grape";}}
class Toy3 				  {public String toString() {return "Toy";}}

interface Eatable3{}

public class GenericsEx07 {
	public static void main(String[] args) {
		FruitBox3<? extends Fruit3> fbox = (FruitBox3<? extends Fruit3>)new FruitBox3<Fruit3>();
		// FruitBox3<Apple3> -> FruitBox<? extends Fruit3> 가능
		FruitBox3<? extends Fruit3> abox = new FruitBox3<Apple3>();
		
		// FruitBox3<? extends Fruit3> -> FruitBox3<Apple3> 가능? 가능!
		FruitBox3<Apple3> appleBox = (FruitBox3<Apple3>)abox;	// Ok. 경고발생.  (FruitBox3<Apple3>)생략 불가
	}

}


class FruitBox3<T extends Fruit3 & Eatable3> extends Box3<T>{}

class Box3<T>{
	ArrayList<T> list = new ArrayList<T>(); // item을 저장할 list
	void add(T item) {list.add(item);}	// 박스에 item을 추가
	T get(int i) {return list.get(i);} // 박스에서 item을 꺼낼때
	int size()	 {return list.size();}
	public String toString() {return list.toString();}
}