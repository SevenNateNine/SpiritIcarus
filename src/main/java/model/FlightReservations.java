package model;

public class FlightReservations {
	private int ResrNo;
	private String ResrDate;
	private double TotalFare; 
	private double BookingFee;
	private String RepSSN;
	private String FirstName;
	private String LastName;
	private double Revenue;
	private int PassengerID;
	private int AccountNo;
	
	public int getResrNo() {
		return ResrNo;
	}
	public void setResrNo(int resrNo) {
		ResrNo = resrNo;
	}
	public String getResrDate() {
		return ResrDate;
	}
	public void setResrDate(String resrDate) {
		ResrDate = resrDate;
	}
	public double getTotalFare() {
		return TotalFare;
	}
	public void setTotalFare(double totalFare) {
		TotalFare = totalFare;
	}
	public double getBookingFee() {
		return BookingFee;
	}
	public void setBookingFee(double bookingFee) {
		BookingFee = bookingFee;
	}
	public String getRepSSN() {
		return RepSSN;
	}
	public void setRepSSN(String repSSN) {
		RepSSN = repSSN;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public double getRevenue() {
		return Revenue;
	}
	public void setRevenue(double revenue) {
		Revenue = revenue;
	}
	public int getPassengerID() {
		return PassengerID;
	}
	public void setPassengerID(int passengerID) {
		PassengerID = passengerID;
	}
	public int getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(int accountNo) {
		AccountNo = accountNo;
	}

}
