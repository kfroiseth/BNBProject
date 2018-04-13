<%--@elvariable id="loginFailed" type="java.lang.Boolean"--%>
<%@ include file="/WEB-INF/jsp/view/template/header.jsp" %>

<%@ page import="java.util.Map" %>
<%@ page import="com.KFbnb.User" %>
<%@ page import="com.KFbnb.RegisterUser" %>

<%--
  Created by IntelliJ IDEA.
  User: Krista
  Date: 11/10/2017
  Time: 10:35 AM

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% 
@SuppressWarnings("unchecked")
	Map<String, String> errors = (Map<String, String>)request.getAttribute("errors"); 
	Map<String, String> message = (Map<String, String>)request.getAttribute("message"); %>

<!doctype html>
<html lang="en">
   

<main role="main">

    <div id="myCarousel" class="carousel slide" data-ride="carousel">

        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="first-slide" src="<c:url value="/resources/images/Bordeaux_opt.jpg" />" alt="Main Bedroom">
                <div class="container">
                    <div class="carousel-caption text-left">
                        <h1>Welcome to Sleeping Inn Bed & Brunch</h1>
                        <p>A charming and modern escape designed by those who like to sleep in and eat late for those who like to sleep in and eat late!</p>
                    </div>
                </div>
            </div>

        </div>

    </div>

    <div class="container marketing">
	<body>
	<span class="message">${message.Error}</span>
	<h1>Registration</h1>
     You must create a user account to log in.<br /><br />
     <form method="POST" action="<c:url value="register" />">
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
	  						<span class="error">${errors.Email}</span>
	  					</div>
	  					<div class="form-group">
       				    	<label for="username">User Name</label> <input type="text" name="userName" id="userName" required="required">
       				    	<span class="error">${errors.Username}</span>
	  					</div>
	  					<div class="form-group">
       				    	<label for="password1">Password</label> <input type="text" name="pword1" id="pword1" required="required" >
	  					</div>
	  					<div class="form-group">
       				    	<label for="password2">Re-type Password</label> <input type="text" name="pword2" id="pword2" required="required" >
	  					</div>
	  					
	  				</fieldset>
	  					<br>
        				<br>
        				<input class="btn btn-secondary" type="submit" value="Submit" id="mySubmit1">	&nbsp;
        				<input class="btn btn-secondary" type="reset" value="Reset" id="myReset1">
	  	
        			
    </form>