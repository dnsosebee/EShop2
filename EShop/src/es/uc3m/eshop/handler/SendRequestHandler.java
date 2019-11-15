package es.uc3m.eshop.handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.uc3m.eshop.model.*;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.ObjectMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String message = request.getParameter("message");
		String senderEmail = request.getParameter("senderEmail");
		int userType = Integer.parseInt(request.getParameter("userType"));
		
		Context context;
		try {
			context = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) context.lookup("confact");
			Queue queue = (Queue) context.lookup("xxx");
		    Connection con = factory.createConnection();
		    Session ses = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer prod = ses.createProducer(queue);
			ObjectMessage mess = ses.createObjectMessage();
			if (request.getParameter("allUsers") != null) {
				mess.setBooleanProperty("allUsers",true);
			}
			if (request.getParameter("allSellers") != null) {
				mess.setBooleanProperty("allSellers",true);
			}
			if (request.getParameter("recipientEmail") != null) {
				//mess.setBooleanProperty(request.getParameter("recipientEmail"),true);
				mess.setStringProperty("recipientEmail", request.getParameter("recipientEmail"));
			}
			
			
			EShopMessage messageObject = new EShopMessage();
			messageObject.setMessage(message);
			messageObject.setTitle(title);
			messageObject.setSenderEmail(senderEmail);
			messageObject.setUserType(userType);
			
			mess.setObject(messageObject);
			prod.send(mess);
			prod.close();
			ses.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index.html";
	}

}
