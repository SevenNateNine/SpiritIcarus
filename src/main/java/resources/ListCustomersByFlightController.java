package resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.FlightReservationsDao;
import model.FlightReservations;
/**
 * Servlet implementation class ListCustomersByFlightController
 */
public class ListCustomersByFlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCustomersByFlightController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("listCustomersByFlight.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int flightNum = Integer.parseInt((String)request.getParameter("flightNum"));
		String airlineID = request.getParameter("airlineID");
		FlightReservationsDao passDao = new FlightReservationsDao();
		List<FlightReservations> passengers = new ArrayList<FlightReservations>();
		passengers = passDao.getPassengerList(flightNum,airlineID);
		
		request.setAttribute("items", passengers);
		RequestDispatcher rd = request.getRequestDispatcher("showPassengerListForFlight.jsp");
		rd.forward(request, response);
	}

}
