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
<body id="new_card_page_body">
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
	 	<div id="card_info_container" class="w-50 shadow mx-auto mt-2 p-4">	
	 		<h2 class="text-center" >Add Card Info</h2>
	 		<hr/>
	 		<form:form action="/flights/create/card" method="post" modelAttribute="cardObject">
	 		<form:input type="hidden" path="cardUser" value="${currentUser.id}" />
	 			<div class="form-group">
	 				<p>
	 					<form:label path="firstName">First Name on Card:</form:label>
	 					<form:errors path="firstName" class="text-danger"/>
	 					<form:input placeholder="First Name" class="form-control" path="firstName"/>
	 				</p>
	 			</div>
	 			<div class="form-group">
	 				<p>
	 					<form:label path="lastName">Last Name on Card:</form:label>
	 					<form:errors path="lastName" class="text-danger"/>
	 					<form:input placeholder="Last Name" class="form-control" path="lastName"/>
	 				</p>
	 			</div>
	 			<div class="form-group">
	 				<p>
	 					<form:label path="cardNumber">Card Number:</form:label>
	 					<form:errors path="cardNumber" class="text-danger"/>
	 					<form:input placeholder="Card Number" class="form-control" path="cardNumber"/>
	 				</p>
	 			</div>
	 			<div class="form-group">
	 				<p>
	 					<form:label path="expirationDate">Expiration Date:</form:label>
	 					<form:errors path="expirationDate" class="text-danger"/>
	 					<form:input placeholder="xx/xx" class="form-control" path="expirationDate"/>
	 				</p>
	 			</div>
	 			<div class="form-group">
	 				<p>
	 					<form:label path="cvvNumber">CVV Number:</form:label>
	 					<form:errors path="cvvNumber" class="text-danger"/>
	 					<form:input placeholder="CVV" class="form-control" path="cvvNumber"/>
	 				</p>
	 			</div>
	 			<div class="form-group">
	 				<p>
	 					<form:label path="streetAddress">Street Address:</form:label>
	 					<form:errors path="streetAddress" class="text-danger"/>
	 					<form:input placeholder="Street Address" class="form-control" path="streetAddress"/>
	 				</p>
	 			</div>
	 			<div class="form-group">
	 				<p>
	 					<form:label path="cityName">City:</form:label>
	 					<form:errors path="cityName" class="text-danger"/>
	 					<form:input placeholder="City Name" class="form-control" path="cityName"/>
	 				</p>
	 			</div>
	 			<div class="form-group">
	 				<p>
	 					<form:label path="stateName">State</form:label>
	 					<form:errors path="stateName" class="text-danger"/>
	 					<form:input placeholder="State Name" class="form-control" path="stateName"/>
	 				</p>
	 			</div>
	 			<div class="form-group">
	 				<p>
	 					<form:label path="zipcode">Zipcode:</form:label>
	 					<form:errors path="zipcode" class="text-danger"/>
	 					<form:input placeholder="Zipcode" class="form-control" path="zipcode"/>
	 				</p>
	 			</div>
	 			<input type="submit" value="Add Card Info" class="btn btn-dark" />
	 		</form:form>
 		</div>
 	</div>
 	<footer id="login_reg_footer">
		<p class="text-center mt-6">Copyrigth © | 2021 Silicon Valley Fligth Reservation Agency | All Rigths Reserved </p>
		</footer>  
</body>
</html>