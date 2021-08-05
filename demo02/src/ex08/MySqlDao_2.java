package ex08;

public class MySqlDao_2 implements DataAccessObject_2 {

	@Override
	public void select() {
		System.out.println("MySql DB에서 검색");
	}

	@Override
	public void insert() {
		System.out.println("MySql DB에서 삽입");
	}

	@Override
	public void update() {
		System.out.println("MySql DB에서 수정");
	}

	@Override
	public void delete() {
		System.out.println("MySql DB에서 삭제");
	}

}
