
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
                <img class="first-slide" src="<c:url value="/resources/images/Bordeaux_opt.jpg" />" alt="First slide">
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
        <h3>Looking for something a<span class="purple"> little different?</span></h3>
        <hr>
        <p>A unique inn with a unique concept. Sleeping Inn is distinguished by its romantic character, modern design, and excellent food &mdash; served all in the heart of dynamic and exciting Downtown Portlandia.
            And you read right, we're a bed and brunch. We don't do early mornings but instead cater those who want to sleep-in and eat late.</p>
        <p>Tucked away on N Street, with its charming Victorian townhouses, our Inn will appeal to every budget. We offer a diverse range of rooms and suites, located in two century-old homes.
            Each offers comfort for those who like to enjoy what the city offers at night and the ability to sleep in without worry of missing out on breakfast, or brunch!</p>
        <p>Whether for a romantic getaway, a leisurely stay with family and friends or for business, Sleeping Inn will delight your senses and exceed your expecatiations.</p>
        <p>Sleeping Inn offers a library for a relaxing mid-afternoon read, an office for research and business, a bright and open dining nook, and all of our rooms feature luxuious bathrooms with
            whirlpool tubs and the comforts and necessities of your home. These are just a few of the attributes that make Sleeing Inn a unique and special place to stay. Oh, and did we mention brunch?!</p>
    </div>

    <br />
    <br />


    <div class="container marketing">

        <!-- Three columns of text below the carousel -->
        <div class="row">
            <div class="col-lg-4">
                <img class="rounded-circle" src="<c:url value="/resources/images/Caribou.jpg" />" alt="comfort room" width="140" height="140">
                <h2 class="span">Comfort Rooms</h2>
                <p>Cozy rooms perfectly suited for two people. Private bath and shared bath options available.</p>
                
            </div><!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <img class="rounded-circle" src="<c:url value="/resources/images/Hey Violet.jpg" />" alt="standard room" width="140" height="140">
                <h2 class="span">Standard Rooms</h2>
                <p>Spacious rooms with seating area, full private bath and mini kitchenette.</p>
                
            </div><!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <img class="rounded-circle" src="<c:url value="/resources/images/Yo La Tengo.jpg" />" alt="luxury suite" width="140" height="140">
                <h2 class="span">Luxury Suites</h2>
                <p>Occupying an entire floor, our luxury suites include a spacious lounge area, a private bath with two-person tub with jets, mini kitchen and private terrace.</p>
                
            </div><!-- /.col-lg-4 -->
        </div><!-- /.row -->
        <br />
        <br />
        <br />
        <p style="text-align:center;"><a class="btn btn-secondary" href="<c:url value="/roomList"/>" role="button">View Our Rooms &raquo;</a></p>


    </div><!-- /.container -->
</main>
   <%@ include file="/WEB-INF/jsp/view/template/footer.jsp" %>