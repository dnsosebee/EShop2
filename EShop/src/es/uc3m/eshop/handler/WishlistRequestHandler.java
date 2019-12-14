package es.uc3m.eshop.handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uc3m.eshop.model.ApplicationUser;
import es.uc3m.eshop.model.ApplicationUserManager;
import es.uc3m.eshop.model.Product;

public class WishlistRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		System.out.println("WISHLIST REQUEST HANDLER");
		
		
		ApplicationUser auxiliar, au;
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			return "login.html";
		}
		auxiliar = (ApplicationUser) session.getAttribute("user");
		ApplicationUserManager aum=new ApplicationUserManager();
		au = aum.findByEmail(auxiliar.getEmail());

		if (au.getRole() != 0) {
			return "error.jsp";
		}
		
		
		
		List<Product> list = aum.getUserWishlist(au);
		request.setAttribute("products", list);

		return "wishlist.jsp";	
	}
}
