package dao;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import model.Auctions;
import model.Customer;

import java.util.regex.*;

public class AuctionsDao {
	
	public List<Auctions> getLatestBid(int AccountNo, String AirlineID, int FlightNo, String SeatClass) {

		/*
		 * This method fetches the latest auction details and returns it
		 * using method parameters given, find the latest bid
		 * The students code to fetch data from the database will be written here
		 * The Auctions record is required to be encapsulated as a "Auctions" class object
		 */
		List<Auctions> auctions = new ArrayList<Auctions>();
		/*Sample data begins*/
		try {
			Statement st = Connections.generateStatement();	
			ResultSet rs = st.executeQuery("SELECT A.AccountNo, A.AirlineID, A.FlightNo, A.Class," +
					" A.Accepted, A.Date, A.NYOP" + 
					" FROM Auctions A"+
					" WHERE Date IN (SELECT max(Date) FROM Auctions)"); //query to fetch latest bid 
			while(rs.next()) {
				Auctions auction = new Auctions();
				auction.setAccountNo(rs.getInt("AccountNo"));
				auction.setAirlineID(rs.getString("AirlineID"));
				auction.setFlightNo(rs.getInt("FlightNo"));
				auction.setSeatClass(rs.getString("Class"));
				auction.setAccepted(rs.getBoolean("Accepted"));
				auction.setDate(rs.getString("Date"));
				auction.setNYOP(rs.getDouble("NYOP"));
				auctions.add(auction);		
			}
		}
			catch(Exception e) {
				System.out.println(e);
			}
		
		/*Sample data ends*/
		
		return auctions;
	}
	
	public List<Auctions> getAllBids(int AccountNo, String AirlineID, int FlightNo, String SeatClass) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to get all bids given the parameters
		 */
		
		List<Auctions> auctions = new ArrayList<Auctions>();
			
		/*Sample data begins*/
		try {
			Statement st = Connections.generateStatement();	
			ResultSet rs = st.executeQuery("SELECT A.AccountNo, A.AirlineID, A.FlightNo, A.Class," +
					" A.Accepted, A.Date, A.NYOP" + 
					" FROM Auctions A"); // query to fetch all bids
			
			while(rs.next()) {
				Auctions auction = new Auctions();
				auction.setAccountNo(rs.getInt("AccountNo"));
				auction.setAirlineID(rs.getString("AirlineID"));
				auction.setFlightNo(rs.getInt("FlightNo"));
				auction.setSeatClass(rs.getString("Class"));
				auction.setAccepted(rs.getBoolean("Accepted"));
				auction.setDate(rs.getString("Date"));
				auction.setNYOP(rs.getDouble("NYOP"));
				auctions.add(auction);		
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

		/*Sample data ends*/
						
		return auctions;
		
	}
}
