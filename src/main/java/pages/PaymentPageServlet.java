package pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentPageServlet
 */
@WebServlet("/PaymentPageServlet")
public class PaymentPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = (String) request.getParameter("email");
		String nameOnCard = (String) request.getParameter("cardName");
		String cardNumber = (String) request.getParameter("cardNumber");
		String cvv = (String) request.getParameter("cvv");
		String expiryDate = (String) request.getParameter("expiry");
		
		System.out.println("|" + "Email: " + email + "|" +
				"\n" + "|" + "Name On Card: " + nameOnCard + "|" +
				"\n" + "|" + "Card Number: " + cardNumber + "|" +
				"\n" + "|" + "cvv: " + cvv + "|" +
				"\n" + "|" + "Expiry Date: " + expiryDate + "|");
		
		request.getRequestDispatcher("/thankYouPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
