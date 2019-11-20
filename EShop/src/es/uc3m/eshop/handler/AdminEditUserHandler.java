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

public class AdminEditUserHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ApplicationUserManager aum = new ApplicationUserManager();

		
	
		List<ApplicationUser> allUsers = aum.findAll();
		request.setAttribute("allUsers", allUsers);

		
		
		return "adminEditUsers.jsp";
	}
}
