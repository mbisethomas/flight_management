package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modal.Airline;
import service.AirlineService;

/**
 * WebServlet implementation class AirlineController
 */
@WebServlet("/AirlineController")

public class AirlineController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	    
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public AirlineController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	    
		// retrieve place details 
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AirlineService as = new AirlineService();
		List<Airline> listOfAirline = as.findAllAirline();
		request.setAttribute("listOfAirline", listOfAirline);
		RequestDispatcher rd = request.getRequestDispatcher("addAirline.jsp");
		rd.include(request, response);
		
		}

	 // store place details 
	 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 		PrintWriter pw = response.getWriter();
	 		
	 		response.setContentType("text/html");
	 		
	 		String aname = request.getParameter("aname");
	 		
	 		Airline a = new Airline();
	 		a.setAname(aname);
	 		
	 		AirlineService as = new AirlineService();
	 		String result  = as.storeAirline(a);
	 		
	 		//pw.println(result);
	 		
	 		RequestDispatcher rd = request.getRequestDispatcher("addAirline.jsp");
	 		rd.include(request, response);
	 		doGet(request, response);
	 		
	 	}


}
