package ex05;

public class UsingEx {

	public int add(int a, int b) {
		return (a + b);
	}
	
	public int sub(int a, int b) throws MyZeroException {
		if (b == 0) {
			throw new MyZeroException("0으로 나누지 마라.");
		}
		 
		return (a / b);
	}
	
	public int subs(int a, int b) throws MyZeroException {
		return sub(a , b);
	}
	
	public int adds(int a, int b) {
		return (a/b);
	}
}
