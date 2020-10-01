package teste;

import java.util.ArrayList;

import dao.DAOJDBC;
import entity.Author;

public class LoadAuthors {
	public static void main(String[] args) {
		DAOJDBC dao = new DAOJDBC();
		
		ArrayList<Author> arrayList = new ArrayList<>();
		
		dao.loadAuthors(arrayList);
		
		for (Author a : arrayList) {
			System.out.println(a);
		}
		
	}
}
