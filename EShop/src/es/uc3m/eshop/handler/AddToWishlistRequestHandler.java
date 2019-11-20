package es.uc3m.eshop.handler;
import java.io.IOException;

import es.uc3m.eshop.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToWishlistRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

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
		ApplicationUser au = (ApplicationUser)session.getAttribute("user");
		ApplicationUserManager aum = new ApplicationUserManager();
		aum.addToWishlist(au, Integer.parseInt(request.getParameter("id")));
		return "wishlist.html";
	}
}
