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
		try {
			Statement st = Connections.generateStatement();	
			ResultSet rs = st.executeQuery("SELECT C.AccountNo, P.Email, C.CreditCardNo, C.Rating," +
					" P.FirstName, P.LastName,  P.Address, P.City, P.State, P.ZipCode" + 
					" FROM Customer C, Person P" + 
					" WHERE C.Id = P.Id");
			
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setAccountNo(rs.getInt("AccountNo"));
				customer.setAddress(rs.getString("Address"));
				customer.setLastName(rs.getString("LastName"));
				customer.setFirstName(rs.getString("FirstName"));
				customer.setCity(rs.getString("City"));
				customer.setState(rs.getString("State"));
				customer.setEmail(rs.getString("Email"));
				customer.setZipCode(rs.getInt("ZipCode"));
				customer.setCreditCard(rs.getString("CreditCardNo"));
				customer.setRating(rs.getInt("Rating"));
				customers.add(customer);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
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
		/*
	 		SELECT P.FirstName, P.LastName, C.Email, P.Address, P.City, P.State, P.ZipCode 
			FROM Customer C, Person P
			WHERE C.Id = P.Id
		 */
		try {
			Statement st = Connections.generateStatement();	
			ResultSet rs = st.executeQuery("SELECT P.FirstName, P.LastName, P.Email, P.Address, P.City, P.State, P.ZipCode" + 
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
		Customer customer = new Customer();
		try {
			Statement st = Connections.generateStatement();	
			ResultSet rs = st.executeQuery("SELECT P.FirstName, P.LastName, P.Email, C.AccountNo, C.CreditCardNo, C.Rating," + 
					" P.Address, P.City, P.State, P.ZipCode" + 
					" FROM Customer C, Person P" + 
					" WHERE C.Id = P.Id AND C.AccountNo = " + accountNo);
			while(rs.next()) {
				customer.setAccountNo(rs.getInt("AccountNo"));
				customer.setAddress(rs.getString("Address"));
				customer.setLastName(rs.getString("LastName"));
				customer.setFirstName(rs.getString("FirstName"));
				customer.setCity(rs.getString("City"));
				customer.setState(rs.getString("State"));
				customer.setEmail(rs.getString("Email"));
				customer.setZipCode(rs.getInt("ZipCode"));
				customer.setCreditCard(rs.getString("CreditCardNo"));
				customer.setRating(rs.getInt("Rating"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return customer;
	}
	
	public String deleteCustomer(int accountNo) {

		/*
		 * This method deletes a customer returns "success" string on success, else returns "failure"
		 * The students code to delete the data from the database will be written here
		 * accountNo, which is the Customer's accountNo who's details have to be deleted, is given as method parameter
		 */
		try {
			Statement st = Connections.generateStatement();	
			st.executeQuery("DELETE FROM Customer WHERE AccountNo = " + accountNo);
			
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}
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
		/*
		 * INSERT INTO Person VALUES (5, 'Jenna', 'Smith', '200 Stony Brook Rd', 'Stony Brook', 'New York', 11790);
		 * INSERT INTO Customer VALUE(5, 1011, '1234567812345678', 'jenna@smith.com', '2014-04-01 16:40:40', 1);
		 */
		try {
			Statement st = Connections.generateStatement();	
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
