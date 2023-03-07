<%@page import="java.util.Iterator"%>
<%@page import="modal.Place"%>
<%@page import="service.PlaceService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900"
	rel="stylesheet">
<link rel="icon" href="images/header-logo.png">

<!-- Bootstrap CSS 
<link rel="stylesheet" href="css/bootstrap.min.css">  -->
<link rel="stylesheet" href="css/index.css">
<title>Fly Away</title>

</head>

<body>
<%
PlaceService ps = new PlaceService();
List<Place>listOfPlace = ps.findAllPlace();
Iterator<Place> lt = listOfPlace.iterator();
Iterator<Place> ld = listOfPlace.iterator();
%>
				
			<div class="page-wrapper bg-img-3 p-t-240 p-b-120">
<div class="wrapper wrapper--w900" style="margin-top:-10%;">
<div class="card card-6">
<div class="row" style="padding-top:1%;padding-left:1%;padding-down:1%; color:white; font-weight:bold; background-color:#4c5c51; border-radius:15px;">
<p>Welcome to FLYAWAY!<br><br> <i>Find cheap flights and save money on airline tickets to every destination in the world</i></p></div>
<div class="card-body">
<form method="POST" action="FlightSearchController">
<div class="row row-space">
<div class="col-2">
<div class="input-group">
<label class="label">from</label>
<select class="form-control input--style-1" id="travelFrom" name="travelFrom">
<option selected value="selected">Select</option>
<% while(lt.hasNext()){
	Place p = lt.next();
	%> 
<option value="<%=p.getPid() %>"><%=p.getPname() %></option>
	<% } %>
</select>
</div>
</div>
<div class="col-2">
<div class="input-group">
<label class="label">to</label>
<select class="form-control input--style-1" id="travelTo" name="travelTo" required>
<option selected value="selected">Select</option>
<% while(ld.hasNext()){
	Place p = ld.next();
	%> 
<option value="<%=p.getPid() %>"><%=p.getPname() %></option>
	<% } %>
</select>
</div>
</div>
</div>
<div class="row row-space">
<div class="col-2">
<div class="input-group">
<label class="label">Depart</label>
<input class="input--style-1" type="date" name="travelDate" placeholder="DD MMM YYYY" id="travelDate" required>
</div>
</div>
<div class="col-2">
<div class="input-group">
<label class="label">Number of Passenger</label>
<input class="input--style-1 input--text-small" type="number" name="noPassenger"   id="noPassanger" required>

</div>
</div>
</div>
<div class="row row-space">
<div class="col-2">
<button class="btn-submit m-b-0" type="submit">search</button>
</div>
<div class="col-2">

</div>
</div>
</form>
</div>
</div>
</div>
</div>
	
</body>

</html>
