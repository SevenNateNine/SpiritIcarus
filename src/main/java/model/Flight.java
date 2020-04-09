package model;

public class Flight {
	private String AirlineID;
	private int FlightNo;
	private int NumOfSeats;
	private String DaysOperating;
	private int MinLengthOfStay;
	private int MaxLengthOfStay;
	private int NumReservations;
	
	public String getAirlineID() {
		return AirlineID;
	}
	public void setAirlineID(String AirlineID) {
		this.AirlineID = AirlineID;
	}
	public int getFlightNo() {
		return FlightNo;
	}
	public void setFlightNo(int FlightNo) {
		this.FlightNo = FlightNo;
	}
	public int getNumOfSeats() {
		return NumOfSeats;
	}
	public void setNumOfSeats(int NumOfSeats) {
		this.NumOfSeats = NumOfSeats;
	}
	public String getDaysOperating() {
		return DaysOperating;
	}
	public void setDaysOperating(String DaysOperating) {
		this.DaysOperating = DaysOperating;
	}
	public int getMaxLengthOfStay() {
		return MaxLengthOfStay;
	}
	public void setMaxLengthOfStay(int maxLengthOfStay) {
		this.MaxLengthOfStay = maxLengthOfStay;
	}
	public int getMinLengthOfStay() {
		return MinLengthOfStay;
	}
	public void setMinLengthOfStay(int minLengthOfStay) {
		this.MinLengthOfStay = minLengthOfStay;
	}
	public int getNumReservations() {
		return NumReservations;
	}
	public void setNumReservations(int numReservations) {
		this.NumReservations = numReservations;
	}
}
