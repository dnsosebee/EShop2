package es.uc3m.eshop.handler;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		
		HttpSession session = request.getSession();
		String cardNumber = request.getParameter("creditCard");
		ApplicationUser purchaseUser = (ApplicationUser) session.getAttribute("user");
		
		
		System.out.println("ADDING TO OBJECT");
		
		BankVerification verification = new BankVerification();
		
		verification.setCardNumber(cardNumber);
		verification.setCardSecurity(request.getParameter("cvv"));
		verification.setCardExpiry(request.getParameter("expiry"));
		
		System.out.println("CARD NUMBER");
		System.out.println(verification.getCardNumber());
		
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
			OrderManager om = new OrderManager();
			MyOrder order = new MyOrder();
			order.setOldProducts(new ArrayList<OldProduct>());
			
			for (Map.Entry<Product, Integer> entry : ((HashMap<Product,Integer>)session.getAttribute("cartItems")).entrySet()) {
				Product p = entry.getKey();
				
				p.setStock(p.getStock() - entry.getValue());
				ProductManager pm = new ProductManager();
				pm.update(p);
				
				OldProduct oldProduct = new OldProduct();
				oldProduct.setApplicationUser(p.getSeller());
				oldProduct.setDescription(p.getDescription());
				oldProduct.setName(p.getName());
				oldProduct.setPricePerUnit(p.getPrice());
				oldProduct.setProductImage(p.getProductImage());
				oldProduct.setUnits(entry.getValue());
				order.addOldProduct(oldProduct);
			}
			
			order.setDate(new Date().toString());
			order.setOwner(purchaseUser.getEmail());
			order.setTotal(new BigDecimal((Double)session.getAttribute("cartCost")));
			
			om.insert(order);
			
			MessageSender ms = new MessageSender();
			ms.sendSuccessMessage(purchaseUser.getEmail(), 2);
			
			session.setAttribute("cartItems", new HashMap<Product,Integer>());
			double d = 0;
			session.setAttribute("cartCost", d);
			return "orderThanks.jsp";
			
		}
		MessageSender ms = new MessageSender();
		ms.sendFailureMessage(purchaseUser.getEmail());
		return "orderThanks.jsp";
}}