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
import java.util.UUID;

import modal.Customer;
import service.CustomerService;

	/**
	 * WebServlet implementation class CustomerController
	 */
	@WebServlet("/CustomerController")
	public class CustomerController  extends HttpServlet{
		private static final long serialVersionUID = 1L;
	    
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public CustomerController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	    
	 // retrieve Customer booking details 
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerService ps = new CustomerService();
		//get flight id
		int flightid = Integer.parseInt(request.getParameter("fid"));
		Float frprice=Float.parseFloat(request.getParameter("fare"));
		session.setAttribute("cflightid",flightid);
		session.setAttribute("cprice",frprice);
		session.setAttribute("cnoPassenger", session.getAttribute("noPassenger"));
		session.setAttribute("clistOfAvailabeFlight", session.getAttribute("clistOfAvailabeFlight"));
		RequestDispatcher rd = request.getRequestDispatcher("registerCustomer.jsp");
		rd.include(request, response);
		
		}
		
	 // store Customer details 
	 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 		PrintWriter pw = response.getWriter();
	 		HttpSession session = request.getSession();
	 		response.setContentType("text/html");
	 		
	 		String cfirstname = request.getParameter("cfirstname");
	 		String clastname = request.getParameter("clastname");
	 		String cphone = request.getParameter("cphone");

			String cuniqueID = UUID.randomUUID().toString();
	 		Customer c = new Customer();
	 		c.setCfirstname(cfirstname);
	 		c.setClastname(clastname);
	 		c.setCphone(cphone);
	 		c.setCuniqueid(cuniqueID);
	 		
	 		CustomerService cs = new CustomerService();
	 		int cresult  = cs.storeCustomer(c);
	 			 		
	 		RequestDispatcher rd;
	 		session.setAttribute("cflightid",session.getAttribute("cflightid"));
	 		session.setAttribute("cprice",session.getAttribute("cprice"));
			session.setAttribute("cnoPassenger", session.getAttribute("noPassenger"));
			session.setAttribute("clistOfAvailabeFlight", session.getAttribute("clistOfAvailabeFlight"));
			if(cresult>0) {
		 		int ccid =cs.getcustomerBYuuid(cuniqueID);
		 	//	System.out.println(ccid);
	 		if(ccid>0) {
	 		session.setAttribute("custfirstname",cfirstname);	
	 		session.setAttribute("custlastname",clastname);
	 		session.setAttribute("custphone",cphone);
	 		session.setAttribute("customerId",ccid);
	 		int noofp =(int)session.getAttribute("cnoPassenger");
	 		for(int i=0; i<noofp; i++){
	 			int seatno=(4+cresult+i);
		 		String ticketno ="FAC"+cresult+"-F"+session.getAttribute("cflightid")+"-S"+seatno;
		 		session.setAttribute("customerticketno"+i+"",ticketno);
		 		session.setAttribute("customerseatno"+i+"",seatno);	
	 		}}
	 		
	 		rd = request.getRequestDispatcher("completeBooking.jsp");
	 		}else {
	 		rd = request.getRequestDispatcher("customerRegister.jsp");	
	 		}
	 			 		
	 		rd.include(request, response);
	 		doGet(request, response);
	 		
	 	}

	}


