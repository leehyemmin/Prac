package ex05;

public class ThreadEx01 {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r); // 생성자 Thread(Runnable target)
		
		t1.start();
		t2.start();
	}

}

class ThreadEx1_1 extends Thread{ // 1. Thread클래스를 상속해서 쓰레드를 구현
	public void run() { // 쓰레드가 수행할 작업을 작성
		for(int i=0; i<5; i++) {
			System.out.println(getName()); // 조상인 Thread의 getName()을 호출
		}
	}
}

class ThreadEx1_2 implements Runnable { // 2. Runnable인터페이스를 구현해서 쓰레드를 구현
	public void run() { // 쓰레드가 수행할 작업을 작성
		for(int i=0; i<5; i++) {
			// Thread.currentThread() - 현재 실행중인 Thread를 반환
			System.out.println(Thread.currentThread().getName());
		}
	}
}