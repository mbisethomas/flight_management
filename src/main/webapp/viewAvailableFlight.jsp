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
<p>Available Flight Based on Your Searching <br><br><i>Kindly Select Flight and Continue with Booking</i><br></p></div>
<div class="card-body">
<form method="POST" action="" autocomplete="off">
<div class="row row-space">

<div class="col-4" style="margin-top:0%;">
<%
AirlineService as = new AirlineService();
PlaceService ps =new PlaceService();
Object obj = request.getAttribute("listOfAvailabeFlight");
List<Flight> avflight = (List)obj;
if(avflight!=null){
%>
<table style="align:center;background-color:white;">
<caption style="background-color:#4287f5; color:white;font-weight:bold;padding:1%;">Available Flight</caption>
<tr><th>FlightID</th>
<th>AirlineName</th>
<th>FlightDate</th>
<th>Source</th>
<th>Destination</th>
<th>Price(TSH)</th>
<th></th>
</tr>
<%
Iterator<Flight> liofavflight = avflight.iterator();
while(liofavflight.hasNext()){
	Flight f = liofavflight.next();
	String airlnname =as.findAirline(f.getFairline());
	String sourcename = ps.findPlace(f.getFsource());
	String destinationname =ps.findPlace(f.getFdestination());
	%>

<tr><td><%=f.getFid()%></td>
<td id="pn"><%=airlnname%></td>
	<td id="pdts"><%=f.getFdate()%></td>
	<td id="pdts"><%=sourcename%></td>
	<td id="pdts"><%=destinationname%></td>
	<td id="pdts"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "<%=f.getFprice() %>" /></td>
	<td><a href="CustomerController?fid=<%=f.getFid()%>&fare=<%=f.getFprice() %>">Book Now</a></td>
</tr>
<% } %>
</table>
<% } else { %> <p style="color:white;">SORRY! NO FLIGHT MATCH YOUR REQUEST</p> <% } %>

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

