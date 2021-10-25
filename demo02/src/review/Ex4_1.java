package review;

class Product{
	int price;		// 제품의 가격
	int bonusPoint;	// 제품구매 시 제공하는 보너스점수
	
	Product(int price){
		this.price = price;
		this.bonusPoint = (int)(price/10.0);
	}
	
	Product() {} // 기본생성자
}

class Tv1 extends Product{
	Tv1() {super(100);}
	public String toString() {return "Tv";}
}

class Computer1 extends Product{
	Computer1() {super(200);}
	public String toString() {return "Computer";}
}

class Audio1 extends Product{
	Audio1() {super(50);}
	public String toString() {return "Audio";}
}

class Buyer{		// 고객
	int money = 1000;	// 소유금액
	int bonusPoint = 0;	// 보너스점수
	Product[] item = new Product[10]; // 구입한 제퓸을 저장하기 위한 배열
	int i = 0;	// Product배열에 사용될 카운터
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		
		money -= p.price;	// 가진 돈 - 구입한 제품의 가격
		bonusPoint += p.bonusPoint;	// 제품의 보너스 점수 추가
		item[i++] = p;	// 제픔을 Product[] item에 저장
		System.out.println(p + "을/를 구입하셨습니다.");
	}
	
	void summary() {	// 구매한 물품에 대한 정보 요약
		int sum = 0;	// 구입한 물품의 가격합계
		String itemList = "";	// 구입한 물품목록
		
		// 반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
		for(int i=0;i<item.length;i++) {
			if(item[i]==null) break;
			sum += item[i].price;
			itemList += item[i] + ",";
		}
		
		System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은 " + itemList + " 입니다.");
	}
}


public class Ex4_1 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.buy(new Tv1());
		b.buy(new Tv1());
		b.buy(new Computer1());

		b.summary();
		
		System.out.println("고객님의 보너스점수는 " + b.bonusPoint +  "입니다.");
		
	}

}
