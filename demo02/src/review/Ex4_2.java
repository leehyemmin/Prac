package review;

import java.util.Vector;

class Product2{
	int price;		// 제품의 가격
	int bonusPoint;	// 제품구매 시 제공하는 보너스점수
	
	Product2(int price){
		this.price = price;
		this.bonusPoint = (int)(price/10.0);
	}
	
	Product2() {} // 기본생성자
}

class Tv2 extends Product2{
	Tv2() {super(100);}
	public String toString() {return "Tv";}
}

class Computer2 extends Product2{
	Computer2() {super(200);}
	public String toString() {return "Computer";}
}

class Audio2 extends Product2{
	Audio2() {super(50);}
	public String toString() {return "Audio";}
}

class Buyer2{		// 고객
	int money = 1000;	// 소유금액
	int bonusPoint = 0;	// 보너스점수
	Vector item = new Vector();	// 구입한 제품을 저장하는데 사용될 Vetor객체
	
	void buy(Product2 p) {
		if(money < p.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		
		money -= p.price;	// 가진 돈 - 구입한 제품의 가격
		bonusPoint += p.bonusPoint;	// 제품의 보너스 점수 추가
		item.add(p);	// 구입한 제품을 Vector에 저장
		System.out.println(p + "을/를 구입하셨습니다.");
	}
	
	void refund(Product2 p) {	// 구입한 제품을 환불
		if(item.remove(p)) {	// 제품을 Vector에서 제거
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "을/를 반품하셨습니다.");
		}else {	// 제거에 실패한 경
			System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
		}
	}
	
	void summary() {	// 구매한 물품에 대한 정보 요약
		int sum = 0;	// 구입한 물품의 가격합계
		String itemList = "";	// 구입한 물품목록
		
		if(item.isEmpty()) { //Vector가 비어있는지 확인
			System.out.println("구입하신 제품이 없습니다.");
			return;
		}
		
		// 반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
		for(int i=0;i<item.size();i++) {
			Product2 p = (Product2)item.get(i);	// Vector의 i번째에 있는 객체를 얻어옴.
			sum += p.price;
			itemList += (i==0) ? "" + p : "," + p;
		}
		
		System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은 " + itemList + " 입니다.");
	}
}


public class Ex4_2 {
	public static void main(String[] args) {
		Buyer2 b = new Buyer2();
		Tv2 tv = new Tv2();
		Computer2 com = new Computer2();
		Audio2 audio = new Audio2();
		
		b.buy(tv);
		b.buy(com);
		b.buy(audio);
		b.summary();
		
		System.out.println();
		
		b.refund(audio);
		b.summary();
		
		System.out.println("고객님의 보너스점수는 " + b.bonusPoint +  "입니다.");
		
	}

}
