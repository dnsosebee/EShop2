package es.uc3m.eshop.handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.uc3m.eshop.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1,"Television","great television",300.0f,"image1.png"));
		list.add(new Product(1,"Smart Phone","buy it",800.0f,"image1.png"));
		list.add(new Product(1,"Keyboard","also a television",30.0f,"image1.png"));
		list.add(new Product(1,"Computer","yeah, buy this computer",600.0f,"image1.png"));
		list.add(new Product(1,"Pen","The greatest pen",3.0f,"image1.png"));
		
		request.setAttribute("products", list);
		
		
		return "index.jsp";
	}

}
