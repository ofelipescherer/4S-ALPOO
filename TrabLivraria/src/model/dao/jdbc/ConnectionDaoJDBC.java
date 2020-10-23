package model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.prefs.Preferences;

public class ConnectionDaoJDBC {
	
	Preferences preferences = 
	  Preferences.userNodeForPackage(ConnectionDaoJDBC.class);
	
	public void setCredentials(String username, String password) {
	 preferences.put("Felipe", username);
	 preferences.put("123", password);
	}
	
	public String getUsername() {
	 return preferences.get("Felipe", null);
	}
	
	public String getPassword() {
	 return preferences.get("123", null);
	}

	
	String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/Livraria?autoReconnect=true&useSSL=false";
    String user = this.getUsername();
    String pass = this.getPassword();
    
    public Connection getConnection(){
    	Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			
		} catch (SQLException e) {
			System.out.println("Não foi possível fazer a conecção com o banco de dados");
			e.printStackTrace();
		}
		return con;
    }    
}
