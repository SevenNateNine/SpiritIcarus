package dao;

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
			
		/*Sample data begins*/
		for (int i = 0; i < 4; i++) {
			SalesReport sale = new SalesReport();
			
			sale.setResrNo(1);
			sale.setResrDate("2011-01-01");
			sale.setTotalFare(100);
			sale.setBookingFee(10.1);
			sale.setRepSSN("631891987");
			sale.setFirstName("John");
			sale.setLastName("LastName");
				
			sales.add(sale);
				
		}
		/*Sample data ends*/
						
		return sales;
		
	}

}
