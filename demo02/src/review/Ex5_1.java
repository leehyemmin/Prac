package review;

public class Ex5_1 {
	public static void main(String[] args) {
		Unit[] group = {new Marine(), new Tank(), new Dropship()};
		
		for (int i=0; i<group.length; i++)
			group[i].move(100, 200);
	}

}

abstract class Unit {
	int x, y;
	abstract void move(int x, int y);
	void stop() { /* 현재 위치에서 정지 */}
}

class Marine extends Unit{
	void move(int x, int y){
		System.out.println("Marine[x=" + x + ",y=" + y + "]");
	}
	void stimPack() { /*스팀팩을 사용한다. */}
}

class Tank extends Unit{
	void move(int x, int y){
		System.out.println("Tank[x=" + x + ",y=" + y + "]");
	}
	void changeMode() { /* 공격모드를 변환 */}
}

class Dropship extends Unit{
	void move(int x, int y){
		System.out.println("Dropship[x=" + x + ",y=" + y + "]");
	}
	void load() { /* 선택된 대상을 태운다*/ }
	void unload() { /* 선택된 대상을 내린다*/ }
}