package ex02;

import java.text.MessageFormat;

public class MessageFormatEx01 {

	public static void main(String[] args) {
		String msg = "Name: {0} \nTel: {1}Age: {2} \nBirthday: {3}";
		
		
		// 가변배열: 배열크기가 고정이 안된 배열
		
		Object[] argument = {
				"홍길동", "010-5555-5555", "100", "2021-01"
		};
		
		String result = MessageFormat.format(msg, argument);
		System.out.println(result);
	}

}
