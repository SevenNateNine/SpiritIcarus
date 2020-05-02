package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connections {
	
	public static Statement generateStatement() {
		String user = "root";
		String password = "qnzMxS7qAB^@qm";
		String url = "jdbc:mysql://localhost:3306/cse305";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			return st;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
}
