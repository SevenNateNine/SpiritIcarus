<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
	This is the Search Movies page
	This page displays fields to search an movie by type or by name 
	The movie type details are fetched from "movies" request attribute
-->

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width:device-width, initial-scale=1">
		<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
	</head>
	<body class="container">
	
		<h1>Search Reservations:</h1><br>
		<div class="container">
			<h2>Search Options:</h2><br>
			<div class="row">
				<div class="col">
					<div class="card">
					  <div class="card-body">
					    <h5 class="card-title">Search by Flight Number</h5>
    					<div class="container">
							<form method="POST" action="searchFlightReservations">
								<label for="flightNum">Flight Number:</label>
	    						<input type="text" class="form-control" id="flightNum" name="flightNum" placeholder="Type Flight Number or a Part of it"><br>
								<label for="airlineID">Airline ID:</label>
	    						<input type="text" class="form-control" id="airlineID" name="airlineID" placeholder="Type Airline ID"><br><br>					
								<input type="submit" value="Search" class="btn btn-primary"/><br>
							</form>
						</div>
					  </div>
					</div>
				</div>
				<div class="col">
					<div class="card">
					  <div class="card-body">
					    <h5 class="card-title">Search by Customer</h5>
    					<div class="container">
							<form method="POST" action="searchFlightReservations">
								<label for="customerName">Customer Name:</label>
	    						<input type="text" class="form-control" id="customerName" name="customerName" placeholder="Type Customer Name or a Part of it"><br>
								<input type="submit" value="Search" class="btn btn-primary"/><br>
							</form>
						</div>
					  </div>
					</div>
				</div>
				
			</div>				
		</div>
		<div class="container pt-1">
			<form action="home.jsp">
				<input type="submit" value="Home" class="btn btn-success"/>
			</form>
		</div>
		
		<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/4.1.3/bootstrap.min.js"></script>
	</body>
</html>