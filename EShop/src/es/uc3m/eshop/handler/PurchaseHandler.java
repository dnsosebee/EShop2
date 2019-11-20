package es.uc3m.eshop.handler;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import es.uc3m.eshop.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PurchaseHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		HttpSession session = request.getSession();
		
		
		HashMap<Product, Integer> cartItems = (HashMap<Product, Integer>) session.getAttribute("cartItems");
		String cardNumber = request.getParameter("paymentCardNumber");
		double purchasePrice = Double.parseDouble((String) session.getAttribute("cartCost"));	
		ApplicationUser purchaseUser = (ApplicationUser) session.getAttribute("user");
		Date purchaseDate = new Date();
		
		
		
		Purchase purchase = new Purchase();
		purchase.setAu(purchaseUser);
		purchase.setCard(cardNumber);
		purchase.setDate(purchaseDate);
		purchase.setPrice(purchasePrice);
		purchase.setProducts(cartItems);
		
		
	
		
		
		return "purchase.jsp";
	}
}
