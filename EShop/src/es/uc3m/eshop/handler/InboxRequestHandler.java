package es.uc3m.eshop.handler;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uc3m.eshop.model.ApplicationUser;
import es.uc3m.eshop.model.Message;
import es.uc3m.eshop.model.MessageManager;

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
		boolean shopper = false;
		if (au.getRole() == 0) {
			shopper = true;
		}
		
		MessageManager messageManager = new MessageManager();
		
		List<Message> messageList = messageManager.getMessages(au.getEmail(), shopper);
		
		request.setAttribute("messages", messageList);
		
		return "inbox.jsp";	
	}
}
