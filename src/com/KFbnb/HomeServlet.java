package com.KFbnb;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

	
	  @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)

	        throws ServletException, IOException {
	       // forward to mypage.html
	       request.getRequestDispatcher("WEB-INF/jsp/view/home.jsp").forward(request,response);
	    }
	 
}
