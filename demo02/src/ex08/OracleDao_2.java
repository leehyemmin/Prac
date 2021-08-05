package ex08;

public class OracleDao_2 implements DataAccessObject_2 {

	@Override
	public void select() {
		System.out.println("Orcle DB에서 검색");
	}

	@Override
	public void insert() {
		System.out.println("Orcle DB에서 삽입");
	}

	@Override
	public void update() {
		System.out.println("Orcle DB에서 수정");
	}

	@Override
	public void delete() {
		System.out.println("Orcle DB에서 삭제");
	}
	
}
