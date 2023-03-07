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
 * WebServlet implementation class ChangePassController
 */
@WebServlet("/ChangePassController")
public class ChangePassController extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassController() {
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
  		
  		String oldPassword = request.getParameter("oldPassword");
  		String newPassword =request.getParameter("newPassword");
  		String confirmPassword =request.getParameter("confirmPassword");
  		int adminId =(int)session.getAttribute("adminId");
  		LoginService ls = new LoginService();
        if(newPassword.equals( confirmPassword)) {
        	String apass = ls.findAdminPass(adminId);
        	if(apass.equals(oldPassword)) {
        	String result=ls.updateAdminPass(newPassword,adminId);
        	
        	if(result == "SUCCESS") {
        		session.setAttribute("adminId",adminId);
				request.setAttribute("SUCCESS", "Password Changed successfully");
				rd = getServletContext().getRequestDispatcher("/viewFlight.jsp");
				rd.forward(request, response);
			}else if(result == "FAIL") {
				session.setAttribute("adminId",adminId);
				request.setAttribute("FAIL", "Fail to ChangePassword");
				rd = getServletContext().getRequestDispatcher("/changePassword.jsp");
				rd.forward(request, response);
			}
        	
        	}else {
        		session.setAttribute("adminId",adminId);
        		session.setAttribute("failoldpass","Incorrect Old Password");
    			rd = getServletContext().getRequestDispatcher("/changePassword.jsp");
                rd.forward(request, response);
        	}
  		}else {
  			session.setAttribute("adminId",adminId);
    		session.setAttribute("failconfirm","Confirm PassMissmatch");
			rd = getServletContext().getRequestDispatcher("/changePassword.jsp");
            rd.forward(request, response);
  		}
  		
  		
  	
  	}
}