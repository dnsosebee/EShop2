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

		System.out.println("EDIT USER REQUEST HANDLER");

		HttpSession session = request.getSession();

		System.out.println("got Session");

		if (session.getAttribute("user") == null) {
			System.out.println("USER NULL");
			return "login.html";
		}
		
		//I don't know what this is doing here
//		if (((ApplicationUser) session.getAttribute("user")).getRole() != 2) {
//
//			return "error.jsp";
//		}
		ApplicationUserManager aum = new ApplicationUserManager();

		// Handles edit user for normal users and admin
		// Handles editing of users by the admin.
		System.out.println("HANDLE ADMIN EDIT");
		if (request.getParameter("editUserEmail") != null) {

			ApplicationUser userToEdit = aum.findByEmail(request.getParameter("editUserEmail"));

			session.setAttribute("userToEdit", userToEdit);
			return "adminEditUser.jsp";
		}

		// Actually makes the changes
		// Edit user form has hidden value "userChanges" and contains the email of the
		// user to be edited
		System.out.println("MAKING CHANGES");
		if (request.getParameter("userChanges") != null) {
			
			System.out.println("value of userChanges");
			System.out.println(request.getParameter("userChanges"));
			
			
			System.out.println("FIND BY EMAIL");

			ApplicationUser userToEdit = aum.findByEmail(request.getParameter("userChanges"));

			
			System.out.println("DONT THINK WE MAKE IT HERE");
			
			String newName = request.getParameter("newName");
			String newSurname = request.getParameter("newSurname");
			String newPassword = request.getParameter("newPassword");
			String newAddress = request.getParameter("newAddress");
			
			//THERE IS NO FIELDS FOR THESE!?
			try {
				Integer role = Integer.parseInt(request.getParameter("role"));
				if (role != null) {
					userToEdit.setRole(role);
				}
			} catch (Exception e) {}
			


			userToEdit.setName(newName);
			userToEdit.setSurname(newSurname);
			userToEdit.setPassword(newPassword);
			userToEdit.setAddress(newAddress);

			System.out.println("ABOUT TO PASS AUM.UPDATE");
			System.out.println("USER: " + userToEdit.getEmail());
			aum.update(userToEdit);

			return "editSuccess.jsp";

		}

		return "editUser.jsp";
	}
}
