package es.uc3m.eshop.gateway;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import es.uc3m.eshop.model.*;

public class Gateway {

	MessageConsumer cons;
	Connection con;
	Session ses;

	public void start() {
		System.out.println("STARTING GATEWAY");
		try {
			Context context;
			context = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) context.lookup("GatewayConfact");
			Queue queue = (Queue) context.lookup("GatewayQueue");
			con = factory.createConnection();
			ses = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			con.start();
			cons = ses.createConsumer(queue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void stop() {
		System.out.println("STOPPING GATEWAY");
		try {
			cons.close();
			ses.close();
			con.close();
		} catch (Exception e) {;}
	}

	public void nextMessage() {
		try{
			Message obj =  cons.receive();
			System.out.println("ON MESSAGE GATEWAY");
			Purchase purchase = (Purchase) ((ObjectMessage)obj).getObject();

			OrderManager om = new OrderManager();
			ProductManager pm = new ProductManager();
			List<Product> products = pm.findAll();
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
			for (Product p : products) {
				map.put(p.getIdProduct(), p.getStock());
			}
			for (Map.Entry<Product, Integer> entry : purchase.getProducts().entrySet()) {
				int product = entry.getKey().getIdProduct();
				int quantity = entry.getValue();
				if (map.get(product) < quantity) {
					new MessageSender().sendFailureMessage(purchase.getAu().getEmail());

					System.out.println("ON MESSAGE GATEWAY 3");
					return;
				}
			}

			System.out.println("Good ORDER?");
			List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
			MyOrder order = new MyOrder();
			order.setApplicationUser(purchase.getAu());
			order.setDate(purchase.getDate());
			order.setOrderProducts(orderProducts);
			order.setTotal(BigDecimal.valueOf(purchase.getPrice()));
			order = om.insert(order);
			for (Map.Entry<Product, Integer> entry : purchase.getProducts().entrySet()) {
				Product product = entry.getKey();
				int quantity = entry.getValue();
				product.setStock(product.getStock() - quantity);
				pm.update(product);
			} 
			System.out.println("NEW MESSAGE?");
			new MessageSender().sendSuccessMessage(purchase.getAu().getEmail(),order.getIdOrder());
		} catch (Exception e) {e.printStackTrace();}
	}
}