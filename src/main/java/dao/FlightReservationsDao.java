package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Flight;
import model.FlightReservations;

public class FlightReservationsDao {
	//works
	public List<FlightReservations> getReservations(int FlightNum, String airlineID, String CustomerName) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to get flight reservations based on FlightNum OR CustomerName passed
		 * Only one of the two strings will be set, either (FlightNum = 0 and airlineID="") or CustomerName = "" depending on query
		 */
		
		List<FlightReservations> reservations = new ArrayList<FlightReservations>();
		
		try {
			Statement st = Connections.generateStatement();	
			String query="";
			if (FlightNum!=0) {
				
				query="SELECT DISTINCT R.ResrNo, R.ResrDate, R.TotalFare, R.BookingFee, R.RepSSN,"
						+ " P.FirstName, P.LastName"
						+ " FROM Reservation R, Customer C, Includes I, Person P "
						+ "WHERE R.AccountNo = C.AccountNo AND C.Id = P.Id AND"
						+ " I.ResrNo = R.ResrNo AND I.AirlineID=\'"+airlineID+"\' AND I.FlightNo = \'"
						+FlightNum+"\';";
			}
			else {
				query="SELECT DISTINCT R.ResrNo, R.ResrDate, R.TotalFare, R.BookingFee, "
						+ "R.RepSSN, P.FirstName, P.LastName "
						+ "FROM Reservation R, Customer C, Person P"
						+ " WHERE R.AccountNo = C.AccountNo AND C.Id = P.Id AND"
						+ " CONCAT(P.FirstName,\' \',P.LastName) = \'"+CustomerName+"\';";
			}
				
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				FlightReservations res=new FlightReservations();
				res.setResrNo(rs.getInt("ResrNo"));
				res.setResrDate(rs.getString("ResrDate"));
				res.setTotalFare(rs.getDouble("TotalFare"));
				res.setBookingFee(rs.getDouble("BookingFee"));
				res.setRepSSN(rs.getString("RepSSN"));
				res.setFirstName(rs.getString("FirstName"));
				res.setLastName(rs.getString("LastName"));
				
				reservations.add(res);
			}
				
		} catch (Exception e) {
			System.out.println(e);
		}		
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
			
		 try {
				Statement st = Connections.generateStatement();	
				String query="";
				if (airlineID.length()!=0) {
					//by airline id and flight number
					query="SELECT DISTINCT R.ResrNo, R.TotalFare * 0.1 AS Revenue FROM "
							+ "Reservation R, Includes I WHERE I.ResrNo = R.ResrNo"
							+ " AND I.AirlineID=\'"+airlineID+"\' AND I.FlightNo = \'"+FlightNum+"\';" ;
				}
				else if(CustomerName.length()!=0){
					query="SELECT DISTINCT R.ResrNo, R.TotalFare * 0.1 AS Revenue"
							+ " FROM Reservation R WHERE R.AccountNo IN (SELECT C.AccountNo"
							+ "FROM Person P, Customer C "
							+ "WHERE C.Id=P.Id AND CONCAT(P.FirstName,\' \',P.LastName) = \'"+CustomerName+"\');";
				}
				else {
					try {
						st.execute("CREATE VIEW ResrFlightLastLeg(ResrNo, AirlineID, FlightNo, LegNo)"
							+ " AS SELECT I.ResrNo, I.AirlineID, I.FlightNo, MAX(I.LegNo) "
							+ "FROM Includes I GROUP BY I.ResrNo, I.AirlineID, I.FlightNo;");
					}catch(Exception e) {
						
					}
					query="SELECT DISTINCT R.ResrNo, R.TotalFare * 0.1 AS Revenue "
							+ "FROM Reservation R, Leg L, ResrFlightLastLeg LL, Airport A WHERE R.ResrNo = LL.ResrNo"
							+ " AND L.AirlineID = LL.AirlineID AND L.FlightNo = LL.FlightNo AND L.LegNo = LL.LegNo "
							+ "AND L.ArrAirportID = A.ID AND A.City =\'"+destCity+"\';"; 
				}
					
				ResultSet rs = st.executeQuery(query);
				System.out.println(CustomerName);
				
				while(rs.next()) {
					FlightReservations res=new FlightReservations();
					res.setResrNo(rs.getInt("ResrNo"));
					res.setRevenue(rs.getDouble("Revenue"));
					reservations.add(res);
				}
					
			} catch (Exception e) {
				System.out.println(e);
			}		
						
		return reservations;
		
	}
	
	//works
	public List<FlightReservations> getPassengerList(int FlightNum, String AirlineID) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to get passenger list given flight number and Airline ID
		 */
		List<FlightReservations> reservations = new ArrayList<FlightReservations>();

		try {
			Statement st = Connections.generateStatement();	
			ResultSet rs=st.executeQuery("SELECT DISTINCT P.Id, P.FirstName, P.LastName"
					+ " FROM Reservation R, Includes I, ReservationPassenger RP, "
					+ "Person P WHERE"
					+ " I.AirlineID=\'"+AirlineID+"\' AND I.FlightNo = \'"+FlightNum+"\' "
					+ "AND I.ResrNo = R.ResrNo AND R.ResrNo = RP.ResrNo AND RP.Id = P.Id;");
			while(rs.next()) {
				FlightReservations res=new FlightReservations();
				res.setAccountNo(rs.getInt("Id"));
				res.setFirstName(rs.getString("FirstName"));
				res.setLastName(rs.getString("LastName"));
				reservations.add(res);
			
			}
					
		} catch (Exception e) {
			System.out.println(e);
		}
		
						
		return reservations;
		
	}
	//works
	public List<FlightReservations> getCurrentReservations(int accountNo) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to get current flight reservations based on accountno 
		 */

		
		List<FlightReservations> reservations = new ArrayList<FlightReservations>();
		
		try {
			Statement st = Connections.generateStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM Reservation R WHERE EXISTS ("
                 +"SELECT * FROM Includes I, Leg L"
                 +" WHERE R.ResrNo = I.ResrNo AND I.AirlineID = L.AirlineID"
                 +" AND I.FlightNo = L.FlightNo AND L.DepTime >= NOW()) "
                 +" AND R.AccountNo =\'"+accountNo+"\';");
			while(rs.next()) {
				FlightReservations res=new FlightReservations();
				res.setResrNo(rs.getInt("ResrNo"));
				res.setResrDate(rs.getString("ResrDate"));
				res.setTotalFare(rs.getDouble("TotalFare"));
				res.setBookingFee(rs.getDouble("BookingFee"));
				res.setRepSSN(rs.getString("RepSSN"));
				res.setAccountNo(accountNo);
				reservations.add(res);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
						
		return reservations;
		
	}
	//works
	public List<FlightReservations> getAllReservations(int accountNo) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to get all flight reservations based on accountno 
		 */
		
		List<FlightReservations> reservations = new ArrayList<FlightReservations>();
		
		try {
			Statement st = Connections.generateStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM Reservation R WHERE R.AccountNo =\'"+accountNo+"\';");
			while(rs.next()) {
				FlightReservations res=new FlightReservations();
				res.setResrNo(rs.getInt("ResrNo"));
				res.setResrDate(rs.getString("ResrDate"));
				res.setTotalFare(rs.getDouble("TotalFare"));
				res.setBookingFee(rs.getDouble("BookingFee"));
				res.setRepSSN(rs.getString("RepSSN"));
				res.setAccountNo(accountNo);
				reservations.add(res);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
						
		return reservations;
		
	}
	//works
	public String cancelReservation(int resrNo) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to get cancel reservations based on resrNo
		 * The sample code returns "success" by default.
		 * You need to handle the database deletion and return "success" or "failure" based on result of the database deletion.
		 */
		try {
			Statement st=Connections.generateStatement();
			if(st.execute("DELETE FROM Includes WHERE ResrNo =\'"+resrNo +"\';"+ 
					"DELETE FROM ReservationPassenger WHERE ResrNo = \'"+resrNo +"\';"+
					"DELETE FROM Reservation WHERE ResrNo =\'"+resrNo +"\';")) {
				return "success";
				
			}
			else {
				return "failure";
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return "success";
		
	}


}
