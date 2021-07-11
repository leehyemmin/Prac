package ex05;

import java.util.ArrayList;

// wait(), notify() 사용하기 전
// 동기화O

public class ThreadWaitEx2 {
	public static void main(String[] args) throws Exception {
		Table2 table = new Table2(); // 여러 쓰레드가 공유하는 객체
		
		new Thread(new Cook2(table), "COOK1").start();
		new Thread(new Customer2(table, "donut"), "CUST1").start();
		new Thread(new Customer2(table, "burger"), "CUST2").start();
		
		Thread.sleep(5000);
		System.exit(0);
		
	}

}


class Customer2 implements Runnable {
	private Table2 table;
	private String food;
	
	Customer2(Table2 table, String food){
		this.table = table;
		this.food = food;
	}
	
	public void run() {
		while(true) {
			try {Thread.sleep(10);} catch(InterruptedException e) {}
			String name = Thread.currentThread().getName();
			
			if(eatFood())
				System.out.println(name + " ate a " + food);
			else
				System.out.println(name + " failed to eat. : (");
		}
	}
	
	boolean eatFood() {return table.remove(food);}
}

class Cook2 implements Runnable{
	private Table2 table;
	
	Cook2(Table2 table){this.table = table;}
	
	public void run() {
		while(true) {
			// 임의의 요리를 하나 선택해서 table에 추가한다
			int idx = (int)(Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			
			try {Thread.sleep(100);} catch (InterruptedException e) {}
		}
	}
}

class Table2{
	String[] dishNames = {"donut", "donut", "burger"}; // donut이 더 자주 나온다.
	final int MAX_FOOD = 6; // 테이블에 놓을 수 있는 최대 음식의 개수
	
	private ArrayList<String> dishes = new ArrayList<>();
	
	public synchronized void add(String dish) {
		//테이블에 음식이 가득찼으면, 테이블에 음식을 추가하지 않는다.
		if(dishes.size() >= MAX_FOOD)
			return;
		dishes.add(dish);
		System.out.println("Dishes: " + dishes.toString());
	}
	
	public boolean remove(String dishName) {
		synchronized (this) {
			while(dishes.size()==0) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting.");
				try {Thread.sleep(500);} catch(InterruptedException e) {}
			}
		
		// 지정된 요리와 일치하는 요리를 테이블에서 제거한다.
		for(int i=0; i<dishes.size(); i++)
			if(dishName.equals(dishes.get(i))) {
				dishes.remove(i);
				return true;
			}
		}
		return false;
	}
	public int dishNum() { return dishNames.length;}
}

