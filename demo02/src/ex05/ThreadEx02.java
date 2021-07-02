package ex05;

// main쓰레드

public class ThreadEx02 {
	static long startTime = 0;
	
	public static void main(String[] args) {

		ThreadEx2_1 th1 = new ThreadEx2_1();
		ThreadEx2_2 th2 = new ThreadEx2_2();
		
		th1.start();
		th2.start();
		startTime = System.currentTimeMillis();
		
		try {
			th1.join();  // main쓰레드가 th1의 작업이 끝날때까지 기다린다
			th2.join();  // main쓰레드가 th2의 작업이 끝날때까지 기다린다
		}catch(InterruptedException e) {}
		
		System.out.println("소요시간: " + (System.currentTimeMillis() - startTime));
	}

}

class ThreadEx2_1 extends Thread {
	public void run() {
		for(int i=0; i< 300; i++)
		System.out.print(new String("-"));
	}
}

class ThreadEx2_2 extends Thread {
	public void run() {
		for(int i=0; i< 300; i++)
		System.out.print(new String("|"));
	}
}
	