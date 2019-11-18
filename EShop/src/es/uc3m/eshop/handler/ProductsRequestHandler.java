package es.uc3m.eshop.handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.uc3m.eshop.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductsRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductManager pm = new ProductManager();
		
		List<Product> list;
		
		if (request.getParameter("term") == null) {
			list = pm.findAll();
		} else {
			list = pm.search(request.getParameter("term"));
			request.setAttribute("term", request.getParameter("term"));
		}
		request.setAttribute("products", list);
		
		return "products.jsp";
	}

}
