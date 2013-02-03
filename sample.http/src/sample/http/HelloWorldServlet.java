package sample.http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.http.ds.UserHelper;

public class HelloWorldServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.getWriter().write("<html><body>" 
				+ UserHelper.getInstance().getService().sayHello(req.getParameter("username")) 
				+ "</body></html>"); //$NON-NLS-1$
		
//		resp.sendRedirect("/helloworld.html");
		
	}

}
