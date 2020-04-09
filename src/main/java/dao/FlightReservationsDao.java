package dao;

import java.util.ArrayList;
import java.util.List;

import model.FlightReservations;

public class FlightReservationsDao {
	
	public List<FlightReservations> getReservations(int FlightNum, String airlineID, String CustomerName) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to get flight reservations based on FlightNum OR CustomerName passed
		 * Only one of the two strings will be set, either (FlightNum = 0 and airlineID="") or CustomerName = "" depending on query
		 */
		
		List<FlightReservations> reservations = new ArrayList<FlightReservations>();
			
		/*Sample data begins*/
		for (int i = 0; i < 4; i++) {
			FlightReservations reservation = new FlightReservations();
			
			reservation.setResrNo(111);
			reservation.setResrDate("2011-01-01");
			reservation.setTotalFare(150.22); 
			reservation.setBookingFee(10.12);
			reservation.setRepSSN("198498472");
			reservation.setFirstName("John");
			reservation.setLastName("Wick");
	
			reservations.add(reservation);
				
		}
		/*Sample data ends*/
						
		return reservations;
		
	}
	
	public List<FlightReservations> getRevenueSummary(int FlightNum, String airlineID, String CustomerName,String destCity) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to get flight reservations based on FlightNum OR CustomerName passed
		 * Only one of the two strings will be set, either (FlightNum = 0 and airlineID = "") or CustomerName = ""  
		 * or destCity = "" depending on query
		 */
		
		List<FlightReservations> reservations = new ArrayList<FlightReservations>();
			
		/*Sample data begins*/
		for (int i = 0; i < 4; i++) {
			FlightReservations reservation = new FlightReservations();
			
			reservation.setResrNo(111);
			reservation.setRevenue(10000.25);
	
			reservations.add(reservation);
				
		}
		/*Sample data ends*/
						
		return reservations;
		
	}
	
	
	public List<FlightReservations> getPassengerList(int FlightNum, String AirlineID) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to get passenger list given flight number and Airline ID
		 */
		
		List<FlightReservations> reservations = new ArrayList<FlightReservations>();
			
		/*Sample data begins*/
		for (int i = 0; i < 4; i++) {
			FlightReservations reservation = new FlightReservations();
			
			reservation.setPassengerID(i+1);
			reservation.setFirstName("John");
			reservation.setLastName("Wick");
	
			reservations.add(reservation);
				
		}
		/*Sample data ends*/
						
		return reservations;
		
	}
	
	public List<FlightReservations> getCurrentReservations(int accountNo) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to get current flight reservations based on accountno 
		 */
		
		List<FlightReservations> reservations = new ArrayList<FlightReservations>();
			
		/*Sample data begins*/
		for (int i = 0; i < 4; i++) {
			FlightReservations reservation = new FlightReservations();
			
			reservation.setResrNo(111);
			reservation.setResrDate("2011-01-01");
			reservation.setTotalFare(150.22); 
			reservation.setBookingFee(10.12);
			reservation.setRepSSN("198498472");
			reservation.setAccountNo(accountNo);
	
			reservations.add(reservation);
				
		}
		/*Sample data ends*/
						
		return reservations;
		
	}

	public List<FlightReservations> getAllReservations(int accountNo) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to get all flight reservations based on accountno 
		 */
		
		List<FlightReservations> reservations = new ArrayList<FlightReservations>();
			
		/*Sample data begins*/
		for (int i = 0; i < 4; i++) {
			FlightReservations reservation = new FlightReservations();
			
			reservation.setResrNo(111);
			reservation.setResrDate("2011-01-01");
			reservation.setTotalFare(150.22); 
			reservation.setBookingFee(10.12);
			reservation.setRepSSN("198498472");
			reservation.setAccountNo(accountNo);
	
			reservations.add(reservation);
				
		}
		/*Sample data ends*/
						
		return reservations;
		
	}
	
	public String cancelReservation(int resrNo) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to get cancel reservations based on resrNo
		 * The sample code returns "success" by default.
		 * You need to handle the database deletion and return "success" or "failure" based on result of the database deletion.
		 */
					
		return "success";
		
	}


}
