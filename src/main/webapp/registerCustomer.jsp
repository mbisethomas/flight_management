<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<p>Hello! , Kindly Register to Continue with Booking<br><br>
</p></div>
<div class="card-body">
<form method="POST" action="CustomerController" autocomplete="off">

<div class="row row-space">
<div class="col-2">
<div class="input-group">
<label class="label">FistName</label>
<input class="input--style-1" type="text" name="cfirstname" placeholder="Enter FirstName" required="required">
</div>
</div>
<div class="col-2">
<div class="input-group">
<label class="label">LastName</label>
<input class="input--style-1" type="text" name="clastname" placeholder="Enter LastName" required="required">
</div>
</div>
</div>
<div class="row row-space">
<div class="col-2">
<div class="input-group">
<label class="label">Phone Number</label>
<input class="input--style-1" type="text" name="cphone" placeholder="Enter Phone Number" required="required">
</div>
</div>
<div class="col-2">
<div class="input-group">
<button class="btn-submit m-b-0" type="submit">Register and Continue</button>
</div>
</div>
</div>

</form>

</div>
</div>

</div>
</div>


	



</body>

</html>

