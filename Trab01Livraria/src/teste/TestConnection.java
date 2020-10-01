package teste;

import dao.DAOJDBC;
import entity.Author;

public class TestConnection {

	
	public static void main(String[] args) {
		DAOJDBC dao = new DAOJDBC();
		
		dao.testConnection();
		
		Author felipe = new Author(5698, "Scherer", "Felipe");
		
		System.out.println(felipe);
		
	}
}
