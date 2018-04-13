<%
//Krista Froiseth
//COP4813.0M1
//Project 1 - Reservation System - View submitted reservation input %>

<%@ include file="/WEB-INF/jsp/view/template/header.jsp" %>
<%@ page import="com.KFbnb.Reservation"%>


<%
	String reservationNum = (String)request.getAttribute("reservationNum");
    Reservation reservation = (Reservation)request.getAttribute("reservation");
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Sleeping Inn B &amp; B - Reservation System</title>
        
	</head>
	<br />
	<br />
	<header>
    	 	<img src="<%=request.getContextPath()%>/images/logo.png" />
    	 	
    </header>
    <body>
    <div class="marketing container">
        <p>Thank you for choosing Sleeping Inn Bed &amp; Brunch. Below is your reservation information.
        Please confirm to add to cart or cancel to return to the room list.</p>
        <br>
        <h2>Reservation #<%= reservationNum %>: </h2>  
        <div style= "margin-left:40px";>      
         
       <h3>Reservation Information</h3>
        <b>Check-in Date:</b> <%= reservation.getCheckIN() %><br />
        <b>Check-out Date:</b> <%= reservation.getCheckOUT() %><br />
        <b>Room Type:</b> <%= reservation.getRoomType() %><br />
        <b>Total:</b> <%= reservation.getStayPrice() %><br />
        
        
        <br>
        <br>
         </div>    
        
        <!-- ADD BUTTON TO ADD RESERVATION TO CART OR SHOP -->
        <form method="POST" action="cart" name="cartForm">
        <input type="hidden" name="action" value="add"/>        
        <input type="hidden" name="reservationNum" id="reservationNum" value="${reservationNum}">       
        <input class="btn btn-secondary" type="submit" value="Add to Cart" id="addToCart">
        </form>
        
        <form method="POST" action="reservations" name="rForm">
        <input type="hidden" name="action" value="remove"/>
        <inpit type="hidden" name="reservationNum" id="reservationNum" value="${reservationNum}"/>
        <input class="btn btn-secondary" type="submit" value="Cancel" id="remove">
        </form>
        <br />
        <br />
        
        </div>
    </body>
</html>
