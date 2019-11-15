package es.uc3m.eshop.handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uc3m.eshop.model.ApplicationUser;

public class ConsumeRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

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
				con.start();
				// USe the session to create a consumer
				
				HttpSession session = request.getSession();
				
				ApplicationUser au;
				
				if (session.getAttribute("user") == null) {
					return "login.html";
				}
				au = (ApplicationUser) session.getAttribute("user");
				
				StringBuilder selector = new StringBuilder();
				
				if (au.getRole() == 0) {
					selector.append("allUsers = TRUE OR ");
				} else if (au.getRole() == 1) {
					selector.append("allSellers = TRUE OR ");
				}
				selector.append(au.getEmail());
				selector.append(" = TRUE");
				
				MessageConsumer cons = ses.createConsumer(queue,selector.toString());
				
				List<ObjectMessage> list = new ArrayList<ObjectMessage>();
				Message message =  cons.receive(1000);
				while (message != null) {
					list.add((ObjectMessage)message);
					// Use the message consumer to try to retrieve a message. Timing 1000
					message = cons.receive(1000);
				}


			// Close the producer
			cons.close();
			// Close the session 
			ses.close();
			// Close the connection 
			con.close();
			
			request.setAttribute("messages", list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return "message.jsp";
		
	}

}
