package es.uc3m.eshop.handler;
import java.io.IOException;

import es.uc3m.eshop.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SendRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			return "login.html";
		}
		
		String subject = request.getParameter("title");
		String body = request.getParameter("message");
		String senderEmail = request.getParameter("senderEmail");
		String recipientEmail = request.getParameter("recipientEmail");
		
		Message message = new Message();
		message.setBody(body);
		message.setSubject(subject);
		message.setSender(senderEmail);
		message.setRecipient(recipientEmail);
		MessageManager messageManager = new MessageManager();
		messageManager.sendMessage(message);

		return "inbox.html";
	}

}
