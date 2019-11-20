package es.uc3m.eshop.handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.uc3m.eshop.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProductPageRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ProductManager pm = new ProductManager();
		if (request.getParameter("id") == null) {
			return "error.jsp";
		}
		Product p = pm.findById(request.getParameter(("id")));
		if (p == null) {
			return "error.jsp";
		}
		
		HttpSession session = request.getSession();
		if (session.getAttribute("cartItems") != null) {
			HashMap<Product,Integer> cart  = (HashMap<Product,Integer>) session.getAttribute("cartItems");
			if (cart.containsKey(p)) {
				request.setAttribute("amountInCart", cart.get(p));
			}
		}
		
		request.setAttribute("product", p);
		return "product-page.jsp";
	}
}
