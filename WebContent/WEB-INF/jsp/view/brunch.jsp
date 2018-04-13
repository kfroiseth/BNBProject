
<%@ include file="/WEB-INF/jsp/view/template/header.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: Krista
  Date: 11/10/2017
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!doctype html>
<html lang="en">


<main role="main">

    <div id="myCarousel" class="carousel slide" data-ride="carousel">

        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="first-slide" src="<c:url value="/resources/images/brunch.jpg" />" alt="First slide">
                <div class="container">
                    <div class="carousel-caption text-left">
                        <h2>Start your day off with <span class="purple">Brunch</span></h2>
                        <p class="main_title">Enjoy freshly prepared food everyday in our dining from 10:00 AM to 1:00 PM</p>
                    </div>
                </div>
            </div>

        </div>

    </div>

    <div class="container marketing">
        <h2><span class="purple">All you can eat!</span></h2>
        <p>We do our best to source locally and provide the highest quality foods. Served hot and to your table, our food is prepared to order. Enjoy our delicious French toast, banana bread casserole, and
            our delicious home-made pastries.</p>
        <hr>
        <h2>Breakfast-style A la carte</h2>
        <ul>
            <li>Eggs Benedict with ham</li>
            <li>Eggs Benedict with bacon</li>
            <li>Eggs Benedict with salmon</li>
            <li>Omelets</li>
            <li>Eggs choices: scrambled, fried, poached, or boiled</li>
            <li>Country ham, bacon, turkey bacon, and sausage</li>
            <li>Fresh seasonal fruit</li>
        </ul>
        <br>
        <h2>Lunch-style A la carte</h2>
        <ul>
            <li>Home-made soup of the day</li>
            <li>Mixed green salad or roasted beet salad</li>
            <li>Roasted seasonal vegetables</li>
            <li>Flat bread with assorted toppings</li>
            <li>fresh chicken salad, ahi tuna salad and pasta salad</li>
        </ul>
        <br>
        <p>*For early risers, coffee is available in the kitchen at 8:00 AM.
            <br>
            *A breakfast tray can be delivered directly to your room, just ask!
            <br>
            *Please be sure to let us know of any food allergies.</p>
    </div>

    <br />
    <br />


    <div class="container marketing">

        <!-- Three columns of text below the carousel -->
        <div class="row">
            <div class="col-lg-4">
                <img class="rounded-circle" src="<c:url value="/resources/images/Eggs_benedict_opt.jpg" />" alt="comfort room" width="140" height="140">
                <h2 class="span">Cooked to order</h2>
                <p>All of our food is cooked to order, just the way you like it.</p>

            </div><!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <img class="rounded-circle" src="<c:url value="/resources/images/oranges.jpg" />" alt="standard room" width="140" height="140">
                <h2 class="span">Fresh</h2>
                <p>If it's in season, it's on our menu. </p>

            </div><!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <img class="rounded-circle" src="<c:url value="/resources/images/tart.jpg" />" alt="luxury suite" width="140" height="140">
                <h2 class="span">Delicious</h2>
                <p>All of our recipes are tried and true.</p>

            </div><!-- /.col-lg-4 -->
        </div><!-- /.row -->
        <br />
        <br />
        <br />


          <h3>Need <span class="purple">Brunch for a Bunch?</span></h3>
             <p><span class="purple">Sleeping Inn</span> catering compliments any occasion such as weddings, business luncheons, dinners, or other special events and private parties. From light fare to full-service,
                 sit-down dining, you’ll find menus to suit a variety of tastes and budgets. Please contact us for a quote.</p>

    </div><!-- /.container -->
    <br />
    <br />
    <br />
    <br />

   <%@ include file="/WEB-INF/jsp/view/template/footer.jsp" %>