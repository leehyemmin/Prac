package ex10;

public class str05 {

	public static void main(String[] args) {

		// Wrapper클래스를 이용한 기본형변환 문법패턴
		byte b = Byte.parseByte("5");
		short s = Short.parseShort("5");
		int i = Integer.parseInt("5");
		long l = Long.parseLong("5");
		
		float f = Float.parseFloat("5.0");
		double d = Double.parseDouble("5.0");
		
		boolean bool = Boolean.parseBoolean("true");
	}

}
