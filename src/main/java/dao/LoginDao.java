package dao;

import java.sql.ResultSet;
import java.sql.Statement;

import model.Login;

public class LoginDao {
	/*
	 * This class handles all the database operations related to login functionality
	 */
	
	
	public Login login(String username, String password) {
		/*
		 * Return a Login object with role as "manager", "customerRepresentative" or "customer" if successful login
		 * Else, return null
		 * The role depends on the type of the user, which has to be handled in the database
		 * username, which is the email address of the user, is given as method parameter
		 * password, which is the password of the user, is given as method parameter
		 * Query to verify the username and password and fetch the role of the user, must be implemented
		 */
// select distinct * from person p left join (customer c) ON p.id = c.id where email = 'janesmith@gmail.com'
		
		/*Sample data begins*/
		Login login = new Login();
		try {
			Statement st = Connections.generateStatement();	
			ResultSet rs = st.executeQuery("SELECT DISTINCT * FROM person p "
					+ "WHERE p.email = \'" + username + "\' AND p.password = \'" + password + "\'");
			
			if(!rs.next()) {
				return null;
			}
			
			st = Connections.generateStatement();	
			rs = st.executeQuery("SELECT DISTINCT * FROM person p, employee e"
					+ " WHERE e.id = p.id AND p.email = \'" + username + "\' AND p.password = \'" + password + "\'");
			
			if(!rs.next()) {
				login.setRole("customer");
			}
			else {
				if(rs.getBoolean("IsManager")) {
					login.setRole("manager");
				}
				else {
					login.setRole("customerRepresentative");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return login;
		/*Sample data ends*/
		
	}
	
	public String addUser(Login login) {
		/*
		 * Query to insert a new record for user login must be implemented
		 * login, which is the "Login" Class object containing username and password for the new user, is given as method parameter
		 * The username and password from login can get accessed using getter methods in the "Login" model
		 * e.g. getUsername() method will return the username encapsulated in login object
		 * Return "success" on successful insertion of a new user
		 * Return "failure" for an unsuccessful database operation
		 */
		
		/*Sample data begins*/
		try {
			Statement st = Connections.generateStatement();	
			st.executeQuery("INSERT INTO person (email, password) "
					+ "VALUES (\'"+ login.getUsername() +"\', \'"+ login.getPassword() +"\')");
			
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}
		return "success";
		/*Sample data ends*/
	}

}
