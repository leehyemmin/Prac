package ex02;

public class DaoEx {

	public static void dbWork(DataAccessObj dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}
	
	
	public static void main(String[] args) {
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
	}

}

/* 실행결과
Oracle DB에서 검색
Oracle DB에서 삽입
Oracle DB에서 수정
Oracle DB에서 삭제
MySql DB에서 검색
MySql DB에서 삽입
MySql DB에서 수정
MySql DB에서 삭제
*/