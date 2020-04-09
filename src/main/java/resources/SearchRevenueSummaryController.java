package resources;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FlightReservationsDao;
import model.FlightReservations;

/**
 * Servlet implementation class SearchRevenueSummaryController
 */
public class SearchRevenueSummaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRevenueSummaryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("searchRevenueSummary.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int flightNum = 0;
		String airlineID = "";
		String customerName = "";
		String destCity = "";
		FlightReservationsDao resDao = new FlightReservationsDao();
        if (request.getParameterMap().containsKey("flightNum") && request.getParameterMap().containsKey("airlineID")) {
            flightNum = Integer.parseInt((String)request.getParameter("flightNum")); 
            airlineID = request.getParameter("airlineID");
        }
        // Check if password parameter exists
        else if (request.getParameterMap().containsKey("customerName")) {
            customerName = request.getParameter("customerName");
        }
        else if (request.getParameterMap().containsKey("destCity")) {
        	destCity = request.getParameter("destCity");
        }
        
        List<FlightReservations> reservations = resDao.getRevenueSummary(flightNum,airlineID,customerName,destCity);
        
		request.setAttribute("reservations", reservations);
		
		RequestDispatcher rd = request.getRequestDispatcher("showReservationRevenue.jsp");
		rd.forward(request, response);
	}

}
