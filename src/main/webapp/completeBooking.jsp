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
<% String custfirstname =(String)session.getAttribute("custfirstname");
String custlastname =(String)session.getAttribute("custlastname");%>
			
<div class="page-wrapper bg-img-3 p-t-240 p-b-120">
<div class="wrapper wrapper--w900" style="margin-top:-10%;">
<div class="card card-6">
<div class="row" style="padding-top:1%;padding-left:1%;padding-down:1%; color:white; font-weight:bold; background-color:#4c5c51; border-radius:15px;">
<p>Hi <%=custfirstname %> <%=custlastname %> <br><br><i>Kindly Select Payment to Complete Booking</i><br></p></div>
<div class="card-body">
<form method="POST" action="" autocomplete="off">
<div class="row row-space">

<div class="col-4" style="margin-top:0%;">
<%
AirlineService as = new AirlineService();
PlaceService ps =new PlaceService();
Object obj = session.getAttribute("clistOfAvailabeFlight");
List<Flight> avflight = (List)obj;
if(avflight!=null){
%>
<table style="align:center;background-color:white;">
<caption style="background-color:#4287f5; color:white;font-weight:bold;padding:1%;">Selected Flight</caption>
<tr><th>FlightID</th>
<th>AirlineName</th>
<th>FlightDate</th>
<th>Source</th>
<th>Destination</th>

</tr>
<%
Iterator<Flight> liofavflight = avflight.iterator();
while(liofavflight.hasNext()){
	Flight f = liofavflight.next();
	String airlnname =as.findAirline(f.getFairline());
	String sourcename = ps.findPlace(f.getFsource());
	String destinationname =ps.findPlace(f.getFdestination());
	Integer ffid =(Integer)session.getAttribute("cflightid");
	if(f.getFid()==ffid){
	%>

<tr><td><%=f.getFid()%></td>
<td id="pn"><%=airlnname%></td>
	<td id="pdts"><%=f.getFdate()%></td>
	<td id="pdts"><%=sourcename%></td>
	<td id="pdts"><%=destinationname%></td>

	
</tr>
<% }} %>
</table>
<% }  %>
<table style="align:center;background-color:white;">
<caption style="background-color:#4287f5; color:white;font-weight:bold;padding:1%;">Passenger Ticket</caption>
<tr><th>Name</th>
<th>TicketNo</th>
<th>SeatNo</th>
<th>Price(TSH)</th>

</tr>
<%

	Integer nofpass =(Integer)session.getAttribute("cnoPassenger");
   Float cprice =(Float)session.getAttribute("cprice");
	for(int i=0; i<nofpass; i++){
		String tickt=(String)session.getAttribute("customerticketno"+i+"");
		Integer seat=(Integer)session.getAttribute("customerseatno"+i+"");	
	%>

<tr><td>Passenger <%=i+1%></td>
<td id="pdts"><%=tickt%></td>
	<td id="pdts"><%=seat%></td>
	<td id="pdts"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "<%=cprice %>" /></td>
	
</tr>
<% } %>

</table>
<% float totalcost=(cprice*nofpass); 
Integer customerId =(Integer)session.getAttribute("customerId");
Integer cflightid =(Integer)session.getAttribute("cflightid");%>
 <table style="align:center;background-color:white;">
<caption style="background-color:#4287f5; color:white;font-weight:bold;padding:1%;">Confirm and Pay</caption>
<tr><th>Number of Ticket</th>
<th>Total Cost</th>
<th>Payment</th>
</tr><tr>
<td id="pdts"><%=nofpass%></td>
	<td id="pdts"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "<%=totalcost %>" /></td>
	<td><a href="BookController?fcid=<%=customerId%>&nofp=<%=nofpass%>&cfid=<%=cflightid%>&totl=<%=totalcost %>" class="fcc-btn">FLYPay</a></td>
	
</tr>
</table>
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

