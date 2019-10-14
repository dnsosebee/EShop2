package UserServlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexRequestHandler implements ControlServlets.RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	  	request.getRequestDispatcher("index.jsp").forward(request, response);
		return null;
	}

}
