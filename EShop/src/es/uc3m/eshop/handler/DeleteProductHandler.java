package es.uc3m.eshop.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import es.uc3m.eshop.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteProductHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ProductManager pm = new ProductManager();
		
		//Grabs the user from the session and redirects to the userProfile page

		if (request.getParameter("deleteProduct") != null)
		{
			System.out.println("DELETING PRODUCT");
			Product productToDelete = pm.findById(request.getParameter("deleteProduct"));
			
			pm.delete(productToDelete);
			
			return "deletesuccess.jsp";
			
		}
		
		
		return "error.jsp";
	}

}
