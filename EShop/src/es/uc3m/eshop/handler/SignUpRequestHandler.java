package es.uc3m.eshop.handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.uc3m.eshop.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("email")!=null) {
			
			ApplicationUser au = new ApplicationUser();
			au.setEmail(request.getParameter("email"));
			au.setAddress(request.getParameter("address"));
			au.setName(request.getParameter("name"));
			au.setSurname(request.getParameter("surname"));
			au.setRole(0);
			au.setPassword(request.getParameter("password"));
			
			
			System.out.println(au.getEmail()+ " " +au.getAddress()+ " "+au.getEmail()+ " "+au.getName()+ " "+au.getSurname()+ " "+au.getRole()+ " ");
			
			ApplicationUserManager aum = new ApplicationUserManager();
			aum.insert(au);
			
			return "index.html";
		}
		else {
			System.out.println("holaaa!!");
			return "signup.jsp";
		}
	}

}
