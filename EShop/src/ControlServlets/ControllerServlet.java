package ControlServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	    handlerHash.put("/index.html", new UserServlets.IndexRequestHandler());
	    handlerHash.put("/", new UserServlets.IndexRequestHandler());

	  }

	  
	  public void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
		  String sPath = (String)request.getServletPath();
		  
		  // Complete. Retrieve from the HashMap the instance of the class which implements the logic of the requested url
		  Object aux = handlerHash.get(sPath);
		  
		  if (aux == null) {
			  request.getRequestDispatcher("error.html").forward(request, response);
		  } else {
			  RequestHandler rh = (RequestHandler) aux;
			  rh.handleRequest(request, response);
		  }

	  }
}