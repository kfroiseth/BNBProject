//Krista Froiseth
//COP4813.0M1
//Project 1 - Reservation System Servlet

package com.KFbnb;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.Connection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.sql.PreparedStatement;


@WebServlet(
        name = "reservationServlet",
        urlPatterns = {"/reservations"},
        loadOnStartup = 1
)

public class ReservationServlet extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
	
	private volatile int RESERVATION_NUM_SEQUENCE = 1;
       
    static Map<Integer, Reservation> reservationDatabase = new LinkedHashMap<>();
   
    
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
	private final String tableName = "rooms";
	
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
    	    throws ServletException, IOException
    {
    	HttpSession session = request.getSession();
    	    	 
    	 String action = request.getParameter("action");
    	 if(action == null)
    	     action = "shop";    	        
    	 switch(action)
    	 {
    	  case "create":
    		  this.showReservationForm(request, response);
    		  break;
    	  case "view":
              this.viewReservation(request, response);
              break; 
    	  case "remove":
    		  this.remove(request, response);
    		  break;
    	  case "shop":
    	  default:
    		  this.shop(request, response);
    		  break;
              
    	 }
	}


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    	 HttpSession session = request.getSession();
    	
        String action = request.getParameter("action");
        if(action == null)
            action = "shop";
        switch(action)
        {
            case "create":
                this.createReservation(request, response);
                break;
            case "shop":
            default:
               this.shop(request, response);
                break;
        }
    }
	
	
	/************direct to page with room details and reservation form************/
	private void showReservationForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
		String name = request.getParameter("roomName");
		System.out.print(name);
		try {
        	Class.forName("com.mysql.jdbc.Driver");
        	
        	Connection conn = null;
    		conn = this.getConnection();
    		System.out.println("Connected to database");
			Statement st = conn.createStatement();
			String query = "Select * from rooms where roomName = '" + name +"';";
			ResultSet rs = st.executeQuery(query);
 
			Room room = new Room();
			while(rs.next()){
				
				room.setRoomID(rs.getInt(1));
				room.setRoomName(rs.getString(2));
				room.setRoomType(rs.getString(3));
				room.setRoomDescription(rs.getString(4));
				room.setRoomPrice(rs.getDouble(5));
				System.out.println(room);
			}
			request.setAttribute("room", room);
			conn.close();

		
		request.getRequestDispatcher("/WEB-INF/jsp/view/reservationForm.jsp")
        	.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}
	
    }
		
	/************Create a reservation with input from user************/
	private void createReservation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
			
		
		 Reservation reservation = new Reservation();
	            
	        	        
	        //create hashmap of errors to display
	        Map<String, String> errors = new HashMap<String, String>();
	        
	        //create date object with today's date to validate check in and check out dates
	        Date date = new Date();
	        Date date1;
	        Date date2;
	        long diff = 0;
	        String today = new SimpleDateFormat("MM/dd/yyyy").format(date);
	        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	        int numNights;
				       
	        //create variables for input to validate before sending to Reservation class	        	        
	        String checkIN = request.getParameter("check_in");
	        String checkOUT = request.getParameter("check_out");
			String roomName = request.getParameter("roomName");
	        String roomType = request.getParameter("roomType");
			String roomPrice = request.getParameter("roomPrice");
	       // String firstName = request.getParameter("firstName");
	        //String lastName = request.getParameter("lastName");
	        //String address = request.getParameter("address");
	       // String city = request.getParameter("city");
	       // String state = request.getParameter("state");
	       // String zipCode = request.getParameter("zip");
	       // String phoneNum = request.getParameter("phone");
	       // String email = request.getParameter("email");
	        
	        /*check for errors*/
			
	        //check	that dates are not null and match pattern of MM/DD/YYYY        	        
	        if (checkIN == null || !checkIN.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") || checkOUT == null || !checkOUT.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))
	        {
	        	errors.put("Date", "Dates must be the format of MM/dd/yyyy");
	        }
	        else
	        {
	        	//if they match pattern, make sure check in date is not after check out date
	        	try{
		        	date1 = format.parse(checkIN);
		        	date2 = format.parse(checkOUT);
		        	if(date1.after(date2)) 
	        	      		errors.put("Date1", "Check in date must be before check out date.");
	        	}catch (ParseException e) {
				    e.printStackTrace();
			}
	        	
	        	//make sure check in day is not before current date
	        	try{
		        	date1 = format.parse(checkIN);
		        	date2 = format.parse(today);
		        	if(date1.before(date2)) 
	        	      		errors.put("Date2", "Check-in date cannot be before the current date, " + date2);
	        	}catch (ParseException e) {
				    e.printStackTrace();
			}
	        	
	        }
			
	        
			//get number of nights from check-in and check-out dates
	        try{
	        	date1 = format.parse(checkIN);
	        	System.out.print(date1);
	        	date2 = format.parse(checkOUT);
	        	System.out.print(date2);
	        	diff = date2.getTime() - date1.getTime();
	        	System.out.print(diff);
	        	
	        }catch (ParseException e) {
				    e.printStackTrace();
			}
	        
	        
        	numNights = (int) (diff/(24 * 60 * 60 *1000));		
        	if(numNights >=30){
        		errors.put("Length", "A single stay may not exceed 30 days.");
        	}
			
         	//get price of stay from number of nights and room price
			double stayPrice = numNights * Double.valueOf(roomPrice);
			System.out.print(stayPrice);
			      
	        
	        /*check first and last names for invalid characters and numbers
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
	        
	       	//check that zip code is 5 digits        
	        if(zipCode.length() != 5 || zipCode==null)
	        {
	        	errors.put("Zip", "Please enter a 5 digit zip code");
	        }
	        else
	        {
	        	//ensure zip code is comprised of digits, not letters/characters
	        	char a[] = zipCode.toCharArray();
	 	        for(int i = 0; i < zipCode.length(); i++)
	 	        {
	 	        	if(!Character.isDigit(a[i]))
	 	        	{
	 	        		errors.put("Zip", "Please enter a valid 5 digit zip code");
	 	        		break;
	 	        	}
	 	        }
	        }
	        
	        //validate phone number     
	        
	        if(!phoneNum.matches("([0-9]{3})-([0-9]{3})-([0-9]{4})") || phoneNum == null || phoneNum == "")
	        {
	        	errors.put("Phone", "Please enter a phone number in the following format: 000-000-0000");
	        }
	        
	        //validate email address*/
	       
	        
	        //If there are any errors from validation, print them for the user.
	        if(errors.size() != 0) {
				//add ${errors.___} in jsp <span class="error">${errors.fname}</span>
				request.setAttribute("errors", errors);
				String name = roomName;
				System.out.print(name);
				try {
		        	Class.forName("com.mysql.jdbc.Driver");
		        	
		        	Connection conn = null;
		    		conn = this.getConnection();
		    		System.out.println("Connected to database");
					Statement st = conn.createStatement();
					String query = "Select * from rooms where roomName = '" + name +"';";
					ResultSet rs = st.executeQuery(query);
		 
					Room room = new Room();
					while(rs.next()){
						
						room.setRoomID(rs.getInt(1));
						room.setRoomName(rs.getString(2));
						room.setRoomType(rs.getString(3));
						room.setRoomDescription(rs.getString(4));
						room.setRoomPrice(rs.getDouble(5));
						System.out.println(room);
					}
					request.setAttribute("room", room);
					conn.close();

				
				request.getRequestDispatcher("/WEB-INF/jsp/view/reservationForm.jsp")
		        	.forward(request, response);
				} catch (ClassNotFoundException | SQLException e) {
					System.out.println("ERROR: Could not connect to the database");
					e.printStackTrace();
					return;
				}
			
			
	        	
	        }
	        else
	        {
		
		
	        	reservation.setCheckIN(checkIN);
	        	reservation.setCheckOUT(checkOUT);
				reservation.setNumNights(numNights);
				reservation.setStayPrice(stayPrice);
	        	reservation.setRoomName(roomName);
				reservation.setRoomType(roomType);
	        	//reservation.setFirstName(firstName);
	        	//reservation.setLastName(lastName);
	        	//reservation.setAddress(address);
	        	//reservation.setCity(city);
	        	//reservation.setState(state);
	        	//reservation.setZIP(Integer.parseInt(zipCode));
	        	//reservation.setPhone(phoneNum);
	        	//reservation.setEmail(email);
		
				int id;
				synchronized(this)
				{
					id = this.RESERVATION_NUM_SEQUENCE++;
					reservationDatabase.put(id, reservation);
				}
				reservation.setReservationNum(id);
				

		
		response.sendRedirect("reservations?action=view&reservationNum=" + id);
	        }
	}
	
	
	/************this page will effectively be the shopping cart - list reservations with option to check out or delete************/
	private void viewReservation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		
			String idString = request.getParameter("reservationNum");
	        Reservation reservation = getReservation(idString, response);
	        if(reservation == null)
	            return;

	        request.setAttribute("reservationNum", idString);
	        request.setAttribute("reservation", reservation);

	        request.getRequestDispatcher("WEB-INF/jsp/view/viewReservation.jsp")
	               .forward(request, response);
		}

	
    private void shop(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
{
    	
		
		response.sendRedirect("roomList");
			
}
	
	
	
	/************delete reservation in the reservation list by reservation number************/
    static /*private void deleteReservation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
{
    	String idString = request.getParameter("reservationNum");
		Reservation reservation = this.getReservation(idString, response);
		this.reservationDatabase.remove(idString, reservation);
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/view/listReservations.jsp")
			.forward(request, response);
}*/
	
	Reservation getReservation(String idString, HttpServletResponse response)
            throws ServletException, IOException
    {
		
		if(idString == null || idString.length() == 0)
        {
            response.sendRedirect("reservations");
            return null;
        }
		
		try
		{
			Reservation reservation = reservationDatabase.get(Integer.parseInt(idString));
			if(reservation == null)
			{
				response.sendRedirect("reservations");
				return null;				
			}
			return reservation;
		}
		catch(Exception e)
		{
			response.sendRedirect("reservations");
			return null;
		}

    }
	
	/*************************check out****************************/
	private void remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
				String idString = request.getParameter("reservationNum");
				Reservation reservation = this.getReservation(idString, response);
				reservationDatabase.remove(idString, reservation);
		
		
				response.sendRedirect("roomList");
			}
			
			
	/************************check-out form with credit card info*********************/
	/*private void finalizeReservation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
					
			 //create hashmap of errors to display
	        Map<String, String> CCerrors = new HashMap<String, String>();
			
			 //create variables for input to validate before sending to database         	        
	        String ccType = request.getParameter("ccType");
			String ccNumber = request.getParameter("ccNumber");
			String ccMonth = request.getParameter("ccMonth");
			String ccYear = request.getParameter("ccYear");
			
			if(ccType == null || ccType =="")
	        {
	        	CCerrors.put("Credit Card", "Please select a credit card type");
	        }
			
			
			
			if(CCerrors.isEmpty()){
				CCerrors.put("Success", "Purchase successfully completed!");
			}
			request.getRequestDispatcher("/WEB-INF/jsp/view/thankyou.jsp");
			
	}*/
}



