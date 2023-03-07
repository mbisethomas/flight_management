<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="modal.Place"%>
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
<i style="background-color: #4287f5;padding: 15px 25px;">+Add Place</i>
<a href="addAirline.jsp" class="fcc-btn">+Add Airline</a>
<a href="addFlight.jsp" class="fcc-btn">+Add Flight</a>
<a href="viewFlight.jsp" class="fcc-btn">View Flight</a>
<a href="changePassword.jsp" class="fcc-btn">+Change Password</a></i></p></div>
<div class="card-body">
<form method="POST" action="PlaceController" autocomplete="off">
<div class="row row-space">
<div class="col-2">
<div class="input-group">
<label class="label">Place Name</label>
<input class="input--style-1" type="text" name="pname" placeholder="City/Region , Airport" required="required">
</div>
<div class="">
<button class="btn-submit m-b-0" type="submit">save</button>
</div>
</div>
<div class="col-2" style="margin-top:0%;">
<%
PlaceService ps = new PlaceService();
List<Place>listOfPlace = ps.findAllPlace();

if(listOfPlace!= null){
Iterator<Place> li = listOfPlace.iterator();
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

<div class="row row-space">


</div>
</form>

</div>
</div>

</div>
</div>


	


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS 

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script src="js/bootstrap.min.js">
		
	</script>
	<script src="https://use.fontawesome.com/releases/v5.5.0/js/all.js"></script>
-->
</body>

</html>

