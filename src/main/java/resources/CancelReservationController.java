package resources;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FlightReservationsDao;

/**
 * Servlet implementation class CancelReservationController
 */
public class CancelReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelReservationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int resrNo = Integer.parseInt((String)request.getParameter("resrNo"));
		FlightReservationsDao resDao = new FlightReservationsDao();
        
        String result = resDao.cancelReservation(resrNo);
        
		if(result.equals("success")) {
			response.sendRedirect("home.jsp?status=deleteSuccess");
		}
		else {
			response.sendRedirect("home.jsp?status=deleteFailure");
		}
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
