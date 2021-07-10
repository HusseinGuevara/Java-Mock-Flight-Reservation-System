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
<body id="new_flight_page_body">
	<nav class="navbar sticky-top ">
 	<img class="plane_logo" src="/images/airplanelogo.png" alt="image">
 	<a id="home_link" class="text-decoration-none text-white h5 " href="/home" >Home</a>
 		<a id="all_flights_link" class="text-decoration-none text-white h5 " href="/flights" >All Flights</a>
 		<a id="myFlights_link" class="text-decoration-none text-white h5 " href="/flights/myflights" >My Flight</a>
 		<a id="create_flights_link" class="text-decoration-none text-white h5 " href="/flights/new" >Create Flight</a>
 		<h5  id="welcome_tag" >Welcome, <c:out value="${currentUser.userName}"/></h5>
 		<a id="logout_link" href="/logout" class="text-decoration-none">Logout</a>
 	</nav>
	<div class="w-80 mx-auto mt-2 p-4">
<%-- 	<h5>Welcome, <c:out value="${currentUser.userName}"/></h5> --%>
<!-- 	<a  href="/logout" class="text-decoration-none">Logout</a> -->
<!-- 	<hr/> -->
		<div id="new_flight_container" class="w-50 mx-auto shadow-lg rounded mt-4 p-4">	
			<h2 class="text-center">Create Flight</h2>
			<form:form action="/flights/create" method="post" modelAttribute="flightObject">
				<div class="form-group">
					<p>
						<form:label path="flightNumber">Flight Number:</form:label>
						<form:errors path="flightNumber" class="text-danger"/>
						<form:input class="form-control" path="flightNumber"/>
					</p>
				</div>
				
				<div class="form-group">
					<p>
						<form:label path="flightName">Flight Name:</form:label>
						<form:errors path="flightName" class="text-danger"/>
						<form:input class="form-control" path="flightName"/>
					</p>
				</div>
				
				<div class="form-group">
					<p>
						<form:label path="departingCity">Departing City:</form:label>
						<form:errors path="departingCity" class="text-danger"/>
						<form:input class="form-control" path="departingCity"/>
					</p>
				</div>
				
				<div class="form-group">
					<p>
						<form:label path="arrivalCity">Arrival City:</form:label>
						<form:errors path="arrivalCity" class="text-danger"/>
						<form:input  class="form-control" path="arrivalCity"/>
					</p>
				</div>
				
				<div class="form-group">
					<p>
						<form:label path="flightDate">Date of Departure:</form:label>
						<form:errors path="flightDate" class="text-danger"/>
						<form:input type="date" class="form-control" path="flightDate"/>
					</p>
				</div>
				
				<div class="form-group">
					<p>
						<form:label path="departureTime">Departure Time:</form:label>
						<form:errors path="departureTime" class="text-danger"/>
						<form:input type="time" class="form-control" path="departureTime"/>
					</p>
				</div>
				
				<div class="form-group">
					<p>
						<form:label path="flightDuration">Flight Duration:</form:label>
						<form:errors path="flightDuration" class="text-danger"/>
						<form:input class="form-control" path="flightDuration"/>
					</p>
				</div>
				
				<div class="form-group">
					<p>
						<form:label path="departingAirportName">Departing Airport Name:</form:label>
						<form:errors path="departingAirportName" class="text-danger"/>
						<form:input class="form-control" path="departingAirportName"/>
					</p>
				</div>
				
				<div class="form-group">
					<p>
						<form:label path="arrivingAirportName">Arriving Airport Name:</form:label>
						<form:errors path="arrivingAirportName" class="text-danger"/>
						<form:input class="form-control" path="arrivingAirportName"/>
					</p>
				</div>
				
				<div class="form-group">
					<p>
						<form:label path="ticketPrice">Ticket Price:</form:label>
						<form:errors path="ticketPrice" class="text-danger"/>
						<form:input class="form-control" path="ticketPrice"/>
					</p>
				</div>
				
				<div class="form-group">
					<p>
						<form:label path="flightDescription">Flight Description:</form:label>
						<form:errors path="flightDescription" class="text-danger"/>
						<form:input class="form-control" path="flightDescription"/>
					</p>
				</div>
				<input type="submit" value="Create Flight" class="btn btn-dark" />
			</form:form>
		</div>	
	
	</div>
	<footer id="login_reg_footer">
		<p class="text-center mt-6">Copyrigth © | 2021 Silicon Valley Fligth Reservation Agency | All Rigths Reserved </p>
		</footer>  
</body>
</html>