package ex08;

public class DaoEx_2 {
	
	public static void dbWork(DataAccessObject_2 dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}
	
	public static void main(String[] args) {
		dbWork(new OracleDao_2());
		System.out.println();
		dbWork(new MySqlDao_2());
	}

}
