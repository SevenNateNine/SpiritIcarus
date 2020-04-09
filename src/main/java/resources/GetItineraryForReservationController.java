package resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Itinerary;
import dao.ItineraryDao;
/**
 * Servlet implementation class GetItineraryForReservationController
 */
public class GetItineraryForReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetItineraryForReservationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int resrNo = Integer.parseInt((String)request.getParameter("resrNo"));
		
		ItineraryDao itDao = new ItineraryDao();
		List<Itinerary> it = new ArrayList<Itinerary>();
		it = itDao.getItineraryForReservation(resrNo);
		
		request.setAttribute("itinerary", it);
		RequestDispatcher rd = request.getRequestDispatcher("showItineraryForReservation.jsp");
		rd.forward(request, response);
	}

}
