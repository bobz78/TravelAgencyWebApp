package pages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datas.DataManager;
import datas.TripDates;

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
		for(String sheetName: DataManager.getExistingFlightsNames()) {
			if(sheetName.toLowerCase().equals(to_FlightUse))break;
			else ++flightIndex;
		}
		
		int hotelIndex = 0;
		for(String sheetName: DataManager.getExistingHotelsNames()) {
			if(sheetName.toLowerCase().equals(to_hotelUse))break;
			else ++hotelIndex;
		}
		
		
		if(flightIndex<DataManager.getExistingFlightsNames().size()) {

			
			String hotelsJSON = DataManager.getHotelsList(DataManager.getExistingHotelsNames().get(hotelIndex)).jsonify();
			String flightsJSON = DataManager.getFlightsList(DataManager.getExistingFlightsNames().get(flightIndex)).jsonify();
			
			HttpSession session = request.getSession();
			
			
			session.setAttribute("flightCard", flightsJSON);
			session.setAttribute("hotels", hotelsJSON);
			session.setAttribute("departure", departureDate);
			session.setAttribute("return", returnDate);
			TripDates dates = new TripDates(departureDate, returnDate);
			session.setAttribute("trip", "tripDates"+dates.jsonify()); 

			
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
