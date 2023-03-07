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
<p>Welcome to FLYAWAY-ADMIN PORTAL<br><br> <i>
<i style="background-color: #4287f5;padding: 15px 25px;">+ADMIN lOGIN</i>
</p></div>
<div class="card-body">
<form method="POST" action="LoginController" autocomplete="off">
<%
        		String fail = (String)request.getAttribute("loginerr1");
                if(fail != null){		
        	%>
					<div
						class="alert alert-danger alert-dismissible fade show text-center font-weight-bold"
						role="alert">
						<%= fail %>
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<%}%>
<div class="row row-space">
<div class="col-2">
<div class="input-group">
<label class="label">Email</label>
<input class="input--style-1" type="email" name="adminemail" placeholder="Email" required="required">
</div>
</div>
<div class="col-2">
<div class="input-group">
<label class="label">Password</label>
<input class="input--style-1" type="password" name="adminPassword" placeholder="" required="required">
</div>
</div>
</div>

<div class="row row-space">
<div class="col-2">
<button class="btn-submit m-b-0" type="submit">Login</button>
</div>

</div>
</form>

</div>
</div>

</div>
</div>


	



</body>

</html>

