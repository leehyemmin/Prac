package ex08;

public class ActionEx_3 {
	public static void main(String[] args) {
		
		Action_3 action = new Action_3() {
			
			@Override
			public void work() {
				System.out.println("복사를 합니다.");
			}
		};
		
		action.work();
	}

}
