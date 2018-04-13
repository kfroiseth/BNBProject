<%@ include file="/WEB-INF/jsp/view/template/header.jsp" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%--
  Created by IntelliJ IDEA.
  User: Krista
  Date: 11/10/2017
  Time: 10:35 AM

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!doctype html>
<html lang="en">

<main role="main">

<div id="myCarousel" class="carousel slide" data-ride="carousel">

    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="first-slide" src="<c:url value="/resources/images/BB_opt.jpg" />" alt="bathroom">
            <div class="container">
                <div class="carousel-caption text-left">
                    <h1>Sleeping in is easy in our rooms</h1>
                    <p>Modern design and quality bedding allow you to sleep in luxury and style.</p>
                </div>
            </div>
        </div>

    </div>

</div>
<div class="container marketing">
    <div class="container-wrapper">
        <div class="container">

          <h3>All Rooms</h3>
            <p>To ensure that all of our guests can sleep in, all of our rooms have been designed with double block-out curtains and sound-proof double pane windows. Each guest also receives complimentary eye covers and ear plugs, just in case!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
                <tr class="bg-success">
                    <th>Photo Thumb</th>
                    <th>Room Name</th>
                    <th>Room Type</th>
                    <th>Room Price</th>
                    <th>Details</th>
                </tr>
            </thead>
            <%
   try
   {
       Class.forName("com.mysql.jdbc.Driver");
       String url="jdbc:mysql://localhost:3306/BNB";
       String username="root";
       String password="Beu|ah1980*";
       String query="select * from rooms";
       Connection conn=DriverManager.getConnection(url, username, password);
       Statement stmt=conn.createStatement();
       ResultSet rs=stmt.executeQuery(query);
       while(rs.next())
       {
    	   String room = rs.getString("roomName");
    	   System.out.print(room);
   %>
            
            <tr>
                <td><img src="/BNBProject/index/resources/images/<%=rs.getString("roomName") %>.jpg" alt="room image" width="150" height="100"/>
                <td><%=rs.getString("roomName") %></td>
                <td><%=rs.getString("roomType") %></td>
                <td><%=rs.getDouble("roomPrice") %>USD</td>
                <td><a class="btn btn-secondary" href="<c:url value="/reservations">
                        <c:param name="action" value="create" />
                        <c:param name="roomName" value="<%= room %>" />
                        </c:url>">View Room</a></td>
            </tr>
            <%
       }
   %>
            
        </table>
        <br/>
        <br/>
<%
        rs.close();
        stmt.close();
        conn.close();
   }
   catch(Exception e)
   {
        e.printStackTrace();
   }
   %>

        <div class="container-marketing">
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
        <br/>
        <br/>
        <br/>
        <br/>




   <%@ include file="/WEB-INF/jsp/view/template/footer.jsp" %>