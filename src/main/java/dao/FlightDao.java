package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.Flight;

public class FlightDao {
	//tested and works
	public List<Flight> getAllFlights() {
		/* Get list of all flights, code goes here
		 */
		/*
		
		for (int i = 0; i < 5; i++) {
			Flight flight = new Flight();
			flight.setAirlineID("AA");
			flight.setFlightNo(111);
			flight.setNumOfSeats(100);
			flight.setDaysOperating("1010100");
			flight.setMinLengthOfStay(1);
			flight.setMaxLengthOfStay(30);
			flights.add(flight);			
		}
		*/

		List<Flight> flights = new ArrayList<Flight>();
		
		try {
			Statement st = Connections.generateStatement();	
			ResultSet rs = st.executeQuery("SELECT *"
					+ " " + 
					" FROM Flight;" );
			
			while(rs.next()) {
				Flight f = new Flight();
				f.setAirlineID(rs.getString("AirlineID"));
				f.setFlightNo(rs.getInt("FlightNo"));
				f.setNumOfSeats(rs.getInt("NoOfSeats"));
				f.setDaysOperating(rs.getString("DaysOperating"));
				f.setMinLengthOfStay(rs.getInt("MinLengthOfStay"));
				f.setMaxLengthOfStay(rs.getInt("MaxLengthOfStay"));				
				flights.add(f);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return flights;
	}
	//works
	public List<Flight> mostActiveFlights() {
		
		/* Get list of most active flights, code goes here
		 */
		
		List<Flight> flights = new ArrayList<Flight>();
		
		try {
			Statement st = Connections.generateStatement();	
			try {
				st.execute("CREATE VIEW FlightReservation(AirlineID, FlightNo, ResrCount) AS SELECT I.AirlineID, I.FlightNo, COUNT(DISTINCT I.ResrNo) FROM Includes I GROUP BY I.AirlineID, I.FlightNo;");
			}catch (Exception e) {
				
			}
			ResultSet rs=st.executeQuery("SELECT * FROM FlightReservation WHERE ResrCount >= (SELECT MAX(ResrCount) FROM FlightReservation); ");
			while(rs.next()) {
				Flight f = new Flight();
				f.setAirlineID(rs.getString("AirlineID"));
				f.setFlightNo(rs.getInt("FlightNo"));
				f.setNumReservations(rs.getInt("ResrCount"));
				flights.add(f);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		/*
		for (int i = 0; i < 5; i++) {
			Flight flight = new Flight();
			flight.setAirlineID("AA");
			flight.setFlightNo(111);
			flight.setNumReservations(30);
			flights.add(flight);			
		}
		/*Sample data ends*/
		
		return flights;
	}
	
	public List<Flight> getFlightsForAirport(String airport) {
		
		/*
		 * Code here to get flights given an airport
		 * 
		 */
		List<Flight> flights = new ArrayList<Flight>();
		try {
			Statement st = Connections.generateStatement();	
			ResultSet rs=st.executeQuery("SELECT DISTINCT F.* FROM Flight F, Leg L, Airport A "
				+ "WHERE F.AirlineID = L.AirlineID AND F.FlightNo = L.FlightNo "
				+ "AND (L.DepAirportId = A.Id OR L.ArrAirportId = A.Id) AND A.Name =\'"+airport+"\';");
			while(rs.next()) {
				Flight f = new Flight();
				f.setAirlineID(rs.getString("AirlineID"));
				f.setFlightNo(rs.getInt("FlightNo"));
				f.setNumOfSeats(rs.getInt("NoOfSeats"));
				f.setDaysOperating(rs.getString("DaysOperating"));
				f.setMinLengthOfStay(rs.getInt("MinLengthOfStay"));
				f.setMaxLengthOfStay(rs.getInt("MaxLengthOfStay"));				
				flights.add(f);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
		/*
		for (int i = 0; i < 5; i++) {
			Flight flight = new Flight();
			flight.setAirlineID("AA");
			flight.setFlightNo(111);
			flight.setNumOfSeats(100);
			flight.setDaysOperating("1010100");
			flight.setMinLengthOfStay(1);
			flight.setMaxLengthOfStay(30);
			flights.add(flight);			
		}
		/*Sample data ends*/
		
		return flights;
	}
	//works but need to add ActualArrTime and ActualDepTime to Leg table
	public List<Flight> getOnTimeFlights() {
		
		/*
		 * Code here to get on time flights
		 */
		
		List<Flight> flights = new ArrayList<Flight>();
		
		
		try {
			Statement st = Connections.generateStatement();	
			ResultSet rs=st.executeQuery("SELECT * FROM "
					+ "Flight F WHERE NOT EXISTS ( SELECT * FROM Leg L WHERE F.AirlineID = L.AirlineID "
					+ "AND F.FlightNo = L.FlightNo AND (ActualArrTime > ArrTime OR ActualDepTime > DepTime));");
			while(rs.next()) {
				Flight f = new Flight();
				f.setAirlineID(rs.getString("AirlineID"));
				f.setFlightNo(rs.getInt("FlightNo"));
				f.setNumOfSeats(rs.getInt("NoOfSeats"));
				f.setDaysOperating(rs.getString("DaysOperating"));
				f.setMinLengthOfStay(rs.getInt("MinLengthOfStay"));
				f.setMaxLengthOfStay(rs.getInt("MaxLengthOfStay"));				
				flights.add(f);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		/*
		for (int i = 0; i < 5; i++) {
			Flight flight = new Flight();
			flight.setAirlineID("AA");
			flight.setFlightNo(111);
			flight.setNumOfSeats(100);
			flight.setDaysOperating("1010100");
			flight.setMinLengthOfStay(1);
			flight.setMaxLengthOfStay(30);
			flights.add(flight);			
		}
		/*Sample data ends*/
		
		return flights;
	}
	//works but need to edit database first
	public List<Flight> getDelayedFlights() {
		
		/*
		 * Code here to get delayed flights
		 */
		
		List<Flight> flights = new ArrayList<Flight>();
		
		
		try {
			Statement st = Connections.generateStatement();	
			ResultSet rs=st.executeQuery("SELECT * FROM Flight F"
					+ " WHERE EXISTS ( SELECT * FROM Leg L WHERE "
					+ "F.AirlineID = L.AirlineID AND F.FlightNo = L.FlightNo "
					+ "AND (ActualArrTime > ArrTime OR ActualDepTime > DepTime));");
			while(rs.next()) {
				Flight f = new Flight();
				f.setAirlineID(rs.getString("AirlineID"));
				f.setFlightNo(rs.getInt("FlightNo"));
				f.setNumOfSeats(rs.getInt("NoOfSeats"));
				f.setDaysOperating(rs.getString("DaysOperating"));
				f.setMinLengthOfStay(rs.getInt("MinLengthOfStay"));
				f.setMaxLengthOfStay(rs.getInt("MaxLengthOfStay"));				
				flights.add(f);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		/*
		for (int i = 0; i < 5; i++) {
			Flight flight = new Flight();
			flight.setAirlineID("AA");
			flight.setFlightNo(111);
			flight.setNumOfSeats(100);
			flight.setDaysOperating("1010100");
			flight.setMinLengthOfStay(1);
			flight.setMaxLengthOfStay(30);
			flights.add(flight);			
		}
		/*Sample data ends*/
		
		return flights;
	}
	//works
	public List<Flight> getCustomerFlightSuggestions(int accountNo) {
		
		/* Get list of suggested flights depending on customer's accountNo passed
		 */
		
		List<Flight> flights = new ArrayList<Flight>();
		
		
		try {
			Statement st = Connections.generateStatement();	
			try {
				st.execute("CREATE VIEW FlightReservation(AirlineID, FlightNo, ResrCount) AS SELECT I.AirlineID, I.FlightNo, COUNT(DISTINCT I.ResrNo) FROM Includes I GROUP BY I.AirlineID, I.FlightNo;");
			}catch (Exception e) {
				
			}
			ResultSet rs=st.executeQuery("SELECT * FROM FlightReservation FR " + 
					"WHERE NOT EXISTS (SELECT * FROM Reservation R, Includes I" + 
					" WHERE R.ResrNo = I.ResrNo AND FR.AirlineID = I.AirlineIDAND FR.FlightNo = I.FlightNo AND R.AccountNo = 1008) " + 
					" ORDER BY FR.ResrCount DESC;");
			while(rs.next()) {
				Flight f = new Flight();
				f.setAirlineID(rs.getString("AirlineID"));
				f.setFlightNo(rs.getInt("FlightNo"));
				f.setNumReservations(rs.getInt("ResrCount"));
				flights.add(f);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		/*
		for (int i = 0; i < 5; i++) {
			Flight flight = new Flight();
			flight.setAirlineID("AA");
			flight.setFlightNo(111);
			flight.setNumReservations(30);
			flights.add(flight);			
		}
		/*Sample data ends*/
		
		return flights;
	}
	//works
	public List<Flight> getBestSellingFlights() {
		
		/* Get list of best selling flights
		 */
		
		
		List<Flight> flights = new ArrayList<Flight>();
		
		
		try {
			Statement st = Connections.generateStatement();	
			try {
				st.execute("CREATE VIEW FlightReservation(AirlineID, FlightNo, ResrCount) AS SELECT I.AirlineID, I.FlightNo, COUNT(DISTINCT I.ResrNo) FROM Includes I GROUP BY I.AirlineID, I.FlightNo;");
			}catch (Exception e) {
				
			}
			ResultSet rs=st.executeQuery("SELECT * FROM FlightReservation ORDER BY ResrCount DESC;");
			while(rs.next()) {
				Flight f = new Flight();
				f.setAirlineID(rs.getString("AirlineID"));
				f.setFlightNo(rs.getInt("FlightNo"));
				f.setNumReservations(rs.getInt("ResrCount"));
				flights.add(f);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		/*
		for (int i = 0; i < 5; i++) {
			Flight flight = new Flight();
			flight.setAirlineID("AA");
			flight.setFlightNo(111);
			flight.setNumReservations(30);
			flights.add(flight);			
		}
		/*Sample data ends*/
		
		return flights;
	}
}