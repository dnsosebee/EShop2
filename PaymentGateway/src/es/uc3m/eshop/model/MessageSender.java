package es.uc3m.eshop.model;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class MessageSender {

	
	public void sendSuccessMessage(String email, int idOrder) {
		Context context;
		try {
			context = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) context.lookup("confact");
			Queue queue = (Queue) context.lookup("xxx");
		    Connection con = factory.createConnection();
		    Session ses = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer prod = ses.createProducer(queue);
			ObjectMessage mess = ses.createObjectMessage();
			
			mess.setStringProperty("recipientEmail",email);
			
			EShopMessage messageObject = new EShopMessage();
			messageObject.setMessage("Your order has been placed successfully and is being processed. The confirmation number of this order is " + idOrder + ". Please check your order history for more information about this order.");
			messageObject.setTitle("Your Order Has Been Placed!");
			messageObject.setSenderEmail(email);
			messageObject.setUserType(0);
			
			mess.setObject(messageObject);
			prod.send(mess);
			prod.close();
			ses.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void sendFailureMessage(String email) {
		Context context;
		try {
			context = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) context.lookup("confact");
			Queue queue = (Queue) context.lookup("xxx");
		    Connection con = factory.createConnection();
		    Session ses = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer prod = ses.createProducer(queue);
			ObjectMessage mess = ses.createObjectMessage();
			
			mess.setStringProperty("recipientEmail",email);
			
			EShopMessage messageObject = new EShopMessage();
			messageObject.setMessage("Your order could not be placed because an item was out of stock. We apologize for the inconvenience.");
			messageObject.setTitle("We Have Failed You");
			messageObject.setSenderEmail(email);
			messageObject.setUserType(0);
			
			mess.setObject(messageObject);
			prod.send(mess);
			prod.close();
			ses.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}