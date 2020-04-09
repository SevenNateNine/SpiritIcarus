package model;

public class BookReservation {
	private String AirlineID;
	private int FlightNum1;
	private int FlightNum2;
	private String DepartureAirport;
	private String ArrivalAirport;
	private String DepartureDate;
	private String ReturnDate;
	private String SeatNum;
	private String SeatClass;
	private String MealPref;
	private String PassEmail;
	private Boolean FlexibleDate;
	private String TypeOfFlight;
	private String TypeOfTrip;
	
	// For multi-city only attributes
	private String DepartureAirport1;
	private String ArrivalAirport1;
	private String Trip1Date;
	private String DepartureAirport2;
	private String ArrivalAirport2;
	private String Trip2Date;
	
	// For customer rep booking only
	private String RepSSN;

	public String getAirlineID() {
		return AirlineID;
	}

	public void setAirlineID(String airlineID) {
		AirlineID = airlineID;
	}
	
	public int getFlightNum1() {
		return FlightNum1;
	}
	
	public void setFlightNum1(int flightNum1) {
		FlightNum1 = flightNum1;
	}

	public int getFlightNum2() {
		return FlightNum2;
	}

	public void setFlightNum2(int flightNum2) {
		FlightNum2 = flightNum2;
	}

	public String getDepartureAirport() {
		return DepartureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		DepartureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return ArrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		ArrivalAirport = arrivalAirport;
	}

	public String getDepartureDate() {
		return DepartureDate;
	}

	public void setDepartureDate(String departureDate) {
		DepartureDate = departureDate;
	}

	public String getReturnDate() {
		return ReturnDate;
	}

	public void setReturnDate(String returnDate) {
		ReturnDate = returnDate;
	}

	public String getSeatNum() {
		return SeatNum;
	}

	public void setSeatNum(String seatNum) {
		SeatNum = seatNum;
	}

	public String getSeatClass() {
		return SeatClass;
	}

	public void setSeatClass(String seatClass) {
		SeatClass = seatClass;
	}

	public String getMealPref() {
		return MealPref;
	}

	public void setMealPref(String mealPref) {
		MealPref = mealPref;
	}

	public String getPassEmail() {
		return PassEmail;
	}

	public void setPassEmail(String passEmail) {
		PassEmail = passEmail;
	}

	public Boolean getFlexibleDate() {
		return FlexibleDate;
	}

	public void setFlexibleDate(Boolean flexibleDate) {
		FlexibleDate = flexibleDate;
	}

	public String getTypeOfFlight() {
		return TypeOfFlight;
	}

	public void setTypeOfFlight(String typeOfFlight) {
		TypeOfFlight = typeOfFlight;
	}

	public String getTypeOfTrip() {
		return TypeOfTrip;
	}

	public void setTypeOfTrip(String typeOfTrip) {
		TypeOfTrip = typeOfTrip;
	}

	public String getDepartureAirport1() {
		return DepartureAirport1;
	}

	public void setDepartureAirport1(String departureAirport1) {
		DepartureAirport1 = departureAirport1;
	}

	public String getArrivalAirport1() {
		return ArrivalAirport1;
	}

	public void setArrivalAirport1(String arrivalAirport1) {
		ArrivalAirport1 = arrivalAirport1;
	}

	public String getTrip1Date() {
		return Trip1Date;
	}

	public void setTrip1Date(String trip1Date) {
		Trip1Date = trip1Date;
	}

	public String getDepartureAirport2() {
		return DepartureAirport2;
	}

	public void setDepartureAirport2(String departureAirport2) {
		DepartureAirport2 = departureAirport2;
	}

	public String getArrivalAirport2() {
		return ArrivalAirport2;
	}

	public void setArrivalAirport2(String arrivalAirport2) {
		ArrivalAirport2 = arrivalAirport2;
	}

	public String getTrip2Date() {
		return Trip2Date;
	}

	public void setTrip2Date(String trip2Date) {
		Trip2Date = trip2Date;
	}

	public String getRepSSN() {
		return RepSSN;
	}

	public void setRepSSN(String repSSN) {
		RepSSN = repSSN;
	}
	
	
}
