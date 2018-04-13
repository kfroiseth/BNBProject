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
<% Map<String, String> message = (Map<String, String>)request.getAttribute("message"); %>

<!doctype html>
<html lang="en">
   

<body>

<!-- <header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="<c:url value="/" />">Sleeping Inn Bed & Brunch</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="/home" />">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/roomList" />">Rooms</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/brunch" />">Brunch</a>
                </li>
            </ul>
            <div class="form-inline mt-2 mt-md-0">
                <ul class="navbar-nav mr-auto">

                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/login" />">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/#" />">Admin</a>
                     </li>
                </ul>
            </div>
        </div>
    </nav>
</header> -->
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
	<span class="message">${message.Success}</span>
    You must log in to access the reservation system.<br /><br />
    <c:if test="${loginFailed}">
        <b>The username and password you entered are not correct. Please try
            again.</b><br /><br />
    </c:if>
    <form method="POST" action="<c:url value="/login" />">
        Username<br />
        <input type="text" name="username" /><br /><br />
        Password<br />
        <input type="password" name="password" /><br /><br />
        <input class="button" type="submit" value="Log In" />
    </form>
    <br />
    <br/>
    <h3>New? Create an account.</h3>
    <a href="<c:url value="register" />">Register</a>
    </div>
    </body>
</html>