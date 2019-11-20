package es.uc3m.eshop.controlservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.eshop.gateway.Gateway;
import es.uc3m.eshop.handler.*;

import java.util.Map;
import java.util.HashMap;

/**
 * Servlet implementation class ControllerServlet
 */
@MultipartConfig
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Hash table of RequestHandler instances, keyed by request URL
	  private Map<String,RequestHandler> handlerHash = new HashMap<String,RequestHandler>();
	  private Gateway gateway;
	  
	  // Initialize mappings: not implemented here
	  public void init() throws ServletException {
		 

	    // This will read mapping definitions and populate handlerHash
		  handlerHash.put("/product-page.html", new ProductPageRequestHandler());
		  handlerHash.put("/products.html", new ProductsRequestHandler());
		  handlerHash.put("/index.html", new IndexRequestHandler());
		  handlerHash.put("/signup.html", new SignUpRequestHandler());
		  handlerHash.put("/login.html", new LoginRequestHandler());
		  handlerHash.put("/logout.html", new LogoutRequestHandler());
		  handlerHash.put("/userProfile.html", new UserProfileRequestHandler());
		  handlerHash.put("/deleteUser.html", new DeleteUserRequestHandler());
		  handlerHash.put("/checkout.html", new CheckoutRequestHandler());
		  handlerHash.put("/send.html", new SendRequestHandler());
		  handlerHash.put("/editUser.html", new EditUserRequestHandler());
		  handlerHash.put("/adminPanel.html", new AdminEditProductHandler());
//		  handlerHash.put("/consumer.html", new ConsumeRequestHandler());
//		  handlerHash.put("/browser.html", new BrowserRequestHandler());
		  handlerHash.put("/message.html", new MessageRequestHandler());
		  handlerHash.put("/inbox.html", new InboxRequestHandler());
		  handlerHash.put("/wishlist.html", new WishlistRequestHandler());
		  handlerHash.put("/removeFromWishlist.html", new RemoveFromWishlistRequestHandler());
		  handlerHash.put("/addToWishlist.html", new AddToWishlistRequestHandler());
		  handlerHash.put("/addProduct.html", new AddProductHandler());
		  handlerHash.put("/editSellerProducts.html", new EditProductsHandler());
		  handlerHash.put("/editProduct.html", new EditProductsHandler());
		  handlerHash.put("/showCart.html", new ShowCartHandler());
		  handlerHash.put("/addItemToCart.html", new CartHandler());
		  handlerHash.put("/adminEditUsers.html", new AdminEditUserHandler());
		  handlerHash.put("/adminEditProducts.html", new AdminEditProductHandler());
		  handlerHash.put("/orders.html", new OrdersRequestHandler());
		  handlerHash.put("/order.html", new OrderRequestHandler());
		  handlerHash.put("/orderThanks.html", new PurchaseHandler());
		  


		  
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