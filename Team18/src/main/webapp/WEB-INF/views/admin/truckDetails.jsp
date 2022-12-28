<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>



<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script type="text/javascript">
	function alertbtn() {
		alert('Alert Sent Succesfully');
	}
	 function display_c() {
         var refresh = 1000; // Refresh rate in milli seconds
         mytime = setTimeout('display_ct()', refresh)
     }
     function display_ct() {
    	 var num = Math.floor(Math.random()*45) + 1; // this will get a number between 1 and 99;
    	 num *= Math.round(Math.random(),1) ? 1 : -1;
         /* var x = Math.random() ; */
    	 
         /* var x = new Date() */
         document.getElementById('ct').innerHTML = num;
         display_c();
     }
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Truck Details -- ADMIN</title>
<div class="sticky-top">
	<!--  navbar -->
	<nav class="navbar navbar-expand-lg" style="background-color:black;">
	<div class="container-fluid">
		<div class="container-fluid">
			<a class="navbar-brand" href="/admin/adminHome"> <img
				src="data:image/png;base64,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"
				alt="Logo" width="75" height="75"
				class="d-inline-block align-text-center " style="font: size 10px;">
				<h3 style="font-size: 35px; color: white; display: inline-block;">
					Dart Express Logistics</h3>
		</div>
		</a>


		<li class="nav-item"><a
			class="nav-link active d-inline-block align-top text-white "
			aria-current="page" href="/contactUs">Contact Us</a></li>


		<li class="nav-item"><a
			class="nav-link active d-inline-block align-top text-white "
			aria-current="page" href="/aboutUs">About Us</a></li>

		<li class="nav-item"><a
			class="nav-link active d-inline-block align-top text-white "
			aria-current="page" href="/admin/adminHome">Home</a></li>
	</div>
</div>

</ul>
</div>
</div>
</nav>
</div>
</head>


<body onload=display_ct();>
	<div class="bg-image"
		style="background-image: url('https://images.pexels.com/photos/3760081/pexels-photo-3760081.jpeg?auto=compress&cs=tinysrgb&w=1600'); height: 100vh; background-size: cover;">








		<div class="collapse navbar-collapse" id="navbarSupportedContent">

		</div>

		<center>
			<h2>Truck Details</h2>

			<div class="card" style="width: 39rem;">
				<div class="card-body">
					<h5 class="card-title">
						Note <i class="fa fa-exclamation-circle" aria-hidden="true"></i>
					</h5>

					<p class="card-text">Optimum temperature for Food items between
						14 C to 25 C, Medicines/Icecreams between -10 C to 5 C</p>

				</div>
			</div>

		</center>
		<br>
		<!-- Table to display Truck details -->
		<div class="table-responsive">
			<table class="table table-hover table-secondary table-striped">
				<thead>
					<tr>
						<td>Truck Id</td>
						<td>Driver Name</td>
						<td>Driver Contact number</td>
						<td data-toggle="tooltip" data-placement="top"
							title="Optimum temperature for Food items between 14 C to 25 C, Medicines/Icecreams between -10 C to 5 C  ">Live
							Temperature</td>
						<td>Send Alerts</td>
						<td>Live Location</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${TruckDetails}" var="TruckDetails">
					<tr>
							<td>${TruckDetails.truckId}</td>
							<td>${TruckDetails.driverName}</td>
							<td>${TruckDetails.driverPhNum}</td>
							<!-- <td>
								<div class="text-dark" id="ct" "></div>
							</td> -->
							<td>temp</td>
							<%-- <td>Math.round(${TruckDetails.temp},1)</td> --%>

							<!--                         <td><div class="text-dark" id="ct"></div></td> -->
							<td>
								<form action="/alert/${TruckDetails.truckId}" method="POST"
									class="form-signin  ">
									<button class="btn btn-dark  btn-block" name="Alert"
										value="Alert" type="Submit" data-toggle="tooltip"
										data-placement="top" title="Send Alerts to the driver">Alert</button>

								</form>
							</td>
							<td><a
								href="https://www.google.com/maps/place/Valtech/@12.9164417,77.5968254,17z/data=!3m1!4b1!4m5!3m4!1s0x3bae150e413b549d:0x24ddb1c1c2c81592!8m2!3d12.9164365!4d77.5990141">
									<button class="btn  btn-md btn-warning" data-toggle="tooltip"
										data-placement="top" title="View Current Location">
										<i class="fa fa-location-arrow"></i>Current Location
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
</body>

<!-- Footer -->
<footer class="bg-light text-lg-start">

</div>
<hr class="m-0" />


<div class="text-align-right p-3 text-white"
	style="background-color: black;">
	  2020 Copyright: <a class="text-white" href="/aboutUs">delogistics.com</a>
</div>
</footer>
</html>

