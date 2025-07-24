package pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datas.Trip;

/**
 * Servlet implementation class PaymentPageServlet
 */
@WebServlet("/TripPageServlet")
public class TripPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("tripPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String hotelJson = request.getParameter("hotel");

        if (hotelJson != null && !hotelJson.isEmpty()) {
            HttpSession session = request.getSession();
            String tripJson = (String) session.getAttribute("trip");
            session.setAttribute("trip", tripJson+hotelJson);
            
            Trip trip = new Trip((String) session.getAttribute("trip"));
            session.setAttribute("trip", trip.jsonify());
            
            String departureDate = (String)session.getAttribute("departure");
            String returnDate = (String)session.getAttribute("return");
            
            double totalCost = trip.tripTotalCost(departureDate, returnDate);
            String totalCostString = totalCost+"";
            session.setAttribute("totalCost", totalCostString);
            
        }

        // Redirect or forward to next page
        response.sendRedirect("TripPageServlet");
	}

}
