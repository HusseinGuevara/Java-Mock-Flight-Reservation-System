<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body id="my_flights_body">
	<nav class="navbar sticky-top ">
	 	<img class="plane_logo" src="/images/airplanelogo.png" alt="image">
	 	<a id="home_link" class="text-decoration-none text-white h5 " href="/home" >Home</a>
	 	<a id="all_flights_link" class="text-decoration-none text-white h5 " href="/flights" >All Flights</a>
	 	<a id="myFlights_link" class="text-decoration-none text-white h5 " href="/flights/myflights" >My Flight</a>
	 	<a id="create_flights_link" class="text-decoration-none text-white h5 " href="/flights/new" >Create Flight</a>
	 	<h5  id="welcome_tag" >Welcome, <c:out value="${currentUser.userName}"/></h5>
	 	<a id="logout_link" href="/logout" class="text-decoration-none">Logout</a>
	 	
 	</nav>
 	<div id="register_container" class="w-75 mx-auto shadow mt-2 p-4 rounded">
 		<h2 class="text-center"><c:out value="${currentUser.userName}"/>'s Flight</h2>
 		<hr/>
 		<table class="table table-striped table-hover ">
 			<thead>
 				<tr>
 					<td class="h6">Flight Number:</td>
 					<td class="h6">Flight Name:</td>
 					<td class="h6">Departing City:</td>
 					<td class="h6">Flight Duration:</td>
 					<td class="h6">Arriving Airport Name:</td>
 				</tr>			
 			</thead>
 			<tbody>
 				<tr>
 					<td class="h6"><c:out value="${myFlight.flightNumber}"/></td>
 					<td class="h6"><c:out value="${myFlight.flightName}"/></td>
 					<td class="h6"><c:out value="${myFlight.departingCity}"/></td>
 					<td class="h6"><c:out value="${myFlight.flightDuration}"/></td>
 					<td class="h6"><c:out value="${myFlight.arrivingAirportName}"/></td>
 				</tr>
 			</tbody>
 		</table>
 		<hr/>
 		<a href="/flights/checkout" class="btn btn-dark">Checkout</a>
 	
 	
 	
 	</div>
 	<footer id="login_reg_footer">
		<p class="text-center mt-6">Copyrigth © | 2021 Silicon Valley Fligth Reservation Agency | All Rigths Reserved </p>
		</footer>  
</body>
</html>