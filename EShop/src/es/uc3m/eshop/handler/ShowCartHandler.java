package es.uc3m.eshop.handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.uc3m.eshop.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowCartHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			return "login.html";
		}
		
		if (((ApplicationUser)session.getAttribute("user")).getRole() != 0) {
			return "error.jsp";
		}
		
		return "showCart.jsp";
	}

}
