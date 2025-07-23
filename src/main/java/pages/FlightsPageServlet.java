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
		//String from = request.getParameter("from");
		
		String to = request.getParameter("to");
		to = to.toLowerCase()+" flights";
		
		DataManager.getFlightsList("New York Flights");
		
		int index = 0;
		for(String sheetName: DataManager.getSheetNames()) {
			if(sheetName.toLowerCase().equals(to))break;
			else ++index;
		}
		
		
		if(index<DataManager.getSheetNames().size()) {
			String flightsJSON = DataManager.getFlightsList(DataManager.getSheetNames().get(index)).jsonify();
			
			
			HttpSession session = request.getSession();
			session.setAttribute("flightCard", flightsJSON);
			
			request.getRequestDispatcher("/flightPage.jsp").forward(request, response);
		}
		
		else request.getRequestDispatcher("/NoExistingFlightPage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
