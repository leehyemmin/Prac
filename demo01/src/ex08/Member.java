package ex08;

public class Member {

	private String id;
	private String name;
	
	public Member(String id, String name) {
		this.id =id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "id= " + id + " : " + "name= " + name ;
	}
}
