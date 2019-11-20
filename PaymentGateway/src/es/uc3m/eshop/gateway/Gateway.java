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

public class Gateway implements MessageListener {

	MessageConsumer cons;
	Connection con;
	Session ses;

	public void start() {
		try {
			Context context;
			context = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) context.lookup("GatewayConfact");
			Queue queue = (Queue) context.lookup("GatewayQueue");
			con = factory.createConnection();
			ses = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			con.start();
			cons = ses.createConsumer(queue);
			ses.setMessageListener(new Gateway());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void stop() {
		try {
			cons.close();
			ses.close();
			con.close();
		} catch (Exception e) {;}
	}

	@Override
	public void onMessage(Message obj) {
		
		try{
			Purchase purchase = (Purchase) ((ObjectMessage)obj).getObject();
			OrderManager om = new OrderManager();
			ProductManager pm = new ProductManager();
			List<Product> products = pm.findAll();
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
			for (Map.Entry<Product, Integer> entry : purchase.getProducts().entrySet()) {
				int product = entry.getKey().getIdProduct();
				int quantity = entry.getValue();
				if (map.get(product) < quantity) {
					new MessageSender().sendFailureMessage(purchase.getAu().getEmail());
					return;
				}
			}
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
				OrderProductPK pk = new OrderProductPK();
				pk.setIdOrder(order.getIdOrder());
				pk.setIdProduct(product.getIdProduct());
				om.insert(pk);
				
				OrderProduct op = new OrderProduct();
				op.setId(pk);
				op.setMyOrder(order);
				op.setProduct(product);
				op.setQuantity(quantity);
				om.insert(op);
			}
			new MessageSender().sendSuccessMessage(purchase.getAu().getEmail(),order.getIdOrder());
		} catch (Exception e) {;}
		
	}
}