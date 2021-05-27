package ex03;

import java.util.EmptyStackException;
import java.util.Stack;

// 괄호가 올바른지 체크하는 예제
public class ExpValidCheck {

	public static void main(String[] args) {

		Stack st = new Stack();
		String expression = "((7+3)*3-1)";
		
		System.out.println("expression" + expression);
		
		try {
			for(int i=0; i<expression.length(); i++) {
				char ch = expression.charAt(i);
				
				if (ch == '(') {
					st.push(ch + "");
				}else if(ch == ')') {
					st.pop();
				}
			}
			
			if(st.isEmpty()) {
				System.out.println("괄호가 일치합니다.");
			}else {
				System.out.println("괄호가 일치하지 않습니다.");
			}
			
		}catch (EmptyStackException e) {
			// 닫는 괄호 더 많을때
			System.out.println("예외 : 괄호가 일치하지 않습니다.");
		}
	}

}
