package ex07;

public class Student {
	private String studentNum;
	
	public Student(String studentNum) {
		this.studentNum = studentNum;
	}
	
	public String getStudentNum() {
		return studentNum;
	}
	
	
	public boolean equals(Object obj) {
		
		if(obj != null && obj instanceof Student ) {
			return studentNum == ((Student)obj).studentNum;
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return studentNum.hashCode();
	}
}
