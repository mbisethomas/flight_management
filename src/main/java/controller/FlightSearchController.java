package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import modal.Flight;
import service.FlightService;
	/**
	 * WebServlet implementation class FlightSearchController
	 */
	@WebServlet("/FlightSearchController")
	public class FlightSearchController extends HttpServlet{
		private static final long serialVersionUID = 1L;
	    
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public FlightSearchController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	 // store place details 
	  	@SuppressWarnings("unused")
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  		PrintWriter pw = response.getWriter();
	  		HttpSession session = request.getSession();
	  		RequestDispatcher rd;
	  		response.setContentType("text/html");
	  		
	  		int travelFrom = Integer.parseInt(request.getParameter("travelFrom"));
	  		int travelTo =Integer.parseInt(request.getParameter("travelTo"));
	  		String travelDate =request.getParameter("travelDate");
	  		int noPassenger =Integer.parseInt(request.getParameter("noPassenger"));
	  		session.setAttribute("noPassenger",noPassenger);
	  		FlightService fs = new FlightService();
	  		List<String[]> result;
			try {
				result = fs.fetchAvailableFlight(travelFrom,travelTo,travelDate);
//				System.out.println(result.size());
				session.setAttribute("clistOfAvailabeFlight", result);
				request.setAttribute("listOfAvailabeFlight", result);
				rd = getServletContext().getRequestDispatcher("/viewAvailableFlight.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  		
	  		
				
	        		
	  		}
	  		
	  		
	  	
	  	}

