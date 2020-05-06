package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Itinerary;

public class ItineraryDao {
	
	public List<Itinerary> getItineraryForReservation(int resrNo) {
			/*
			 * Code to fetch itinerary from resrNo goes here
			 */
		
			List<Itinerary> its = new ArrayList<Itinerary>();
			try {		
				Statement st = Connections.generateStatement();
				ResultSet rs = st.executeQuery("SELECT l.AirlineID, l.FlightNo, l.LegNo, l.DepAirportId, l.ArrAirportId, cast(concat(i.Date,' ',TIME(l.DepTime)) AS Datetime) AS DepartingTime," +
					 " ADDDATE(cast(concat(i.Date,' ',TIME(l.DepTime)) AS Datetime), TIME(DATEDIFF(l.ArrTime,l.DepTime))) AS ArrivingTime" +
					 " FROM Leg l, Includes i" +
					 " WHERE i.AirlineID = l.AirlineID AND i.FlightNo = l.FlightNo AND i.LegNo = l.LegNo AND i.ResrNo = " + resrNo +
					 " ORDER BY DepTime");
				
				while(rs.next()) {
					Itinerary it = new Itinerary();
					it.setAirlineID(rs.getString("AirlineID"));
					it.setArrival(rs.getString("ArrAirportId"));
					it.setDeparture(rs.getString("DepAirportId"));
					it.setArrTime(rs.getString("ArrivingTime"));
					it.setDepTime(rs.getString("DepartingTime"));
					it.setFlightNo(rs.getInt("FlightNo"));
					
					its.add(it);
				}	
			} 
			catch (Exception e) {
				System.out.println(e);
			}
			
			/*Sample data ends*/
			System.out.println("Itinerary is called here!");
			return its;
		}
}
