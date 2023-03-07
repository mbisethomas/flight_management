package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;

/**
 * WebServlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

 // store place details 
  	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		PrintWriter pw = response.getWriter();
  		RequestDispatcher rd;
  		response.setContentType("text/html");
  		
  		String adminemail = request.getParameter("adminemail");
  		String adminPassword =request.getParameter("adminPassword");
  		
  		
  		LoginService ls = new LoginService();
  		int adminId = 0;
		try {
			adminId = ls.adminLogin(adminemail,adminPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  		if(adminId>0) {
  			HttpSession session = request.getSession();
			session.setAttribute("adminId", adminId);
			rd = getServletContext().getRequestDispatcher("/viewFlight.jsp");
            rd.forward(request, response);	
		}else {
			
			request.setAttribute("loginerr", "Incorrect email or Password");
			rd = getServletContext().getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
  		
  	}
  	
  	}
}