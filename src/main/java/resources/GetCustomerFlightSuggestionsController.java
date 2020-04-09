package resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FlightDao;
import model.Flight;

/**
 * Servlet implementation class GetCustomerFlightSuggestionsController
 */
public class GetCustomerFlightSuggestionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustomerFlightSuggestionsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int accountNo = Integer.parseInt((String)request.getParameter("accountNo"));
		FlightDao flightDao = new FlightDao();
		List<Flight> flights = new ArrayList<Flight>();
		flights = flightDao.getCustomerFlightSuggestions(accountNo);
		
		request.setAttribute("items", flights);
		RequestDispatcher rd = request.getRequestDispatcher("showCustomerFlightSuggestions.jsp");
		rd.forward(request, response);
	}

}
