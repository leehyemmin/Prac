package ex05;

// suspend(), resume(), stop()  - Ex2

public class ThreadEx10_2 {
	public static void main(String[] args) {
		MyThread th1 = new MyThread("*");
		MyThread th2 = new MyThread("**");
		MyThread th3 = new MyThread("***");
		
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			th1.suspend();  // 쓰레드 th1을 잠시 중단시킴
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();  // 쓰레드 th1이 다시 동작하도록 함
			Thread.sleep(3000);
			th1.stop();   // 쓰레드 th1을 강제종료
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		}catch (InterruptedException e) {}
	}

}


class MyThread implements Runnable{
	volatile boolean suspended = false;  // 쉽게 바뀌는 변수
	volatile boolean stopped = false;
	
	Thread th;
	
	MyThread(String name){
		th = new Thread(this, name);  // Thread(Runnable r, String name)
	}
	
	void start() {
		th.start();
	}
	
	void stop() {
		stopped = true;
	}
	
	void suspend() {
		suspended = true;
	}
	
	void resume() {
		suspended = false;
	}
	
	public void run() {
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
			}
		}
	}
}