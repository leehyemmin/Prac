package ex12;

public class wrapper01 {

	public static void main(String[] args) {

		Integer i = new Integer(100);
		Integer i2 = new Integer(100);
		
		System.out.println("i==i2 ? " + (i==i2));
		System.out.println("i.equals(i2) ? " + i.equals(i2));
		
		// 같으면 0, 오른쪽이 작으면 양수, 오른쪽이 크면 음수
		System.out.println("i.compareTo(i2)= " + i.compareTo(i2)); 
		System.out.println("i.toString()= " + i.toString());
		
		System.out.println("MAX_VALUE= " + Integer.MAX_VALUE);
		System.out.println("MIN_VALUE= " + Integer.MIN_VALUE);
		System.out.println("SIZE= " + Integer.SIZE + " bites");
		System.out.println("BYTES= " + Integer.BYTES + " bytes");
		System.out.println("TYPE= " + Integer.TYPE);
	}

}

/* 실행결과
 i==i2 ? false
i.equals(i2) ? true
i.compareTo(i2)= 0
i.toString()= 100
MAX_VALUE= 2147483647
MIN_VALUE= -2147483648
SIZE= 32 bites
BYTES= 4 bytes
TYPE= int
 */