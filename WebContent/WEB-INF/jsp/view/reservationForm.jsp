<!-- Krista Froiseth
	 COP4813.0M1
	 BNB project Reservation System: Main registration form -->

<%@ include file="/WEB-INF/jsp/view/template/header.jsp" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.KFbnb.Room" %>
<%@ page import="com.KFbnb.ReservationServlet" %>

<%
Room room = (Room)request.getAttribute("room"); %>
 

<% 
@SuppressWarnings("unchecked")
	Map<String, String> errors = (Map<String, String>)request.getAttribute("errors"); %>
<!DOCTYPE html>
<html>
    <head>
        <title>Sleeping Inn B &amp; B - Reservation System</title>
       
       
		<link rel = "stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
		<script src = "http://code.jquery.com/jquery-1.9.1.js"></script>
		<script src = "http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
		<style>
			.datepicker{
			}
		</style>
		<script>
			$(function(){
				$(".datepicker ").datepicker();
			});
		</script>
		<script>
			function myFunction() {
    		document.getElementById("rForm").reset();
			}
</script>
    </head>
      
      
      
    
    
    <body>
                   
           <br />
           <br />
           <br />
   		<div class="main_title">
  		
					
				
			<div class="container marketing">
			<h2>Reservations</h2>
			<h3>Room Details for ${room.roomName} </h3>
	  				<div class="col-md-5">
                       <img src="<c:url value="/resources/images/${room.roomName}.jpg"/>" alt="room image" style="width:100%;height:auto;"/>
                	</div>
                	</div>
            <div class="container marketing">
			<form method="POST" action="reservations" name="rForm"> <!-- enctype="multipart/form-data"-->
				 <input type="hidden" name="action" value="create"/>
	  			<fieldset>
	  				  	<br />               	
	  				
	  						<input type="hidden" name="roomName" id="roomName" value="${room.roomName}">
	  					
	  					<p><strong>Room Type:</strong> ${room.roomType}</p>
	  						<input type="hidden" name="roomType" id="roomType" value="${room.roomType}">
	  					
                       <p><strong>Description:</strong> ${room.roomType}</p>
                       		
                       <p><strong>Price per night:</strong> ${room.roomPrice} USD</p>
                       		<input type="hidden" name="roomPrice" id="roomPrice" value="${room.roomPrice}">
	  			 </fieldset>
	 			 <fieldset>
	   			 	<h4>1. Check-in/Check-out</h4>
					<p>Please specify the dates of your stay and the number of adults and children in your room.</p>
	    			<h4>Check-in:</h4>
					<input type="text" id="check_in" name="check_in" class="datepicker" placeholder="MM/DD/YYYY" required/>
					<span class="error">${errors.Date1}</span>
					<span class="error">${errors.Date2}</span>
					<span class="error">${errors.Dates}</span>
					<br>
					<h3>Check-out:</h3>
					<input type="text" id="check_out" name="check_out" class="datepicker" placeholder="MM/DD/YYYY" required/>
					<span class="error">${errors.Date3}</span>
					<span class="error">${errors.Dates}</span>
					<span class="error">${errors.Length}</span>
       		        <br>
	  			    <br> 			
	  				</fieldset>	
	  
	  					  	  
      				<!-- <fieldset class="field">
	    				<legend>2. Billing Information</legend>
	    				<p>Please provide your contact information.</p>
	    				<br>
	    				<div class="form-group">
	    					<label for="firstName">*First Name</label> <input type="text" name="firstName" id="firstName" required="required" >
	    					<span class="error">${errors.Name}</span>
		                </div>
		                <div class="form-group">                      
	    					<label for="lastName">*Last Name</label> <input type="text" name="lastName" id="lastName" required="required" >
	    					<span class="error">${errors.Name}</span>
	    				</div>
	    				<div class="form-group">
	    					<label for="myAddress">*Address</label> <input type="text" name="address" id="address" required="required">
	    					<span class="error">${errors.Address}</span>
	    				</div>
	    				
	    				<div class="form-group">
	    					<label for="city">City</label> <input type="text" name="city" id="city" >
	   				    	<span class="error">${errors.City}</span>
	   				    </div>
	   				    <div class="form-group">
	   				    	<label for="state">State</label> <input type="text" name="state" id="state" >	    
	   				    	<span class="error">${errors.State}</span>
	   				    </div>
	   				    <div class="form-group">
	   				    	<label for="myPost">*Zip Code</label> <input type="text" name="zip" id="zip" required="required" value="${param.origin}">
   							<span class="error">${errors.Zip}</span>
	   				    </div>
	   				    <div class="form-group">
	   				    	<label for="myPhone">*Phone #</label> <input type="tel" name="phone" id="phone" required="required"
                                               pattern="\d{3}[\-]\d{3}[\-]\d{4}" placeholder="xxx-xxx-xxxx">		
                        	<span class="error">${errors.Phone}</span>
                        </div>
                        <div class="form-group">
       				    	<label for="email">*E-mail</label> <input type="email" name="email" id="email" required="required" placeholder="user@domain.com">
	  						
	  					</div>
	  				</fieldset>-->
        				<br>
        				<br>
        				<input class="btn btn-secondary" type="submit" value="Submit" id="mySubmit1">	&nbsp;
        				<input class="btn btn-secondary" type="reset" value="Reset" id="myReset1">
	  	
        				</form>
        				</div>
       					 <p>*Prices include all amenities and brunch.</p>
						</div>
				
	  		<div class="column">
			<h2><span class="purple">Booking and Cancellation Policies</span></h2>
				<p>Arrivals: After 4 p.m.
				<br>
	  			Departures: No later than 2 p.m.</p>
	  			<ul class="policy">
	    			<li>Credit card is required upon booking to guarantee your reservation.</li>
					<li>Cancellations more than 3 days prior to arrival: a $30.00 service fee will be deducted from the refundable amount.</li>
					<li>Cancellations less than 3 day before arrival: no refund guarantee.</li>
					<li>Taxes are not included in the listed rates.</li>
					<li>Pets are not allowed.</li>
					<li>Sleeping Inn has a strict non-smoking policy. Additional fees will be assessed for breaking policy.</li>
					<li>Room rates are subject to change at anytime.</li>
	  			</ul>
			</div>
        <a href="<c:url value="/login?logout" />">Logout</a>
        

