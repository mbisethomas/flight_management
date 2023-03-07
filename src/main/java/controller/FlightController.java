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

import modal.Flight;
import service.FlightService;

/**
 * WebServlet implementation class FlightController
 */
@WebServlet("/FlightController")

public class FlightController extends HttpServlet{
		private static final long serialVersionUID = 1L;
	    
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public FlightController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	    
	 // retrieve flight details 
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightService ps = new FlightService();
		List<Flight> listOfFlight = ps.findAllFlight();
		request.setAttribute("listOfFlight", listOfFlight);
		RequestDispatcher rd = request.getRequestDispatcher("addFlight.jsp");
		rd.include(request, response);
		
		}

	 // store flight details 
	 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 		PrintWriter pw = response.getWriter();
	 		
	 		response.setContentType("text/html");
	 		
	 		int fairline = Integer.parseInt(request.getParameter("fairline"));
	 		String fdate = request.getParameter("fdate");
     		int fsource = Integer.parseInt(request.getParameter("fsource"));
		    int fdestination =Integer.parseInt(request.getParameter("fdestination"));
     		Float fprice =Float.parseFloat(request.getParameter("fprice"));
	 		
	 		Flight f = new Flight();
	 		f.setFairline(fairline);
	 		f.setFdate(fdate);
	 		f.setFdestination(fdestination);
	 		f.setFsource(fsource);
	 		f.setFprice(fprice);
	 		
	 		
	 		FlightService fs = new FlightService();
	 		String result  = fs.storeFlight(f);
	 		RequestDispatcher rd;
	 	//	pw.println(result);
	 		
	 		if(result == "SUCCESS") {
				request.setAttribute("SUCCESS", "Flight data stored successfully");
				rd = getServletContext().getRequestDispatcher("/addFlight.jsp");
				rd.forward(request, response);
			}else if(result == "FAIL") {

				request.setAttribute("FAIL", "Fail to Store Flight Data");
				rd = getServletContext().getRequestDispatcher("/addFlight.jsp");
				rd.forward(request, response);
			}
	 		
	 		
	 		//doGet(request, response);
	 		
	 	}


}
