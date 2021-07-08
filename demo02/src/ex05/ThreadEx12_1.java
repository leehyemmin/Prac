package ex05;

// synchronized
// 동기화 되어있는 예제

public class ThreadEx12_1 {

	public static void main(String[] args) {
		Runnable r = new RunnableEx12_1();
		new Thread(r).start();
		new Thread(r).start();
	}

}


class Account2 {
	private int balance = 1000;
	
	public synchronized int getBalance() {
		return balance;
	}
	
	public synchronized void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
			balance -= money;
		}
	}
}

class RunnableEx12_1 implements Runnable{
	Account2 acc = new Account2();
	
	public void run() {
		while(acc.getBalance()>0) {
			// 100, 200, 300 중의 한 값을 임의로 선택해서 출금(withdraw)
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance: " + acc.getBalance());
		}
	}
}