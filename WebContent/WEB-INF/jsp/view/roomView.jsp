<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
   <%@ include file="/WEB-INF/jsp/view/template/header.jsp" %>
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

                <h3>Room Details</h3>
                <p>Below is the information for this room.</p>
            </div>
            <br />
            <hr>
            <br />

           <div class="container" ng-app="cartApp">
               <div class="row">
                   <div class="col-md-5">
                       <img src="<c:url value="/resources/images/${room.roomName}.jpg"/>" alt="room image" style="width:100%;height:auto;"/>
                </div>
   <%
                 try
   {
       Class.forName("com.mysql.jdbc.Driver");
       String url="jdbc:mysql://localhost:3306/BNB";
       String username="root";
       String password="Beu|ah1980*";
       String query="select * from rooms where roomName = ?";
       Connection conn=DriverManager.getConnection(url, username, password);
       Statement stmt=conn.createStatement();
       ResultSet rs=stmt.executeQuery(query);
       while(rs.next())
       {
    	   String room = rs.getString("roomName");
    	   System.out.print(room);
   %>

                   <div class="col-md-5">
                       <h3><%= rs.getString("roomName") %></h3>
                       <p><strong>Room Type:</strong> <%= rs.getString("roomType") %></p>
                       <p><strong>Description:</strong> <%= rs.getString("roomDescription") %></p>
                       <p><strong>Price per night:</strong> <%= rs.getDouble("roomPrice") %> USD</p>
                       
                             <%
       }
   %>
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
                       <br />
                       <br />
                    

                    </div>
                   </div>
               </div>
               <br />
               <br />

           </div>
            <br/>
            <br/>



   <%@ include file="/WEB-INF/jsp/view/template/footer.jsp" %>