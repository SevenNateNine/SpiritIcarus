<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Itinerary"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!--
	This is the Item Details page
	This page displays the data for each item
	The details are fetched using the "items" field from the request object
-->

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width:device-width, initial-scale=1">
	<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
	<title>Itinerary Details</title>
</head>
<body class="container"><br>

	<h1>Itinerary is:</h1>
	<div class="container">
	<c:if test="${empty itinerary}">
		<h3>Itinerary not found! <h3/> 
	</c:if>
	<c:if test="${not empty itinerary}">
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th>Reservation No</th>
		      <th>Airline ID</th>
		      <th>Flight No</th>
		      <th>Departure Airport</th>
		      <th>Arrival Airport</th>
		      <th>DepTime</th>
		      <th>ArrTime</th>
		    </tr>
		  </thead>
		  <tbody>
		     <c:forEach items="${itinerary}" var="cd">
		       <tr>
		         <td>${cd.getResrNo()}</td>
		         <td>${cd.getAirlineID()}</td>		         
		         <td>${cd.getFlightNo()}</td>
		         <td>${cd.getDeparture()}</td>
		         <td>${cd.getArrival()}</td>		         
		         <td>${cd.getDepTime()}</td>
		         <td>${cd.getArrTime()}</td>
		         <td></td>
		       </tr>
		     </c:forEach>
		  </tbody>
		</table>
	</c:if>
	</div>
	<div class="container pt-1">
		<form action="home.jsp">
			<input type="submit" value="Home" class="btn btn-success"/>
		</form>
	</div>

	
	<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	
</body>
</html>