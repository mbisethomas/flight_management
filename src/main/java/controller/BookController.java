package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modal.Book;
import modal.Customer;
import service.BookService;
import service.CustomerService;


	/**	 * WebServlet implementation class BookController
	 */
	@WebServlet("/BookController")
	public class BookController  extends HttpServlet{
		private static final long serialVersionUID = 1L;
	    
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public BookController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	    
	 // retrieve Customer booking details 
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		BookService ps = new BookService();
		//get flight id
		int flightid = Integer.parseInt(request.getParameter("cfid"));
		int fcustid = Integer.parseInt(request.getParameter("fcid"));
		int nofpassenger = Integer.parseInt(request.getParameter("nofp"));
		Book b = new Book();
 		b.setCid(fcustid);
 		b.setFid(flightid);
 		b.setNopassenger(nofpassenger);
		float totalprice=Float.parseFloat(request.getParameter("totl"));
		for(int i=0; i<nofpassenger; i++){
 			int seatno=(4+fcustid+i);
	 		String ticketno ="FAC"+fcustid+"-F"+flightid+"-S"+seatno;
	 		b.setSeatno(seatno);
	 		b.setTicketno(ticketno);
	 		
	 		BookService bs = new BookService();
	 		   bs.storeBookingdata(b);
 		}
	//	pw.println("Thank You For Booking with Us");
		request.setAttribute("SUCCESS", "Thank You For Booking with Us");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
		
		}
}
