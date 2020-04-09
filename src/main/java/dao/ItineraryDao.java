package dao;

import java.util.ArrayList;
import java.util.List;

import model.Itinerary;

public class ItineraryDao {
	
	public List<Itinerary> getItineraryForReservation(int resrNo) {
			/*
			 * Code to fetch itinerary from resrNo goes here
			 */
		
			List<Itinerary> its = new ArrayList<Itinerary>();
			
			for (int i = 0; i < 5; i++) {
				Itinerary it = new Itinerary();
				it.setAirlineID("AA");
				it.setArrival("JFK");
				it.setDeparture("TNR");
				it.setArrTime("2011-01-13 23:00:00");
				it.setDepTime("2011-01-13 06:55:00");
				it.setFlightNo(111);
				it.setResrNo(resrNo);
				
				its.add(it);			
			}
			/*Sample data ends*/
			
			return its;
		}
}
