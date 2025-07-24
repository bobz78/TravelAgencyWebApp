package pages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datas.DataManager;

/**
 * Servlet implementation class MainPageServlet
 */
@WebServlet("/FlightsPageServlet")
public class FlightsPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightsPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		DataManager.setup();
		
		
		
		String to = request.getParameter("to");
		String to_FlightUse = to.toLowerCase()+" flights";
		String to_hotelUse = to.toLowerCase()+" hotels";
		
		String departureDate = request.getParameter("depart");
		String returnDate = request.getParameter("return");
		
		int flightIndex = 0;
		for(String sheetName: DataManager.getSheetNames()) {
			if(sheetName.toLowerCase().equals(to_FlightUse))break;
			else ++flightIndex;
		}
		
		int hotelIndex = 0;
		for(String sheetName: DataManager.getSheetNames()) {
			if(sheetName.toLowerCase().equals(to_hotelUse))break;
			else ++hotelIndex;
		}
		
		
		if(flightIndex<DataManager.getSheetNames().size()) {
			String flightsJSON = DataManager.getFlightsList(DataManager.getSheetNames().get(flightIndex)).jsonify();
			String hotelJSON = DataManager.getFlightsList(DataManager.getSheetNames().get(hotelIndex)).jsonify();
			
			HttpSession session = request.getSession();
			session.setAttribute("flightCard", flightsJSON);
			session.setAttribute("hotelCard", hotelJSON);
			session.setAttribute("departure", departureDate);
			session.setAttribute("return", returnDate);
			session.setAttribute("trip", "");
			
			request.getRequestDispatcher("/flightPageFolder/flightPage.jsp").forward(request, response);
		}
		else request.getRequestDispatcher("/flightPageFolder/NoExistingFlightPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
