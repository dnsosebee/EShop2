package es.uc3m.eshop.handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.uc3m.eshop.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		OrderManager om = new OrderManager();
		if (request.getParameter("id") == null) {
			return "error.jsp";
		}
		MyOrder mo = om.findById(Integer.parseInt(request.getParameter(("id"))));
		if (mo == null) {
			return "error.jsp";
		}
		
		ProductManager pm = new ProductManager();

		HttpSession session = request.getSession();
		request.setAttribute("order", mo);
		request.setAttribute("order", mo);
		request.setAttribute("order", mo);
		return "order.jsp";
	}
}
