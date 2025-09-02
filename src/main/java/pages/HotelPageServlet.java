package pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HotelPageServlet
 */
@WebServlet("/HotelPageServlet")
public class HotelPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.getRequestDispatcher("/hotelPageFolder/hotelPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightJson = request.getParameter("flight");

        if (flightJson != null && !flightJson.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("trip", session.getAttribute("trip") + flightJson);
        }

        
        if(request.getCookies().length!=0)for(Cookie cookie: request.getCookies())System.out.println(cookie.getName() +", "+ cookie.getValue());
        
        // Redirect or forward to next page
        response.sendRedirect("HotelPageServlet");
    }

}
