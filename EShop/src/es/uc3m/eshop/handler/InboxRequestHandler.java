package es.uc3m.eshop.handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uc3m.eshop.model.ApplicationUser;
import es.uc3m.eshop.model.EShopMessage;

public class InboxRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ApplicationUser au;
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			return "login.html";
		}
		au = (ApplicationUser) session.getAttribute("user");
		String query ="";
		if (au.getRole() == 0) {
			query = "(allUsers IS NOT NULL AND allUsers = TRUE) OR (recipientEmail = '"+ au.getEmail()+"')";
		} else if (au.getRole() == 1) {
			query = "(allSellers IS NOT NULL AND allSellers = TRUE) OR (recipientEmail = '"+ au.getEmail() +"')";
		}
		
		Context context;
		try {
			context = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) context.lookup("confact");
			Queue queue = (Queue) context.lookup("xxx");
			Connection con = factory.createConnection();
			Session ses = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueBrowser b = ses.createBrowser(queue, query);//selector.toString());
			con.start();
			@SuppressWarnings("unchecked")
			List<ObjectMessage> list = Collections.list(b.getEnumeration());
			List<EShopMessage> messageList = new ArrayList<EShopMessage>();
			for (ObjectMessage om : list) {
				messageList.add((EShopMessage)om.getObject());
			}
			b.close();
			ses.close();
			con.close();
			request.setAttribute("messages", messageList);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return "inbox.jsp";	
	}
}
