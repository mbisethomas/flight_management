<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="modal.Place"%>
<%@page import="modal.Airline"%>
<%@page import="service.PlaceService"%>
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
<%
        		String success = (String)request.getAttribute("SUCCESS");
                if(success != null){		
        	%>
		<div
			class="alert alert-success alert-dismissible fade show text-center font-weight-bold mt-5"
			role="alert">
			<%= success %>
			<i class="fas fa-check-circle ml-2 fa-2x"></i>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<%}%>


		<%
        		String fail = (String)request.getAttribute("FAIL");
                if(fail != null){		
        %>
		<div
			class="alert alert-danger alert-dismissible fade show text-center font-weight-bold mt-5"
			role="alert">
			<%= fail %>
			<i class="fas fa-times-circle ml-2 fa-2x"></i>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<%}%>
<%
PlaceService ps = new PlaceService();
List<Place>listOfPlace = ps.findAllPlace();
Iterator<Place> lt = listOfPlace.iterator();

AirlineService as = new AirlineService();
List<Airline>listOfAirline = as.findAllAirline();
Iterator<Airline> la = listOfAirline.iterator();
%>		
<div class="page-wrapper bg-img-3 p-t-240 p-b-120">
<div class="wrapper wrapper--w900" style="margin-top:-10%;">
<div class="card card-6">
<div class="row" style="padding-top:1%;padding-left:1%;padding-down:1%; color:white; font-weight:bold; background-color:#4c5c51; border-radius:15px;">
<p>Welcome to Admin<br><br> <i>
<a href="addPlace.jsp" class="fcc-btn" >+Add Place</a>
<a href="addAirline.jsp" class="fcc-btn">+Add Airline</a>
<i style="background-color: #4287f5;padding: 15px 25px;">+Add Flight</i>
<a href="viewFlight.jsp" class="fcc-btn">View Flight</a>
<a href="changePassword.jsp" class="fcc-btn">+Change Password</a></i></p></div>
<div class="card-body">
<form method="POST" action="FlightController" autocomplete="off">
<div class="row row-space">
<div class="col-2">
<div class="input-group">
<label class="label">Airline Name</label>
<select class="form-control input--style-1" id="fairline" name="fairline">
<option selected value="selected">Select</option>
<% while(la.hasNext()){
	Airline a = la.next();
	%> 
<option value="<%=a.getAid() %>"><%=a.getAname() %></option>
	<% } %>
</select>
</div>
</div>
<div class="col-2">
<div class="input-group">
<label class="label">Date of Flight</label>
<input class="input--style-1" type="date" name="fdate" placeholder="Flight Date" required="required">
</div>
</div>
</div>
<div class="row row-space">
<div class="col-2">
<div class="input-group">
<label class="label">Source</label>
<select class="form-control input--style-1" id="fsource" name="fsource">
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
<label class="label">Destination</label>
<select class="form-control input--style-1" id="fdestination" name="fdestination">
<option selected value="selected">Select</option>
<% Iterator<Place> ld = listOfPlace.iterator();
  while(ld.hasNext()){
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
<label class="label">Price</label>
<input class="input--style-1" type="text" name="fprice" placeholder="Flight Price" required="required">
</div>
</div>
<div class="col-2">
<button class="btn-submit m-b-0" type="submit">save</button>
</div>
</div>


<div class="row row-space">
<div class="col-2" style="margin-top:0%;">
<%
Object obj = request.getAttribute("listOfPlace");
if(obj!= null){
List<Place> ll =(List)obj;
Iterator<Place> li = ll.iterator();
%>
<table style="align:center;background-color:white;">
<caption style="background-color:#4287f5; color:white;font-weight:bold;padding:1%;">Place List</caption>
<tr><th>PlaceID</th><th>PlaceName</th></tr>
<%
while(li.hasNext()){
	Place p = li.next();
	%>
	<tr><td id="pn"><%=p.getPid() %></td>
	<td id="pdts"><%=p.getPname() %></td>
</tr>
	<% } %>
</table>
<% } %>
</div>

</div>
</form>

</div>
</div>

</div>
</div>


	


</body>

</html>

