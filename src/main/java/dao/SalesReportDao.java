package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.SalesReport;

public class SalesReportDao {
	
	public List<SalesReport> getSalesReport(String month, String year) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to get sales report for a particular month must be implemented using month and year passed
		 */
		
		
		List<SalesReport> sales = new ArrayList<SalesReport>();
		String start=year+"-"+month+"-"+"01";
		String end=year+"-"+month+"-"+"31";
		try {
			Statement st=Connections.generateStatement();
			ResultSet rs=st.executeQuery("SELECT R.ResrNo, R.ResrDate, R.TotalFare, R.BookingFee,"
					+ " R.RepSSN, P.FirstName, P.LastName FROM Reservation R, Customer C, Person P"
					+ " WHERE R.ResrDate > \'"+start+"\' AND R.ResrDate < \'"+end+"\' AND "
					+ "R.AccountNo = C.AccountNo AND C.Id = P.Id;");
			while(rs.next()) {
				SalesReport sale=new SalesReport();
				sale.setResrNo(rs.getInt("ResrNo"));
				sale.setResrDate(rs.getString("ResrDate"));
				sale.setTotalFare(rs.getDouble("TotalFare"));
				sale.setBookingFee(rs.getDouble("BookingFee"));
				sale.setRepSSN(rs.getString("RepSSN"));
				sale.setFirstName(rs.getString("FirstName"));
				sale.setLastName(rs.getString("LastName"));
				sales.add(sale);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
						
		return sales;
		
	}

}
