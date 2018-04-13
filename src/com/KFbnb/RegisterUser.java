package com.KFbnb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "registerUser",
        urlPatterns = {"/register"},
        loadOnStartup = 1
)
public class RegisterUser extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	 	private final String userName = "root";		
		private final String password = "Beu|ah1980*";		
		private final String serverName = "localhost";		
		private final int portNumber = 3306;		
		private final String dbName = "BNB";		
		
		
		public Connection getConnection() throws SQLException {
			Connection connect = null;
			Properties connectionProps = new Properties();
			connectionProps.put("user", this.userName);
			connectionProps.put("password", this.password);

			connect = DriverManager.getConnection("jdbc:mysql://"
					+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
					connectionProps);

			return connect;
		}
		
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)

		        throws ServletException, IOException {
		       // forward to registration form
		       request.getRequestDispatcher("WEB-INF/jsp/view/registerUser.jsp").forward(request,response);
		    }

@Override
public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
		ResultSet rs;
		long existingCount;
		
		//create new user object
		User user = new User();
		
		//create hashmap of errors to display
		Map<String, String> errors = new HashMap<String, String>();
		Map<String, String> message = new HashMap<String, String>();
	
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipCode = request.getParameter("zip");
		String phoneNum = request.getParameter("phone");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String pword1 = request.getParameter("pword1");
		String pword2 = request.getParameter("pword2");
		
		
		
		//check first and last names for invalid characters and numbers
        if(firstName == null || firstName == "" || lastName == null || lastName == "")
        {
        	errors.put("Name", "Please enter a valid name");
        }
        
        //check address, city, state, & zip
        if(address == null || address == "")
        {
        	errors.put("Address", "Please enter a valid address");
        }
        
        if(city == null || city =="")
        {
        	errors.put("City","Please enter a valid city");
        }
        
        if(state.length() < 2 || state == null || state =="")
        {
        	errors.put("State", "Please enter a valid State");
        }
        
        if(zipCode.length() < 6 || zipCode == null || zipCode =="")
        {
        	errors.put("zip", "Please enter a valid  6-digit zip code");
        }
        if( phoneNum == null || phoneNum == "")
        {
        	errors.put("Phone", "Please enter a phone number in the following format: 000-000-0000");
        }
        if(!email.contains("@") || email == null || email =="")
        {
        	errors.put("email", "Please enter a valid email address");
        }
        if(userName == null || userName=="")
        {
        	errors.put("Username", "Please enter an username.");
        }
        if(pword1 == null || pword1 =="" || pword1.length() < 6)
        {
        	errors.put("Password", "Please enter an password(must be at least 6 characters).");
        }
        if(pword2 == null || pword2 =="" || pword2 != pword1 || pword2.length() < 6)
        {
        	errors.put("Password2", "Passwords do not match.");
        }
      
        if(errors.size() != 0) {
			//add ${errors.___} in jsp <span class="error">${errors.fname}</span>
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/WEB-INF/jsp/view/registerUser.jsp")
        	.forward(request, response);
			}
     
      
        
        
        
        
        	//set user info
        	user.setFirstName(firstName);
        	user.setLastName(lastName);
        	user.setAddress(address);
        	user.setCity(city);
        	user.setState(state);
        	user.setZIP(zipCode);
        	user.setPhone(phoneNum);
        	user.setEmail(email);
        	user.setUsername(userName);
        	user.setPassword(pword1);
        
        	
        	try{
        		Class.forName("com.mysql.jdbc.Driver");
            	
            	Connection conn = null;
        		conn = this.getConnection();
        		System.out.println("Connected to database");
                
                String query="Insert into users(firstname, lastname, address, city, state, zip, phone, email, username, pword) values(?,?,?,?,?,?,?,?,?,?);";
               
                PreparedStatement preparedStatement = conn.prepareStatement(query); 
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, address);
                preparedStatement.setString(4, city);
                preparedStatement.setString(5, state);
                preparedStatement.setString(6, zipCode);
                preparedStatement.setString(7, phoneNum);
                preparedStatement.setString(8, email);
                preparedStatement.setString(9, userName);
                preparedStatement.setString(10, pword1);
                
                int i= preparedStatement.executeUpdate();
                conn.close();
                System.out.print(i);
                if(i>0)
                {
                	message.put("Success", "You have successfully registered. Please login.");
                	request.setAttribute("message", message);
                	response.sendRedirect("login");
                	return;
  	               
                }
                else{
                	request.setAttribute("message", message);
                	request.getRequestDispatcher("/WEB-INF/jsp/view/registerUser.jsp")
 	               .forward(request, response);
                	
                }
                
                
                
                
        } catch (ClassNotFoundException | SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}
        }
        
	
}
