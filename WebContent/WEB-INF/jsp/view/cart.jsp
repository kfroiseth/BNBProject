<%
//Krista Froiseth
//COP4813.0M1
//Project 3 - Reservation System - list reservations %>

<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.KFbnb.Reservation" %>
<%@ page import="com.KFbnb.LoginServlet" %>
<%@ include file="/WEB-INF/jsp/base.jspf" %>
<%@ include file="/WEB-INF/jsp/view/template/header.jsp" %>
<%
    @SuppressWarnings("unchecked")
    Map<Integer, Reservation> reservationDatabase = (Map<Integer, Reservation>)request.getAttribute("reservationDatabase");
%>


<%!
    private static String toString(long timeInterval)
    {
        if(timeInterval < 1_000)
            return "less than one second";
        if(timeInterval < 60_000)
            return (timeInterval / 1_000) + " seconds";
        return "about " + (timeInterval / 60_000) + " minutes";
    }
%>

<%
    int numberOfSessions = (Integer)request.getAttribute("numberOfSessions");
    @SuppressWarnings("unchecked")
    List<HttpSession> sessions =
            (List<HttpSession>)request.getAttribute("sessionList");
    
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
        <h2>Your Reservations:</h2>
        
        <%
            if(reservationDatabase.size() == 0)
            {
                %><i>There are no reservations in the system.</i><%
            }
            else
            {
                for(int id : reservationDatabase.keySet())
                {
                    String idString = Integer.toString(id);
                    Reservation reservation = reservationDatabase.get(id);
                    %>
                    <h2>Reservation #<%= idString %>:</h2>
                    
        			<div style= "margin-left:40px";>      
         
      			 <h3>Reservation Information</h3>
       			 <b>Check-in Date:</b> <%= reservation.getCheckIN() %><br />
       			 <b>Check-out Date:</b> <%= reservation.getCheckOUT() %><br />
       			 <b>Room Type:</b> <%= reservation.getRoomType() %><br />
       			 <b>Total: </b> <%= reservation.getStayPrice() %><br />
        
       			 
       			 <br>
       			 <br>
       			  <hr>
         </div>    
         
         <hr>
               <%  }
            }
        %>
        <br />
        
        <br /> 
       
        	
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
