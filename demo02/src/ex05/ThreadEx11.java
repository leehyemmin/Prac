package ex05;

// join()

public class ThreadEx11 {
	static long startTime = 0;
	
	public static void main(String[] args) {
		ThreadEx11_1 th1 = new ThreadEx11_1();
		ThreadEx11_2 th2 = new ThreadEx11_2();

		th1.start();
		th2.start();
		startTime = System.currentTimeMillis();  // 시작시간
		
		try {
			th1.join();  // main쓰레드가 th1의 작업이 끝날때까지 기다린다.
			th2.join();
		}catch(InterruptedException e) {}
		
		System.out.print("소요시간: " + (System.currentTimeMillis() - startTime));
	}

}


class ThreadEx11_1 extends Thread {
	public void run() {
		for(int i=0; i<300;i++) {
			System.out.print("-");
			for(int x=0; x<100000000; x++); // 시간지연용 for문
		}
	}
}

class ThreadEx11_2 extends Thread {
	public void run() {
		for(int i=0; i<300;i++) {
			System.out.print("|");
			for(int x=0; x<100000000; x++);
		}
	}
}