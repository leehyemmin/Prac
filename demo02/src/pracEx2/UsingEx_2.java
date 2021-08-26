package pracEx2;

public class UsingEx_2 {

	public int add(int a, int b) {
		return (a + b);
	}
	
	public int sub(int a, int b) throws MyZeroException_2{
		if (b == 0) {
			throw new MyZeroException_2("0으로 나누지 마라");
		}
		return (a/b);
	}
	
	public int subs(int a, int b) throws MyZeroException_2{
		return sub(a, b);
	}
	
	public int adds(int a, int b) {
		return (a/b);
	}
}
