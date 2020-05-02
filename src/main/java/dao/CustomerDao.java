package dao;

import java.sql.*;
import java.lang.*;

import java.util.ArrayList;
import java.util.List;

import model.Customer;


public class CustomerDao {
	/*
	 * This class handles all the database operations related to the customer table
	 */
	
	/**
	 * @param String searchKeyword
	 * @return ArrayList<Customer> object
	 */
	public List<Customer> getCustomers() {
		/*
		 * This method fetches one or more customers and returns it as an ArrayList
		 */
		
		List<Customer> customers = new ArrayList<Customer>();

		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */
		
		/*Sample data begins*/
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setAccountNo(111);
			customer.setAddress("123 Sucfcess Street");
			customer.setLastName("Lu");
			customer.setFirstName("Shiyfong");
			customer.setCity("Stony Brook");
			customer.setState("NY");
			customer.setEmail("shiyong@cs.sunysb.edu");
			customer.setZipCode(11790);
//			customer.setTelephone("5166328959");
			customer.setCreditCard("1234567812345678");
			customer.setRating(1);
			customers.add(customer);			
		}
		/*Sample data ends*/
		
		return customers;
	}


	public Customer getHighestRevenueCustomer() {
		/*
		 * This method fetches the customer who generated the highest total revenue and returns it
		 * The students code to fetch data from the database will be written here
		 * The customer record is required to be encapsulated as a "Customer" class object
		 */


		/*Sample data begins*/
		
		Customer customer = new Customer();
		// Customer ID = Account Number
		customer.setAccountNo(111);
		customer.setLastName("Lu");
		customer.setFirstName("Shiyfong");
		/*Sample data ends*/
	
		return customer;
		
	}

	public List<Customer> getCustomerMailingList() {

		/*
		 * This method fetches the all customer mailing details and returns it
		 * The students code to fetch data from the database will be written here
		 * Each customer record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */
		List<Customer> customers = new ArrayList<Customer>();
		try {
			
			// root = username, qnzMxS7qAB^@qm = password
			Statement st = Connections.generateStatement();
			
			/*
		 		SELECT P.FirstName, P.LastName, C.Email, P.Address, P.City, P.State, P.ZipCode 
				FROM Customer C, Person P
				WHERE C.Id = P.Id
			 */
			
			ResultSet rs = st.executeQuery("SELECT P.FirstName, P.LastName, C.Email, P.Address, P.City, P.State, P.ZipCode" + 
					" FROM Customer C, Person P" + 
					" WHERE C.Id = P.Id");
			
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setAddress(rs.getString("Address"));
				customer.setLastName(rs.getString("LastName"));
				customer.setFirstName(rs.getString("FirstName"));
				customer.setCity(rs.getString("City"));
				customer.setState(rs.getString("State"));
				customer.setEmail(rs.getString("Email"));
				customer.setZipCode(rs.getInt("ZipCode"));
				customers.add(customer);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return customers;
	}

	public Customer getCustomer(int accountNo) {

		/*
		 * This method fetches the customer details and returns it
		 * accountNo, which is the Customer's accountNo who's details have to be fetched, is given as method parameter
		 * The students code to fetch data from the database will be written here
		 * The customer record is required to be encapsulated as a "Customer" class object
		 */
		
		/*Sample data begins*/
		Customer customer = new Customer();
		customer.setAccountNo(111);
		customer.setAddress("123 Success Street");
		customer.setLastName("Lut");
		customer.setFirstName("Shiyong");
		customer.setCity("Stony Brook");
		customer.setState("NY");
		customer.setEmail("shiyong@cs.sunysb.edu");
		customer.setZipCode(11790);
		customer.setCreditCard("1234567812345678");
		customer.setRating(1);
		/*Sample data ends*/
		
		return customer;
	}
	
	public String deleteCustomer(int accountNo) {

		/*
		 * This method deletes a customer returns "success" string on success, else returns "failure"
		 * The students code to delete the data from the database will be written here
		 * accountNo, which is the Customer's accountNo who's details have to be deleted, is given as method parameter
		 */

		/*Sample data begins*/
		return "success";
		/*Sample data ends*/
		
	}


	public int getCustomerID(String emailaddress) {
		/*
		 * This method returns the Customer's ID based on the provided email address
		 * The students code to fetch data from the database will be written here
		 * username, which is the email address of the customer, who's ID has to be returned, is given as method parameter
		 * The Customer's ID(accountNo) is required to be returned as a String
		 */

		return 111;
	}


	public String addCustomer(Customer customer) {

		/*
		 * All the values of the add customer form are encapsulated in the customer object.
		 * These can be accessed by getter methods (see Customer class in model package).
		 * e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database insertion of the customer details and return "success" or "failure" based on result of the database insertion.
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305","root","qnzMxS7qAB^@qm");
			Statement st = con.createStatement();
			
			/*
			 * INSERT INTO Person VALUES (5, 'Jenna', 'Smith', '200 Stony Brook Rd', 'Stony Brook', 'New York', 11790);
			 * INSERT INTO Customer VALUE(5, 1011, '1234567812345678', 'jenna@smith.com', '2014-04-01 16:40:40', 1);
			 */
			ResultSet rs = st.executeQuery("INSERT INTO Person VALUES (");
		}
		catch(Exception e) {
			return "failure";
		}
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/

	}

	public String editCustomer(Customer customer) {
		/*
		 * All the values of the edit customer form are encapsulated in the customer object.
		 * These can be accessed by getter methods (see Customer class in model package).
		 * e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database update and return "success" or "failure" based on result of the database update.
		 */
		
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/

	}

}
