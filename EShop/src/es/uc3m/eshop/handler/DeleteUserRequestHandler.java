package es.uc3m.eshop.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import es.uc3m.eshop.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteUserRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//Grabs the user from the session and redirects to the userProfile page

		System.out.println("HANDLING DELETION");

		HttpSession session = request.getSession();
		
		ApplicationUser au;
		au = (ApplicationUser) session.getAttribute("user");
		
		if (au == null) {
			return "login.html";
		}
		
		ApplicationUserManager aum = new ApplicationUserManager();
		if (aum.delete(au))
		{
			if (au.getRole()==2) {
				return "deleteUserSuccess.jsp";
			} else {
				return "logout.html";
			}
		}
		else
		{
			return "error.jsp";
		}
		//Check if there is a user in the session and direct to the login page if not
		
	
		
	}

}
