package es.uc3m.eshop.handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.uc3m.eshop.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductManager pm = new ProductManager();
		
		List<Product> list = pm.findAll();
		
		request.setAttribute("products", list);
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			return "index.jsp";
		}
		if (((ApplicationUser)session.getAttribute("user")).getRole() == 0) {
			return "index.jsp";
		}
		if (((ApplicationUser)session.getAttribute("user")).getRole() == 1) {
			return "sellerPanel.jsp";
		}
		return "adminPanel.jsp";
	}

}
