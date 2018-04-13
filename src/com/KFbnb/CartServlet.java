package com.KFbnb;

import com.KFbnb.Cart;
import com.KFbnb.Reservation;
import com.KFbnb.ReservationServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(
        name = "cartServlet",
        urlPatterns = {"/cart"},
        loadOnStartup = 1
)
public class CartServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private final String userName = "root";		
	private final String password = "Beu|ah1980*";		
	private final String serverName = "localhost";		
	private final int portNumber = 3306;		
	private final String dbName = "BNB";		
	private final String tableName = "reservations";
	
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
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		
		HttpSession session = request.getSession();
				
		String action = request.getParameter("action");
    	 if(action == null)
    	     action = "list";    	        
    	 switch(action)
    	 {
    	  case "add":
    		  this.addToCart(request, response);
    		  break;
		  case "delete":
			  this.deleteCart(request, response);
			  break;
    	  case "checkout":
             this.showCheckoutForm(request, response);
             break;
    	  case "list":
    	  default:
    		  this.viewCart(request, response);
    		  break;
    	 }
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		
		HttpSession session = request.getSession();
				
		String action = request.getParameter("action");
    	 if(action == null)
    	     action = "list";    	        
    	 switch(action)
    	 {
    	  case "add":
    		  this.addToCart(request, response);
    		  break;
		  case "delete":
			  this.deleteCart(request, response);
			  break;
    	  case "checkout":
             this.showCheckoutForm(request, response);
             break;
    	  case "list":
    	  default:
    		  this.viewCart(request, response);
    		  break;
              
    	 }
	}
	
	public void addToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
		
		System.out.print("add to cart function called");
		 HttpSession session = request.getSession(true);
		
		 String idString = request.getParameter("reservationNum");		 
		 
		 Reservation reservation = ReservationServlet.getReservation(idString, response);
		 int reservationNum = reservation.getReservationNum();
		 String checkIN = reservation.getCheckIN();		 
		 String checkOUT = reservation.getCheckOUT();
		 int numNights = reservation.getNumNights();
		 double stayPrice = reservation.getStayPrice();
		 String roomName = reservation.getRoomName();
		 String roomType = reservation.getRoomType();
		 
		 System.out.print(checkIN + checkOUT + numNights + stayPrice + roomName + roomType);
		  
		 if(session != null){		 		 
		 Cart shoppingCart;
		 synchronized(session){
			 shoppingCart = (Cart) session.getAttribute("cart");
		 }
		 
		 if(shoppingCart != null){
			 System.out.print("shopping cart exists");
		 }	 
		 if(shoppingCart == null){
			 shoppingCart = new Cart();
			 session.setAttribute("cart", shoppingCart);
			 System.out.print("cart created");
		 
		 }
		 shoppingCart = (Cart)session.getAttribute("cart");
		 shoppingCart.addToCart(reservationNum, checkIN, checkOUT, numNights, stayPrice, roomName, roomType);
		 System.out.print("reservation added");
		 
		 request.setAttribute("cart", shoppingCart);
		 
		 
		 request.getRequestDispatcher("/WEB-INF/jsp/view/viewCart.jsp").forward(request, response);
		 }
	}
	
	public void deleteCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
	
		HttpSession session = request.getSession(true);
		
		String num = request.getParameter("reservationNum");
		Cart cart;
		Reservation reservation = ReservationServlet.getReservation(num, response);
				 
		cart = (Cart)session.getAttribute("cart");
		cart.deleteCart(reservation);
		request.setAttribute("cart", Cart.getCartItems());
		request.getRequestDispatcher("/WEB-INF/jsp/view/viewCart.jsp");
		
		
		
    }
	
	public void viewCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
		HttpSession session = request.getSession(true);
		Cart shoppingCart = (Cart) session.getAttribute("cart");
		 if(shoppingCart == null){
			 shoppingCart = new Cart();
			 session.setAttribute("cart", shoppingCart);
			 System.out.print("cart created");
		 }
		 if(shoppingCart != null){
			 System.out.print("shopping cart exists");
		 }
		shoppingCart = (Cart)session.getAttribute("cart");
		request.setAttribute("cart", shoppingCart);
		request.getRequestDispatcher("/WEB-INF/jsp/view/viewCart.jsp")
		.forward(request, response);
		
    }
	
	private void showCheckoutForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
		try {
        	Class.forName("com.mysql.jdbc.Driver");
        	
        	Connection conn = null;
    		conn = this.getConnection();
    		System.out.println("Connected to database");
			Statement st = conn.createStatement();
			String query = "insert into reservations (reservationNum, checkIN, checkOUT, numNight, stayPrice, roomName, roomType, userEmail) value (?,?,?,?,?,?,?,?);";
	
		
    }catch(Exception ex)
        {
        // unable to close the prepared statement  
      }
    }		
}
