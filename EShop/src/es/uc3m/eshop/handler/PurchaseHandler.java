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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

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
		
		BankVerification verification = null;
		
		verification.setFirstName(purchaseUser.getName());
		verification.setLastName(purchaseUser.getSurname());
		verification.setCardNumber(cardNumber);
		verification.setCardSecurity(request.getParameter("cardSecurity"));
		verification.setCardExpiry(request.getParameter("cardExpiry"));
		verification.setPurchasePrice(purchasePrice);
		
		System.out.println("TESTING POST TO BANK SERVICE");
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget webtarget = client.target("http://localhost:15810");
		WebTarget webtargetPath = webtarget.path("bank");
		Invocation.Builder invocationBuilder = webtargetPath.request(MediaType.APPLICATION_JSON);
		Response responseWS = invocationBuilder.post(Entity.entity(verification, MediaType.APPLICATION_JSON))	;	
		int status = responseWS.getStatus();
		
		System.out.println("POST STATUS: " + status);

		if (status == 200)
		{
			
			session.setAttribute("cartItems", new HashMap<Product,Integer>());
			double d = 0;
			session.setAttribute("cartCost", d);
			return "orderThanks.jsp";
			
		}
				
		System.out.println("TRYING MESSAGE STUFF");
		
		Context context;
		try {
			context = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) context.lookup("GatewayConfact");
			Queue queue = (Queue) context.lookup("GatewayQueue");
			Connection con = factory.createConnection();
			Session ses = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer prod = ses.createProducer(queue);
			ObjectMessage mess = ses.createObjectMessage();



			mess.setObject(verification);
			prod.send(mess);
			prod.close();
			ses.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "orderFail.jsp";
	}
}
