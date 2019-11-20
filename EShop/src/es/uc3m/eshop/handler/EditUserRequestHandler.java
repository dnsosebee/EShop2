package es.uc3m.eshop.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.uc3m.eshop.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditUserRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		ApplicationUserManager aum = new ApplicationUserManager();

	
		//Handles edit user for normal users and admin
		System.out.println("EDIT USER HANDLER");

		
		//Handles editing of users by the admin.
		if (request.getParameter("editUserEmail") != null) {
			

			ApplicationUser userToEdit = aum.findByEmail(request.getParameter("editUserEmail"));
			
			session.setAttribute("userToEdit", userToEdit);
			return "adminEditUser.jsp";
		}
		
		//Actually makes the changes
		//Edit user form has hidden value "userChanges" and contains the email of the user to be edited
		if (request.getParameter("userChanges") != null)
		{
			System.out.println("value of userChanges");
			System.out.println(request.getParameter("userChanges"));
			
			ApplicationUser userToEdit = aum.findByEmail(request.getParameter("userChanges"));
			
		
			String newName = request.getParameter("newName");
			String newSurname = request.getParameter("newSurname");
			String newPassword = request.getParameter("newPassword");
			String newAddress = request.getParameter("newAddress");
			int role = Integer.parseInt(request.getParameter("role"));
			
			userToEdit.setName(newName);
			userToEdit.setSurname(newSurname);
			userToEdit.setPassword(newPassword);
			userToEdit.setAddress(newAddress);
			userToEdit.setRole(role);

			aum.update(userToEdit);
			
			return "editSuccess.jsp";
			
		}
		
		
		
		
		

		return "editUser.jsp";
	}
}
