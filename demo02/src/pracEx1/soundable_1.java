package pracEx1;

import pracEx1.sound_1.Soundable;

public class soundable_1 {
	
	private static void printSound(Soundable soundable){
		System.out.println(soundable.sound());
	}
	
	public static void main(String[] args) {
		printSound(new Cat_1());
		printSound(new Dog_1());
	}

}


