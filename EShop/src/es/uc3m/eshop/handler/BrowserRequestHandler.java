package es.uc3m.eshop.handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BrowserRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		
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
				//Start connection

	 			   
				// USe the session to create a browser associated to the queue
				QueueBrowser b = ses.createBrowser(queue);
				
				//Start the connection

				con.start();
				// User the browser to retrieve a collection (enumeration) of messages
				List<TextMessage> list = Collections.list(b.getEnumeration());
				
				
		

			// Close the producer
			b.close();
			// Close the session 
			ses.close();
			// Close the connection 
			con.close();
			
			request.setAttribute("messages", list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			return "messages.jsp";
		
	}

}
