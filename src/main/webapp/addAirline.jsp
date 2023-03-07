<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="modal.Airline"%>
<%@page import="service.AirlineService"%>
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
<i style="background-color: #4287f5;padding: 15px 25px;">+Add Airline</i>
<a href="addFlight.jsp" class="fcc-btn">+Add Flight</a>
<a href="viewFlight.jsp" class="fcc-btn">View Flight</a>
<a href="changePassword.jsp" class="fcc-btn">+Change Password</a></i></p></div>
<div class="card-body">
<form method="POST" action="AirlineController" autocomplete="off">
<div class="row row-space">
<div class="col-2">
<div class="input-group">
<label class="label">Airline Name</label>
<input class="input--style-1" type="text" name="aname" placeholder="Airline Name-Nunber" required="required">
</div>
<div class="">
<button class="btn-submit m-b-0" type="submit">save</button>
</div>
</div>
<div class="col-2" style="margin-top:0%;">
<%
AirlineService as = new AirlineService();
List<Airline>listOfAirline = as.findAllAirline();

if(listOfAirline!= null){
Iterator<Airline> li = listOfAirline.iterator();
%>
<table style="align:center;background-color:white;">
<caption style="background-color:#4287f5; color:white;font-weight:bold;padding:1%;">Airline List</caption>
<tr><th>AirlineID</th><th>AirlineName</th></tr>
<%
while(li.hasNext()){
	Airline a = li.next();
	%>
	<tr><td id="pn"><%=a.getAid() %></td>
	<td id="pdts"><%=a.getAname() %></td>
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

