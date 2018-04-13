//Krista Froiseth
//COP4813.0M1
//Project 1 - Reservation System login servlet. 


package com.KFbnb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


@WebServlet(
        name = "loginServlet",
        urlPatterns = "/login"
)
public class LoginServlet extends HttpServlet
{
    /*private static final Map<String, String> userDatabase = new Hashtable<>();

    static {
        userDatabase.put("Krista", "password");
        userDatabase.put("WonderWoman", "lasso");
        userDatabase.put("Batman", "bats");
        userDatabase.put("Fionna", "cake");
        userDatabase.put("MAJK", "majk");
        userDatabase.put("support", "admin123");
    }	*/
	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "Beu|ah1980*";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "BNB";
	
	/** The name of the table we are testing with */
	private final String tableName = "users";
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);

		return conn;
	}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        if(request.getParameter("logout") != null)
        {
            session.invalidate();
            response.sendRedirect("login");
            return;
        }
        else if(session.getAttribute("username") != null)
        {
        	session.getAttribute("cart");
            response.sendRedirect("cart");
            return;
        }

        request.setAttribute("loginFailed", false);
        request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    	
    	
        HttpSession session = request.getSession();
        if(session.getAttribute("username") != null)
        {
            response.sendRedirect("cart");
            return;
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password"); 
       
        
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	
        	Connection conn = null;
    		conn = this.getConnection();
    		System.out.println("Connected to database");
    		   		
    		
    		
            PreparedStatement pst = conn.prepareStatement("Select * from users where username=? and pword=?");
            
            pst.setString(1, username);
            pst.setString(2, password);          
             
            System.out.print(username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                
                //System.out.println(role);
            	session.setAttribute("username", username);
            	request.changeSessionId();
                response.sendRedirect("cart");
                
            } 
            else {
            	 request.setAttribute("loginFailed", true);
            	 request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp")
                        .forward(request, response);
            }
        }  catch (ClassNotFoundException | SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}
        
        
    }
   
}
