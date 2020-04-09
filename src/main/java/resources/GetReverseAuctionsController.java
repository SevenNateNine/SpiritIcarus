package resources;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import dao.AuctionsDao;
import model.Auctions;
/**
 * Servlet implementation class GetReverseAuctionsController
 */
public class GetReverseAuctionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReverseAuctionsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("showReverseAuctions.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int AccountNo = Integer.parseInt((String)request.getSession(false).getAttribute("customerID")); 
		String AirlineID = request.getParameter("airlineID"); 
		int FlightNo = Integer.parseInt((String)request.getParameter("flightNo")); 
		String SeatClass = request.getParameter("seatClass"); 
		
		AuctionsDao aucDao = new AuctionsDao();
		List<Auctions> auc = new ArrayList<Auctions>();
		String typeofquery = request.getParameter("typeofquery");
		if(typeofquery.equals("Get Latest Bid")){
			auc = aucDao.getLatestBid(AccountNo, AirlineID, FlightNo, SeatClass);
		}
		else if(typeofquery.equals("Get All Bids")) {
			auc = aucDao.getAllBids(AccountNo, AirlineID, FlightNo, SeatClass);
		}
		
		request.setAttribute("auctions", auc);
		RequestDispatcher rd = request.getRequestDispatcher("showBidsForAuctions.jsp");
		rd.forward(request, response);
		
	}

}
