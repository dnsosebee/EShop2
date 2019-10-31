package es.uc3m.eshop.controlservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.eshop.handler.*;

import java.util.Map;
import java.util.HashMap;

/**
 * Servlet implementation class ControllerServlet
 */

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Hash table of RequestHandler instances, keyed by request URL
	  private Map<String,RequestHandler> handlerHash = new HashMap<String,RequestHandler>();

	  // Initialize mappings: not implemented here
	  public void init() throws ServletException {

	    // This will read mapping definitions and populate handlerHash
		  handlerHash.put("/product-page.html", new ProductPageRequestHandler());
		  handlerHash.put("/products.html", new ProductsRequestHandler());
		  handlerHash.put("/index.html", new IndexRequestHandler());
		  handlerHash.put("/signup.html", new SignUpRequestHandler());
		  handlerHash.put("/login.html", new LoginRequestHandler());
		  handlerHash.put("/logout.html", new LogoutRequestHandler());
		  handlerHash.put("/checkout.html", new CheckoutRequestHandler());
	  }

	  
	  public void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
		  String sPath = request.getServletPath();
		  
		  // Complete. Retrieve from the HashMap the instance of the class which implements the logic of the requested url
		  RequestHandler rh = handlerHash.get(sPath);
		  
		  if (rh == null) {
			  //request.getRequestDispatcher("error.html").forward(request, response);
			  response.sendError(404);
		  } else {
			  
			  String view = rh.handleRequest(request, response);
			  if(view != null) {
				  RequestDispatcher rd =request.getRequestDispatcher(view);
				  rd.forward(request, response);
				  	
			  }
			  
		  }

	  }
	  
	  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doGet(request,response);
	  }
	  
}