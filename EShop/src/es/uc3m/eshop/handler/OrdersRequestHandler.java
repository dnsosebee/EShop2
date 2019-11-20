package es.uc3m.eshop.handler;
import java.io.IOException;
import java.util.List;

import es.uc3m.eshop.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrdersRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ApplicationUser auxiliar, au;
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			return "login.html";
		}
		auxiliar = (ApplicationUser) session.getAttribute("user");
		ApplicationUserManager aum=new ApplicationUserManager();
		au = aum.findByEmail(auxiliar.getEmail());
	
		List<MyOrder> list = au.getMyOrders();
		request.setAttribute("orders", list);
		
		for (MyOrder mo : list) {
			System.out.println(mo.getIdOrder());
		}
		return "orders.jsp";
	}

}
