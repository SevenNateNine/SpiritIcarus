package dao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BookReservation;

public class BookReservationDao {

	public String bookOneWayRoundTripReservation(BookReservation bookRes) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to book reservations based on bookRes object passed
		 * repSSN will be set depending on who booked the reservation
		 * Use getters to fetch the data from the object
		 * The sample code returns "success" by default.
		 * You need to handle the database deletion and return "success" or "failure" based on result of the database deletion.
		 */
		System.out.println("hello There");
		try {
			
			Statement st=Connections.generateStatement();
			ResultSet rs=st.executeQuery("SELECT MAX(ResrNo) FROM Reservation");
			rs.next();
			int resNo=rs.getInt(1)+1;
			System.out.println("ResNo="+resNo);
			rs=st.executeQuery("SELECT C.accountNo, P.Id FROM Customer C, PERSON P "
					+ "WHERE P.Id=C.Id AND P.Email=\'"+bookRes.getPassEmail()+"\';");
			rs.next();
			int accNo=rs.getInt(1);
			int id=rs.getInt(2);
			System.out.println("accNo "+accNo);//works up to here
			int legNo=getLegNo(bookRes.getArrivalAirport(),bookRes.getDepartureAirport(),bookRes.getFlightNum1(),bookRes.getAirlineID());
			System.out.println(legNo);
			System.out.println(bookRes.getTypeOfTrip());
			if( bookRes.getTypeOfTrip().contentEquals("oneway")) {
				boolean b=st.execute("INSERT INTO Reservation VALUES ("+resNo+",NOW(),100, 1000, NULL,"+accNo+");"
						+ " INSERT INTO Includes VALUES ("+resNo+", \'"+bookRes.getAirlineID()+"\',"+bookRes.getFlightNum1()+", "
						+legNo+", \'"+ bookRes.getDepartureDate()+"\');"
						+ "INSERT INTO ReservationPassenger VALUES("+resNo+", "+id+ ", "+ accNo+", \'"+bookRes.getSeatNum()+"\', \'"
								+ bookRes.getSeatClass()+"\' , \'"+bookRes.getMealPref()+"\');");
				System.out.println(b);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return "success";
		
	}
	
	public String bookMultiCityReservation(BookReservation bookRes) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to book reservations based on bookRes object passed
		 * repSSN will be set depending on who booked the reservation
		 * Use getters to fetch the data from the object
		 * DepartureAirport1, ArrivalAirport1, DepartureAirport2, ArrivalAirport2, Trip1Date, Trip2Date are the attributes to use here
		 * The sample code returns "success" by default.
		 * You need to handle the database deletion and return "success" or "failure" based on result of the database deletion.
		 */
		System.out.println("wrong one");			
		return "success";
		
	}
	private int getLegNo(String arrAirport, String depAirport, int flightNo, String airlineId) {
		try {
			Statement st=Connections.generateStatement();
			String sql="SELECT LegNo FROM Leg WHERE FlightNo="+flightNo+" AND AirlineID=\'" + airlineId+"\"' "
					+ "AND DepAirportID=\'"+depAirport+"\' AND ArrAirportID=\'"+arrAirport+"\';";
			ResultSet rs=st.executeQuery(sql);
			rs.next();
			System.out.println("sql");
			return rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("failed");
		return 0;
	}
}
