//Krista Froiseth
//COP4813.0M1
//BNB project - reservation class with getters and setters

package com.KFbnb;

import java.io.Serializable;



public class Reservation implements Serializable{

	private int reservationNum;
	private String checkIN;
	private String checkOUT;
	private int numNights;
	private double stayPrice;
	private String roomName;
	private String roomType;
	//private String firstName;
	//private String lastName;
	//private String address;
	//private String city;
	//private String state;
	//private int zip;
	//private String phone;
	//private String email;
	
	
	
	Reservation()
	{}
	
	public Reservation(String checkIN, String checkOUT, int numNights, double stayPrice, String roomName, String roomType){
		this.checkIN = checkIN;
		this.checkOUT = checkOUT;
		this.numNights = numNights;
		this.stayPrice = stayPrice;
		this.roomName = roomName;
		this.roomType = roomType;
	}
	
			
	public int getReservationNum()
	{
		return reservationNum;
	}
	
	public void setReservationNum(int reservationNum)
	{
		this.reservationNum = reservationNum;
	}

	
	
	/*Dates*/
	public String getCheckIN()
	{
		return checkIN;
	}
	
	public void setCheckIN(String checkIN)
	{
		this.checkIN = checkIN;
	}
	
	public String getCheckOUT()
	{
		return checkOUT;
	}
	
	public void setCheckOUT(String checkOUT)
	{
		this.checkOUT = checkOUT;
	}
	
	/*Stay length and price*/	
	public int getNumNights()
	{
		return numNights;
	}
	
	public void setNumNights(int numNights)
	{
		this.numNights = numNights;
	}
	
	public double getStayPrice()
	{
		return stayPrice;
	}
	
	public void setStayPrice(double stayPrice)
	{
		this.stayPrice = stayPrice;
	}
	
	
	/*Room type & number of occupants*/
	
		
	public String getRoomName()
	{
		return roomName;
	}
	
	public void setRoomName(String roomName)
	{
		this.roomName = roomName;
	}
	
	
	public String getRoomType()
	{
		return roomType;
	}
	
	public void setRoomType(String roomType)
	{
		this.roomType = roomType;
	}

	/*public String toString() {
        return "Reservation Information:\nCheck-IN: " + checkIN + "\nCheck-out:" + checkOUT + "\nNumber of night: " + numNights + "\nTotal: " + stayPrice +".";
    }*/
	
	
	
	/*Billing information*/
	
	/*public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public int getZIP()
	{
		
		return zip;
	}
	
	public void setZIP(int zip)
	{
		this.zip = zip;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	*/
	
}


