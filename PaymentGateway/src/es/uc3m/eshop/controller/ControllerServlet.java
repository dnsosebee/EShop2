package es.uc3m.eshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.eshop.gateway.Gateway;
import es.uc3m.eshop.model.MessageSender;

/**
 * Servlet implementation class ControllerServlet
 */

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Gateway gateway;
	
	public void init(ServletConfig config) {
		gateway = new Gateway();
		System.out.println("STARTING GATEWAY");
		gateway.start();
	}
	
	public void destroy() {
		gateway.stop();
	}
	
	  public void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {  
			System.out.println("DO GET GATEWAY");
			MessageSender ms = new MessageSender();
			ms.sendSuccessMessage("tester1@gmail.com", 1);
		RequestDispatcher rd =request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	  }

	  
	  
	  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doGet(request,response);
	  }
	  
}