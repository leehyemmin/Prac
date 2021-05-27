package ex03;

import java.util.Stack;

public class StackEx01 {
	
	// LIFO
	public static Stack back = new Stack(); // 뒤로: 히스토리 저장
	public static Stack forward = new Stack(); // 앞으로: 히스토리 저장
	
	public static void main(String[] args) {
		goURL("1. 네이버");
		goURL("2. 야후");
		goURL("3. 네이트");
		goURL("4. 다음");
		
		printStatus();
		
		goBack();
		System.out.println("뒤로가기 버튼");
		printStatus();
		
		goBack();
		System.out.println("뒤로가기 버튼");
		printStatus();
		
		goForward();
		System.out.println("앞으로 가기 버튼");
		printStatus();
		
		goURL("new site");
		System.out.println("새로운 주소로 이동");
		printStatus();
	}




	public static void goURL(String url) {
		back.push(url);
		if(!forward.empty()) forward.clear();
	}
	
	public static void printStatus() {
		System.out.println("back: " + back);
		System.out.println("forward: " + forward);
		System.out.println("현재화면은 " + back.peek() + " 입니다.");
		System.out.println();
	}

	public static void goBack() {
		if(!back.empty()) forward.push(back.pop());
	}

	public static void goForward() {
		if(!forward.empty()) back.push(forward.pop());
	}
	
}
