<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Auctions"%>
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
	<body>
	
		<h1>Reverse Auctions:</h1>
		<div class="container">
			<h2>View bids:</h2>
			<div class="row">
				<div class="col">
					<div class="card">
					  <div class="card-body">
					    <h5 class="card-title">Bid Parameters</h5>
    					<div class="container">
							<form method="POST" action="getReverseAuctions">
								<label for="airlineID">Airline ID</label>
	    						<input type="text" class="form-control" id="airlineID" name="airlineID" placeholder="Type Airline ID">
								<label for="flightNo">Flight No</label>
	    						<input type="text" class="form-control" id="flightNo" name="flightNo" placeholder="Type Flight No">
								<label for="seatClass">Class</label>
	    						<input type="text" class="form-control" id="seatClass" name="seatClass" placeholder="Type Class, example, First">
								<input type="submit" name="typeofquery" value="Get Latest Bid" class="btn btn-primary"/>
								<input type="submit" name="typeofquery" value="Get All Bids" class="btn btn-primary"/>
								
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