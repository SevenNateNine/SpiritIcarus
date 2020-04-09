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
 * Servlet implementation class GetCustomerCurrentReservationsController
 */
public class GetCustomerCurrentReservationsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustomerCurrentReservationsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		FlightReservationsDao resDao = new FlightReservationsDao();
        int accountNo = Integer.parseInt((String)request.getSession(false).getAttribute("customerID"));
        
        List<FlightReservations> reservations = resDao.getCurrentReservations(accountNo);
        
		request.setAttribute("reservations", reservations);
		
		RequestDispatcher rd = request.getRequestDispatcher("showCustomerReservations.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
