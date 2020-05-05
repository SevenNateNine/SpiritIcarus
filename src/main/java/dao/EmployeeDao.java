package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Employee;

public class EmployeeDao {
	/*
	 * This class handles all the database operations related to the employee table
	 */
	
	public String addEmployee(Employee employee) {

		/*
		 * All the values of the add employee form are encapsulated in the employee object.
		 * These can be accessed by getter methods (see Employee class in model package).
		 * e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database insertion of the employee details and return "success" or "failure" based on result of the database insertion.
		 */
		try {
			Statement st = Connections.generateStatement();	
			ResultSet rs = st.executeQuery("INSERT INTO person (Email, FirstName, LastName, Address, City, State, ZipCode)"
					+ " VALUES (\'" + employee.getEmail() + "\', \'" + employee.getFirstName() + "\',"
						+ " \'" + employee.getLastName() + "\', \'" + employee.getAddress() + "\',"
						+ " \'" + employee.getCity() + "\', \'" + employee.getState() + "\',"
						+ employee.getZipCode() + ")");
			if(rs.next()) {
				st.executeQuery("INSERT INTO employee (Id, SSN, IsManager, StartDate, HourlyRate) VALUES"
						+ " (" + rs.getInt("Id") + ", " + Integer.parseInt(employee.getSSN()) + ", " + employee.getIsManager() 
						+ ", \'" + employee.getStartDate() + "\', " + employee.getHourlyRate() + ")");
			}
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/

	}

	public String editEmployee(Employee employee) {
		/*
		 * All the values of the edit employee form are encapsulated in the employee object.
		 * These can be accessed by getter methods (see Employee class in model package).
		 * e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database update and return "success" or "failure" based on result of the database update.
		 */
		
		try {
			Statement st = Connections.generateStatement();	
			st.executeQuery("UPDATE Employee E INNER JOIN Person P ON (E.Id = P.Id)"
					+ "SET E.IsManager = " + employee.getIsManager() + ", E.HourlyRate = " + employee.getHourlyRate() + ","
					+ " E.StartDate = \'" + employee.getStartDate() + "\', P.FirstName = \'" + employee.getFirstName() + "\',"
					+ " P.LastName = \'" + employee.getLastName() + "\', P.Address = \'" + employee.getAddress() + "\',"
					+ " P.City = \'" + employee.getCity()  + "\', P.State = \'" + employee.getState() + "\',"
					+ " P.Zipcode = " + employee.getZipCode() + " WHERE SSN = " + Integer.parseInt(employee.getSSN()));
		}
		catch(Exception e) {
			return "failure";
		}
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/

	}

	public String deleteEmployee(String SSN) {
		/*
		 * SSN, which is the Employee's SSN which has to be deleted, is given as method parameter
		 * The sample code returns "success" by default.
		 * You need to handle the database deletion and return "success" or "failure" based on result of the database deletion.
		 */
		
		try {
			Statement st = Connections.generateStatement();	
			st.executeQuery("DELETE FROM Employee WHERE SSN = " + Integer.parseInt(SSN));
			
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/

	}

	
	public List<Employee> getEmployees() {

		/*
		 * The students code to fetch data from the database will be written here
		 * Query to return details about all the employees must be implemented
		 * Each record is required to be encapsulated as a "Employee" class object and added to the "employees" List
		 */

		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			Statement st = Connections.generateStatement();	
			ResultSet rs = st.executeQuery("SELECT P.FirstName, P.LastName, P.Email, P.Address,"
					+ " P.City, P.State, P.ZipCode, E.HourlyRate, E.IsManager, E.SSN" + 
					" FROM Employee E, Person P" + 
					" WHERE E.Id = P.Id");
			
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setAddress(rs.getString("Address"));
				employee.setLastName(rs.getString("LastName"));
				employee.setFirstName(rs.getString("FirstName"));
				employee.setCity(rs.getString("City"));
				employee.setState(rs.getString("State"));
				employee.setEmail(rs.getString("Email"));
				employee.setZipCode(rs.getInt("ZipCode"));
				employee.setHourlyRate(rs.getFloat("HourlyRate"));
				employee.setIsManager(rs.getBoolean("IsManager"));
				employee.setSSN(Integer.toString(rs.getInt("SSN")));
				employees.add(employee);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		/*Sample data begins*/
//		for (int i = 0; i < 10; i++) {
//			Employee employee = new Employee();
//			employee.setEmail("shiyong@cs.sunysb.edu");
//			employee.setFirstName("Shiyong");
//			employee.setLastName("Lu");
//			employee.setAddress("123 Success Street");
//			employee.setCity("Stony Brook");
//			employee.setStartDate("2006-10-17");
//			employee.setState("NY");
//			employee.setZipCode(11790);
//			employee.setSSN("6314135555");
//			employee.setHourlyRate(100);
//			employee.setIsManager(true);
//			
//			employees.add(employee);
//		}
		/*Sample data ends*/
		
		return employees;
	}

	public Employee getEmployee(String SSN) {

		/*
		 * The students code to fetch data from the database based on "SSN" will be written here
		 * SSN, which is the Employee's SSN who's details have to be fetched, is given as method parameter
		 * The record is required to be encapsulated as a "Employee" class object
		 */

		Employee employee = new Employee();
		
		try {
			Statement st = Connections.generateStatement();	
			ResultSet rs = st.executeQuery("SELECT P.FirstName, P.LastName, P.Email, P.Address,"
					+ " P.City, P.State, P.ZipCode, E.HourlyRate, E.IsManager, E.SSN" + 
					" FROM Employee E, Person P" + 
					" WHERE E.SSN = " + Integer.parseInt(SSN));
			
			while(rs.next()) {
				employee.setAddress(rs.getString("Address"));
				employee.setLastName(rs.getString("LastName"));
				employee.setFirstName(rs.getString("FirstName"));
				employee.setCity(rs.getString("City"));
				employee.setState(rs.getString("State"));
				employee.setEmail(rs.getString("Email"));
				employee.setZipCode(rs.getInt("ZipCode"));
				employee.setHourlyRate(rs.getFloat("HourlyRate"));
				employee.setIsManager(rs.getBoolean("IsManager"));
				employee.setSSN(Integer.toString(rs.getInt("SSN")));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		/*Sample data begins*/
//		employee.setEmail("shiyong@cs.sunysb.edu");
//		employee.setFirstName("Shiyong");
//		employee.setLastName("Lu");
//		employee.setAddress("123 Success Street");
//		employee.setCity("Stony Brook");
//		employee.setStartDate("2006-10-17");
//		employee.setState("NY");
//		employee.setZipCode(11790);
//		employee.setSSN("6314135555");
//		employee.setHourlyRate(100);
//		employee.setIsManager(true);
		/*Sample data ends*/
		
		return employee;
	}
	
	public Employee getHighestRevenueEmployee() {
		
		/*
		 * The students code to fetch employee data who generated the highest revenue will be written here
		 * The record is required to be encapsulated as a "Employee" class object
		 */
		
		/*
		 * 
		 * CREATE VIEW CRRevenue(SSN, TotalRevenue) AS SELECT RepSSN, SUM(TotalFare * 0.1) FROM Reservation GROUP BY RepSSN
		 * SELECT SSN FROM CRRevenue WHERE TotalRevenue >= (SELECT MAX(TotalRevenue) FROM CRRevenue)
		 * 
		 */
		Employee employee = new Employee();
		try {
			Statement st = Connections.generateStatement();	
			try {
				st.execute("CREATE VIEW CRRevenue(SSN, TotalRevenue)"
					+ " AS SELECT RepSSN, SUM(TotalFare * 0.1)"
					+ " FROM Reservation GROUP By RepSSN");
			}
			catch(Exception e) {
				
			}
			
			ResultSet rs = st.executeQuery("SELECT SSN FROM CRRevenue"
					+ " WHERE TotalRevenue >= (SELECT MAX(TOTALREVENUE) FROM CRRevenue)");
			
			if(rs.next()) {
				employee.setSSN(Integer.toString(rs.getInt("SSN")));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		/*Sample data begins*/
		// EmployeeID = SSN
		/*Sample data ends*/
		
		return employee;
	}

	public String getEmployeeID(String username) {
		/*
		 * The students code to fetch data from the database based on "username"(email) will be written here
		 * username, which is the Employee's email address who's Employee ID has to be fetched, is given as method parameter
		 * The Employee ID(SSN) is required to be returned as a String
		 */
		try {
			Statement st = Connections.generateStatement();	
			ResultSet rs = st.executeQuery("SELECT ssn FROM employee e LEFT JOIN person p ON e.id = p.id"
					+ " WHERE p.email = \'" + username + "\'");
			return Integer.toString(rs.getInt("SSN"));
		} catch (Exception e) {
			System.out.println(e);
		}

		return "-1";
	}

}
