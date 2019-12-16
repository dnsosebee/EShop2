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

public class AdminDeleteUserHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("here");
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			return "login.html";
		}
		if (((ApplicationUser)session.getAttribute("user")).getRole() != 2) {
			return "error.jsp";
		}
		System.out.println("here");
		System.out.println("ADMIN DELETING");
		ApplicationUserManager aum = new ApplicationUserManager();


		ApplicationUser removeUser = (ApplicationUser) aum.findByEmail(request.getParameter("adminDeleteUser"));
		
		aum.delete(removeUser);
		
		System.out.println("ABOUT TO RETURN");
		return "deleteUserSuccess.jsp";
	}
}
