package es.uc3m.eshop.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uc3m.eshop.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			return "login.html";
		}
		
		System.out.println("HANDLING CART");
		ProductManager pm = new ProductManager();

		HashMap<Product, Integer> cartItems = (HashMap<Product, Integer>) session.getAttribute("cartItems");
		double cartCost;

		System.out.println("CART ITEMS: " + cartItems);
		// adding product to cart

		Product addProduct;
		int quantity;

		List<Product> itemsToRemove = new ArrayList<Product>();
		//Update cart quantities
		if (request.getParameter("updateCart") != null) {
			System.out.println("GETTING READY TO UPDATE THE CART");
			if (request.getParameter("cartProductId") != null) {
				cartItems.put(pm.findById(request.getParameter("cartProductId")), Integer.parseInt(request.getParameter("newProductQuantity")));
			} else {
				for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
					if (request.getParameter("newProductQuantity_" + entry.getKey().getIdProduct()) != null) {
						int newQuantity = Integer.parseInt(request.getParameter("newProductQuantity_" + entry.getKey().getIdProduct()));
						entry.setValue(newQuantity);
						if (newQuantity == 0) {
							itemsToRemove.add(entry.getKey());
						}
					}
				}
			}
			for (Product p : itemsToRemove) {
				cartItems.remove(p);
			}
			
			session.setAttribute("cartItems", cartItems);
			
			System.out.println("Quantities Updated");
			cartCost = pm.calculateCart(cartItems);
			session.setAttribute("cartCost", cartCost);
			System.out.println(cartCost);
			
			return "showCart.jsp";

		}

		if (pm.findById(request.getParameter("cartProductId")) != null
				&& request.getParameter("productQuantity") != null) {
			addProduct = pm.findById(request.getParameter("cartProductId"));
			quantity = Integer.parseInt(request.getParameter("productQuantity"));
			cartItems.put(addProduct, quantity);
			session.setAttribute("cartItems", cartItems);
			cartCost = pm.calculateCart(cartItems);
			session.setAttribute("cartCost", cartCost);
			
			return "showCart.jsp";
		}

		return "error.jsp";

	}

}
