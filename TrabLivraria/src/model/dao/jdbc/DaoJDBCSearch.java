package model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Author;

public class DaoJDBCSearch {
	
	
	
    public void loadAuthors(ArrayList<Author> arrayList) {
    	try (Connection con = DriverManager.getConnection("", "", "")){
    		
    		final String querry = "SELECT * FROM Authors";
    		
    		Statement st = con.createStatement();
    		
    		ResultSet rs = st.executeQuery(querry);
    		
    		while (rs.next()) {
    			int id = rs.getInt("author_id");
    			String name = rs.getString("name");
    			String fname = rs.getString("fname");
    			
    			arrayList.add(new Author(id, name, fname));
    		}
    		
    		st.close();
    		
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
}
