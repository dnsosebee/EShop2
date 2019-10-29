package es.uc3m.eshop.handler;
import java.io.IOException;

import es.uc3m.eshop.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginRequestHandler implements es.uc3m.eshop.controlservlet.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("email")!=null) {
			
			
			ApplicationUserManager aum = new ApplicationUserManager();
			ApplicationUser au = aum.login(request.getParameter("email"),request.getParameter("password"));
			if (au == null) {
				request.setAttribute("hasFailed", "yup");
				return "login.jsp";
			}
			HttpSession session = request.getSession();
			session.setAttribute("user", au);
			return "index.html";
		}
		else {
			return "login.jsp";
		}
	}

}
