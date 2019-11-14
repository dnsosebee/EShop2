package es.uc3m.eshop.handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String message = request.getParameter("msg");
		
		
		Context context;
		try {
			context = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) context.lookup("confact");
			Queue queue = (Queue) context.lookup("xxx");
			
			
			// - In the following steps we write the message and send it				
			// First create a connection using the connectionFactory
		      Connection con = factory.createConnection();
		      // Next create the session. Indicate that transaction will not be supported
				Session ses = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			// Now use the session to create a message producer associated to the queue
				MessageProducer prod = ses.createProducer(queue);
			 // Now use the session to create a text message
				TextMessage mess = ses.createTextMessage();
			//  We retrieve the parameter 'message' from the request, and use it as text of our message
				mess.setBooleanProperty("beautiful", true);
				mess.setText(message);
			// Use the message producer to send the message	
				prod.send(mess);


			// Close the producer
			prod.close();
			// Close the session 
			ses.close();
			// Close the connection 
			con.close();
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		
		
		
		
		
		
		
		
		return "index.jsp";
	}

}
