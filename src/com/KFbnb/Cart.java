/*Krista Froiseth
 * COP4813
 * Shopping res class
 */
package com.KFbnb;


import java.util.ArrayList;
import com.KFbnb.Reservation; 
import com.KFbnb.ReservationServlet;
import java.io.Serializable;
	 
	public class Cart implements Serializable{
		
		//create arraylist of typer reservation to hold reservation information
		private static ArrayList<Reservation> cart = new ArrayList<Reservation>();
		
		/*res constructor
		public Cart()
		{ 
			cart = new ArrayList<Reservation> ();
		}*/
		//variable to hold order total
		private double OrderTotal;
	  
	 
	 //remove reservation from res 
	 public void deleteCart(Reservation reservation)
	 {		 
				
	   cart.remove(reservation);
	   calculateOrderTotal();
	  
	 }
	  
	 //add reservation to res
	 @SuppressWarnings("unchecked")
	public void addToCart(int reservationNum, String checkIN, String checkOUT, int numNights, double stayPrice, String roomName, String roomType)
	 {		 
		 Reservation res = new Reservation();
		 res.setReservationNum(reservationNum);
		 res.setCheckIN(checkIN);
		 res.setCheckOUT(checkOUT);
		 res.setNumNights(numNights);
		 res.setStayPrice(stayPrice);
		 res.setRoomName(roomName);
		 res.setRoomType(roomType);
		
		 cart.add(res);
		 
		 calculateOrderTotal();
	 }
	     
	  
	
	 //return a list of res items 
	 public static ArrayList<Reservation> getCartItems() {
		 return cart;
	  
	 }
	 
	 
	 public double getOrderTotal() {
		 calculateOrderTotal();
	  return OrderTotal;
	 }
	 
	 
	 public void setOrderTotal(double OrderTotal) {
	  this.OrderTotal = OrderTotal;
	 }
	  
	 protected void calculateOrderTotal() {
	 
		  double resTotal = 0;
		  for(int i=0;i<cart.size();i++) {
		   Reservation resItem = (Reservation) cart.get(i);
		   resTotal+=resItem.getStayPrice();
	    
	  }
	  setOrderTotal(resTotal);
	 }
	 
}



