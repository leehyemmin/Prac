package ex01;

public class SoundableEx {

	private static void printSound(Soundable soundable) {
		
		System.out.println(soundable.sound());
	}
	
	public static void main(String[] args) {
		printSound(new cat());
		printSound(new dog());
	}

}

// 실행결과
// 야옹
// 멍멍