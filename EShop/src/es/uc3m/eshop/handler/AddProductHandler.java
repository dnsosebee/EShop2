package es.uc3m.eshop.handler;

import java.io.IOException;

import es.uc3m.eshop.imagemanagement.DBImage;
import es.uc3m.eshop.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

public class AddProductHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ADDING NEW PRODUCT");

		
		HttpSession session = request.getSession();
		ApplicationUser au = (ApplicationUser) session.getAttribute("user");
		
		
		
		ProductManager pm = new ProductManager();

		/*
		 * System.out.println("ACTION VALUE");
		 * System.out.println(request.getParameter("action"));
		 * 
		 * System.out.println("############");
		 */
		
		if (request.getParameter("action") == null) {
			return "addProduct.jsp";
		}

		if (request.getParameter("action").equalsIgnoreCase("addProduct")) {

			System.out.println("READY TO ADD THE NEW PRODUCT");
			// Product details
			
			String seller = au.getEmail();
			String productName = request.getParameter("productName");
			String productDescription = request.getParameter("productDescription");
			float productPrice = Float.parseFloat(request.getParameter("productPrice"));
			int productStock = Integer.parseInt(request.getParameter("productStock"));

			  //Adding the image
			  DBImage productImage = new DBImage();
			  Part inImage = request.getPart("productImage");
			  byte[] imageData = new byte[(int) inImage.getSize()]; 
			  inImage.getInputStream().read(imageData, 0 ,imageData.length);
			  
			/*
			 * productImage.setImage(data); productImage.setTitle(productName);
			 */
			  
			  
			  
			  
			  
			  Product addProduct = new Product();
			  addProduct.setDescription(productDescription);
			  addProduct.setName(productName); addProduct.setSeller(seller);
			  addProduct.setPrice(productPrice); addProduct.setStock(productStock);
			  addProduct.setImage(imageData);
			  
			  
			  
			  pm.insert(addProduct);
			 

			return "products.html";

		}
		

		return "error.html";
	}

}
