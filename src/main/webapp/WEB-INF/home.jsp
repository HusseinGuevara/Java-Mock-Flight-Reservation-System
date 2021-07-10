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
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body id="home_container">
<nav class="navbar sticky-top ">
	 	<img class="plane_logo" src="/images/airplanelogo.png" alt="image">
	 	<a id="home_link" class="text-decoration-none text-white h5 " href="/home" >Home</a>
	 	<a id="all_flights_link" class="text-decoration-none text-white h5 " href="/flights" >All Flights</a>
	 	<a id="myFlights_link" class="text-decoration-none text-white h5 " href="/flights/myflights" >My Flight</a>
	 	<a id="create_flights_link" class="text-decoration-none text-white h5 " href="/flights/new" >Create Flight</a>
	 	<h5 id="welcome_tag" >Welcome, <c:out value="${currentUser.userName}"/></h5>
	 	<a id="logout_link" href="/logout" class="text-decoration-none">Logout</a>
 	</nav>
	<div class="w-80 mx-auto rounded ">
	<h1 id="welcome_header">Welcome to<br> Silicon Valley<br> Fligth Reservation Agency</h1>

	
	
	</div>
	<footer id="login_reg_footer">
		<p class="text-center mt-6">Copyrigth © | 2021 Silicon Valley Fligth Reservation Agency | All Rigths Reserved </p>
		</footer>  
</body>
</html>