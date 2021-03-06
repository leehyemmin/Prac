package ex04;
//				0		1	  2		3
enum Direction11{EAST, SOUTH, WEST, NORTH}

public class EnumEx01 {
	public static void main(String[] args) {

		Direction11 d1 = Direction11.EAST; // 열거형타입.상수이름
		Direction11 d2 = Direction11.valueOf("WEST");
		Direction11 d3 = Enum.valueOf(Direction11.class, "EAST");
		
		System.out.println("d1= " + d1);
		System.out.println("d2= " + d2);
		System.out.println("d3= " + d3);
		
		System.out.println("d1 = d2 ? " + (d1 == d2)); // false
		System.out.println("d1 = d3 ? " + (d1 == d3)); // true
		System.out.println("d1.equals(d3) ? " + d1.equals(d3));
//		System.out.println("d2 > d3 ? " + (d2 > d3)); // 에러
		System.out.println("d1.compareTo(d3) ? " + (d1.compareTo(d3)));
		System.out.println("d1.compareTo(d2)" + (d1.compareTo(d2))); // d1=0, d2=2 .. d1-d2=-2
		
		switch(d1){
			case EAST: // Direction.EAST라고 쓸 수 없음.
				System.out.println("The direction is EAST"); break;
			case SOUTH:
				System.out.println("The direction is SOUTH"); break;
			case WEST:
				System.out.println("The direction is WEST"); break;
			case NORTH:
				System.out.println("The direction is NORTH"); break;
			default:
				System.out.println("Invaild direction"); break;
		}
		
		Direction[] dArr = Direction.values();  // 열거형의 모든 상수를 배열로 반환
		
		System.out.println("Direction11 열거형의 개수? " + dArr.length);
		
		for(Direction d : dArr)
			System.out.printf("%s=%d%n",d.name(),d.ordinal());
		
		
	}

}
