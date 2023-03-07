<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.Iterator"%>
<%@page import="modal.Airline"%>
<%@page import="modal.Flight"%>
<%@page import="service.AirlineService"%>
<%@page import="service.FlightService"%>
<%@page import="service.PlaceService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en">
<head>
<style type="text/css">
  .fcc-btn {
  background-color: #199319;
  color: white;
  padding: 15px 25px;
  text-decoration: none;
  border-radius:25px;
  border:1px solid black;
}

.fcc-btn:hover {
  background-color: #4287f5;
}
</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900"
	rel="stylesheet">
<link rel="icon" href="images/header-logo.png">


<link rel="stylesheet" href="css/index.css">
<title>Fly Away</title>

</head>

<body>

			
<div class="page-wrapper bg-img-3 p-t-240 p-b-120">
<div class="wrapper wrapper--w900" style="margin-top:-10%;">
<div class="card card-6">
<div class="row" style="padding-top:1%;padding-left:1%;padding-down:1%; color:white; font-weight:bold; background-color:#4c5c51; border-radius:15px;">
<p>Welcome to Admin<br><br> <i>
<a href="addPlace.jsp" class="fcc-btn" >+Add Place</a>
<a href="addAirline.jsp" class="fcc-btn">+Add Airline</a>
<a href="addFlight.jsp" class="fcc-btn">+Add Flight</a>
<i style="background-color: #4287f5;padding: 15px 25px;">View Flight</i>
<a href="changePassword.jsp" class="fcc-btn">+Change Password</a></i></p></div>
<div class="card-body">
<form method="POST" action="" autocomplete="off">
<div class="row row-space">
<div class="col-4" style="margin-top:0%;">
<%
FlightService fs = new FlightService();
List<Flight>listOfFlight = fs.findAllFlight();

if(listOfFlight!= null){
Iterator<Flight> lf = listOfFlight.iterator();
%>
<table style="align:center;background-color:white;">
<caption style="background-color:#4287f5; color:white;font-weight:bold;padding:1%;">Airline List</caption>
<tr><th>FlightID</th>
<th>AirlineName</th>
<th>FlightDate</th>
<th>Source</th>
<th>Destination</th>
<th>Price(TSH)</th>
</tr>
<%
while(lf.hasNext()){
	Flight f = lf.next();
	AirlineService as = new AirlineService();
	String airlnname =as.findAirline(f.getFairline());
	PlaceService ps =new PlaceService();
	String sourcename = ps.findPlace(f.getFsource());
	String destinationname =ps.findPlace(f.getFdestination());
	%>
	<tr><td id="pn"><%=f.getFid() %></td>
	<td id="pdts"> <%=airlnname %></td>
	<td id="pdts"><%=f.getFdate() %></td>
	<td id="pdts"><%=sourcename %></td>
	<td id="pdts"><%=destinationname %></td>
	<td id="pn"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "<%=f.getFprice() %>" /></td>
</tr>
	<% } %>
</table>
<% } %>
</div>
</div>

<div class="row row-space">


</div>
</form>

</div>
</div>

</div>
</div>


	


</body>

</html>

