package com.KFbnb;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/roomList"})
public class RoomListServlet extends HttpServlet {

	
	  @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)

	        throws ServletException, IOException {
	       // forward to brunch page
	       request.getRequestDispatcher("WEB-INF/jsp/view/roomList.jsp").forward(request,response);
	    }
	  
	 	 
}
