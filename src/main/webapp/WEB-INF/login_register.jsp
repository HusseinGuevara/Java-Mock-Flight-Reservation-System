<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Register</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body id="login_register_body">
 		<nav class="navbar sticky-top ">
 		<img class="plane_logo" src="/images/airplanelogo.png" alt="image">
 		<a id="home_link" class="text-decoration-none text-white h5 " href="/home" >Home</a>
 		<a id="all_flights_link" class="text-decoration-none text-white h5 " href="/flights" >All Flights</a>
 		<a id="myFlights_link" class="text-decoration-none text-white h5 " href="/flights/myflights" >My Flight</a>
 		<a id="create_flights_link" class="text-decoration-none text-white h5 " href="/flights/new" >Create Flight</a>
 		
 		
 		</nav>
 		<div id="login_reg_container" class="w-80 mx-auto p-2 rounded">
<!--  		<header id="login_reg_header"> -->
<!--  		<h2 class="text-center">Silicon Valley Flight Reservation Agency</h2> -->
<!--  		</header> -->
		 	<div id="register_container" class="w-50 mx-auto shadow mt-5 p-4 rounded">
		 	<h2 id="login_register" class="text-center">Register</h2>
		 	<hr/>
			    <form:form action="/register" method="post" modelAttribute="newUser">
			        <div id="login_register" class="form-group">
			        	<label class="h5">First Name:</label>
			        	<form:input placeholder="First Name" path="firstName" class="form-control" />
			        	<form:errors path="firstName" class="text-danger" />
			    	</div>
			    	<div id="login_register" class="form-group">
			        	<label class="h5">Last Name:</label>
			        	<form:input placeholder="Last Name" path="lastName" class="form-control" />
			        	<form:errors path="lastName" class="text-danger" />
			    	</div>
			    	<div id="login_register" class="form-group">
			        	<label class="h5">Date of Birth:</label>
			        	<form:input type="date" path="dob" class="form-control" />
			        	<form:errors  path="dob" class="text-danger" />
			    	</div>
			        <div id="login_register" class="form-group">
			            <label class="h5">User Name:</label>
			            <form:input placeholder="User Name" path="userName" class="form-control" />
			            <form:errors path="userName" class="text-danger" />
			        </div>
			        <div id="login_register" class="form-group">
			            <label  class="h5">Email:</label>
			            <form:input placeholder="E-Mail Address" path="email" class="form-control" />
			            <form:errors path="email" class="text-danger" />
			        </div>
			        <div id="login_register" class="form-group">
			            <label class="h5">Password:</label>
			            <form:password placeholder="Password" path="password" class="form-control" />
			            <form:errors path="password" class="text-danger" />
			        </div>
			        <div id="login_register" class="form-group">
			            <label  class="h5">Confirm Password:</label>
			            <form:password placeholder="Confirm Password" path="confirm" class="form-control" />
			            <form:errors path="confirm" class="text-danger" />
			        </div>
			        <input type="submit" value="Register" class="btn btn-dark mt-1" />
			    </form:form>
		    </div>
		    
		    <div id="login_container" class="w-50 mx-auto shadow mt-5 p-4 rounded">
		    <h2 id="login_register" class="text-center">Login</h2>
		    <hr/>
			    <form:form action="/login" method="post" modelAttribute="newLogin">
			        <div id="login_register" class="form-group">
			            <label class="h5">Email:</label>
			            <form:input placeholder="E-Mail Address" path="email" class="form-control" />
			            <form:errors path="email" class="text-danger" />
			        </div>
			        <div id="login_register" class="form-group">
			            <label class="h5">Password:</label>
			            <form:password placeholder="Password" path="password" class="form-control" />
			            <form:errors path="password" class="text-danger" />
			        </div>
			        <input type="submit" value="Login" class="btn btn-dark mt-1" />
			    </form:form>
		    </div>
		</div>
		<footer id="login_reg_footer">
		<p class="text-center">Copyrigth © | 2021 Silicon Valley Fligth Reservation Agency | All Rigths Reserved </p>
		</footer>  
</body>
</html>

