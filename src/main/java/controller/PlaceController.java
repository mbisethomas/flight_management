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



import modal.Place;
import service.PlaceService;

/**
 * WebServlet implementation class PlaceController
 */
@WebServlet("/PlaceController")
public class PlaceController extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	// retrieve place details 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PlaceService ps = new PlaceService();
	List<Place> listOfPlace = ps.findAllPlace();
	request.setAttribute("listOfPlace", listOfPlace);
	RequestDispatcher rd = request.getRequestDispatcher("addPlace.jsp");
	rd.include(request, response);
	
	}

 // store place details 
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		PrintWriter pw = response.getWriter();
 		
 		response.setContentType("text/html");
 		
 		String pname = request.getParameter("pname");
 		
 		Place p = new Place();
 		p.setPname(pname);
 		
 		PlaceService ps = new PlaceService();
 		String result  = ps.storePlace(p);
 		
 		pw.println(result);
 		
 		RequestDispatcher rd = request.getRequestDispatcher("addPlace.jsp");
 		rd.include(request, response);
 		doGet(request, response);
 		
 	}

}
