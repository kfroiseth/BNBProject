<%
//Krista Froiseth
//COP4813.0M1
//Project 3 - Reservation System - list reservations %>

<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.KFbnb.Reservation" %>
<%@ page import="com.KFbnb.Cart" %>
<%@ page import="com.KFbnb.LoginServlet" %>
<%@ include file="/WEB-INF/jsp/base.jspf" %>
<%@ include file="/WEB-INF/jsp/view/template/header.jsp" %>
<%
    @SuppressWarnings("unchecked")
    Cart cart = (Cart)request.getAttribute("cart");
		ArrayList<Reservation> res = cart.getCartItems();
%>




<!DOCTYPE html>
<html>
    <head>
        <title>Sleeping Inn B &amp; B</title>
        
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.0.0/moment.min.js"></script>
        <script type="text/javascript" lang="javascript">
            var postInvisibleForm = function(url, fields) {
                var form = $('<form id="mapForm" method="post"></form>')
                        .attr({ action: url, style: 'display: none;' });
                for(var key in fields) {
                    if(fields.hasOwnProperty(key))
                        form.append($('<input type="hidden">').attr({
                            name: key, value: fields[key]
                        }));
                }
                $('body').append(form);
                form.submit();
            };
            var newChat = function() {
                postInvisibleForm('<c:url value="/chat" />', { action: 'new' });
            };
        </script>
    </head>
    

    <body>
    <br />
     <br />
      <br />
       <br /> 
        <br />
         <br />
         <div class="marketing container">
        <h2>Your Reservations:</h2>
        
        <%
            if(res.size() == 0)
            {
                %><i>There are no reservations in the cart.</i><%
            }
            else
            {
                for(int i = 0; i<res.size(); i++)
                {
                	Reservation reservation = res.get(i);
                	
                                        
                  %>     		      
                 
                 <b>Reservation Number:</b> <%= reservation.getReservationNum() %><br />
       			 <b>Check-in Date:</b> <%= reservation.getCheckIN() %><br />
       			 <b>Check-out Date:</b> <%= reservation.getCheckOUT() %><br />
        		 <b>Room Type:</b> <%= reservation.getRoomType() %><br />
        		 <b>Total:</b> <%= reservation.getStayPrice() %><br />
        		 
        		        		        		      			          
         <hr>
               <%  } %>
               <h3>Total: <%= cart.getOrderTotal() %></h3>
            
                
           <%  }
        %>
        <br />
        
        <br /> 
        <br /> 
        <br /> 
        <hr>
        
        <form method="POST" action="cart" name="cartForm">
        	<input type="hidden" name="action" value="checkOut"/>        
        	<input class="btn btn-secondary" type="submit" value="Check Out" id="checkOut">
        </form>
         <form method="POST" action="reservations" name="cForm">
        	<input type="hidden" name="action" value="shop"/>        
        	<input class="btn btn-secondary" type="submit" value="Shop" id="shop">
        </form>
        	
       <a href="javascript:void 0;"
           onclick="newChat();">Chat with Support</a><br />
              
    
            
        	<a href="<c:url value="/chat">
            	<c:param name="action" value="list" />
        		</c:url>">View Chat Requests</a><br />
        
        	
        	<br />
     
        	<br />
        	<a href="<c:url value="/login?logout" />">Logout</a>
        	</div>
        	
    </body>
   <%@ include file="/WEB-INF/jsp/view/template/footer.jsp" %>
