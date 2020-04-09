package resources;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookReservationDao;
import model.BookReservation;

/**
 * Servlet implementation class BookFlightReservationsMultiCityCustomerController
 */
public class BookFlightReservationsMultiCityCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookFlightReservationsMultiCityCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("bookFlightReservationsCustomer.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String airlineID = request.getParameter("airlineID");
		int flightNum1 = Integer.parseInt(request.getParameter("flightNum1"));
		int flightNum2 = Integer.parseInt(request.getParameter("flightNum2"));
		String departureAirport1 = request.getParameter("departureAirport1");
		String departureAirport2 = request.getParameter("departureAirport2");
		String arrivalAirport1 = request.getParameter("arrivalAirport1");
		String arrivalAirport2 = request.getParameter("arrivalAirport2");
		String trip1Date = request.getParameter("trip1Date");
		String trip2Date = request.getParameter("trip2Date");
		String seatNum = request.getParameter("seatNum");
		String seatClass = request.getParameter("seatClass");
		String mealPref = request.getParameter("mealPref");
		String passEmail = request.getParameter("passEmail");
		Boolean flexibleDate = request.getParameter("flexibleDate")!=null?true:false;
//		String typeOfFlight = request.getParameter("typeOfFlight");
		String repSSN = "";
		
		Boolean isEmployee = false;
		
		if(request.getSession(false).getAttribute("employeeID") != null) {
			isEmployee = true;
			repSSN = (String)request.getSession(false).getAttribute("employeeID");
		}
		
		BookReservation bookRes = new BookReservation();
		bookRes.setAirlineID(airlineID);
		bookRes.setFlightNum1(flightNum1);
		bookRes.setFlightNum2(flightNum2);
		bookRes.setDepartureAirport1(departureAirport1);
		bookRes.setDepartureAirport2(departureAirport2);
		bookRes.setArrivalAirport1(arrivalAirport1);
		bookRes.setArrivalAirport2(arrivalAirport2);
		bookRes.setTrip1Date(trip1Date);
		bookRes.setTrip2Date(trip2Date);
		bookRes.setFlexibleDate(flexibleDate);
		bookRes.setMealPref(mealPref);
		bookRes.setPassEmail(passEmail);
		bookRes.setSeatClass(seatClass);
		bookRes.setSeatNum(seatNum);
//		bookRes.setTypeOfFlight(typeOfFlight);
		bookRes.setRepSSN(repSSN);
		
		BookReservationDao bookResDao = new BookReservationDao();
		String result = bookResDao.bookMultiCityReservation(bookRes);
		
		if(result.equals("success")) {
			if(isEmployee == true) {
				response.sendRedirect("customerRepresentativeHome.jsp?status=insertSuccess");
			}
			else {
			response.sendRedirect("home.jsp?status=insertSuccess");
			}
		}
		else {
			if(isEmployee == true) {
				response.sendRedirect("customerRepresentativeHome.jsp?status=insertFailure");
			}
			else {
			response.sendRedirect("home.jsp?status=insertFailure");
			}
		}
	}

}
