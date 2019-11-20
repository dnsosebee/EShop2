package es.uc3m.eshop.handler;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import es.uc3m.eshop.model.*;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.ObjectMessage;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PurchaseHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("HANDLING PURCHASE");
		
		
		
		HttpSession session = request.getSession();
		
		
		HashMap<Product, Integer> cartItems = (HashMap<Product, Integer>) session.getAttribute("cartItems");
		String cardNumber = request.getParameter("paymentCardNumber");
		double purchasePrice = (double) session.getAttribute("cartCost");
		ApplicationUser purchaseUser = (ApplicationUser) session.getAttribute("user");
		Date purchaseDate = new Date();
		
		
		System.out.println("ADDING TO OBJECT");
		
		
		Purchase purchase = new Purchase();
		purchase.setAu(purchaseUser);
		purchase.setCard(cardNumber);
		purchase.setDate(purchaseDate);
		purchase.setPrice(purchasePrice);
		purchase.setProducts(cartItems);
		
		
		Context context;
		
		System.out.println("TRYING MESSAGE STUFF");
		try {
			context = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) context.lookup("GatewayConfact");
			Queue queue = (Queue) context.lookup("GatewayQueue");
			Connection con = factory.createConnection();
			Session ses = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer prod = ses.createProducer(queue);
			ObjectMessage mess = ses.createObjectMessage();
			
			
			
			mess.setObject(purchase);
			prod.send(mess);
			prod.close();
			ses.close();
			con.close();
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		Logger log = Logger.getLogger(PurchaseHandler.class.getName());
		log.info("log test");
	
		
		
		return "orderThanks.jsp";
	}
}
